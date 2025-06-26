package com.test.qolami.view.latihan

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.ui.PlayerView
import com.test.qolami.R
import com.test.qolami.databinding.FragmentSoalLatihanAudioBinding
import com.test.qolami.view.latihan.DataLatihan.SoalAudio
import com.test.qolami.viewnodel.LatihanHurufViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSoalLatihanAudio : Fragment() {
    private lateinit var binding: FragmentSoalLatihanAudioBinding
    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var viewModel: LatihanHurufViewModel

    private var soalList: List<SoalAudio> = emptyList()
    private var currentIndex = 0
    private var selectedOption = -1
    private var correctCount = 0
    private var incorrectCount = 0
    private var player: ExoPlayer? = null
    private var audioEnded = false
    private var isPlaying = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSoalLatihanAudioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefs = requireContext().getSharedPreferences("judul", Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this)[LatihanHurufViewModel::class.java]

        val latihanId = sharedPrefs.getInt("latihanId", -1)
        viewModel.loadSoalAudio(latihanId)
        setupListeners()

        viewModel.soalAudios.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                soalList = it
                currentIndex = 0
                tampilkanSoal(soalList[currentIndex])
            }
        }
    }

    private fun setupListeners() {
        binding.backImg.setOnClickListener { findNavController().navigateUp() }
        listOf(binding.option1, binding.option2, binding.option3, binding.option4).forEachIndexed { i, card ->
            card.setOnClickListener { onOptionSelected(i) }
        }
        binding.buttonCheckSoal.setOnClickListener {
            if (selectedOption != -1) {
                val soal = soalList[currentIndex]
                val jawabanBenar = soal.jawaban
                val userJawaban = listOf(soal.opsi_a, soal.opsi_b, soal.opsi_c, soal.opsi_d)[selectedOption]
                if (jawabanBenar == userJawaban) correctCount++ else incorrectCount++
                lanjutkanSoal()
            }
        }
        binding.playAudio?.setOnClickListener {

            if (isPlaying) {
                player?.pause()
                isPlaying = false
            } else {
                if (audioEnded) player?.seekTo(0)
                player?.play()
                isPlaying = true
            }
        }
    }

    private fun tampilkanSoal(soal: SoalAudio) {
        releasePlayer()
        val context = requireContext()
        player = ExoPlayer.Builder(context).build().also { exoPlayer ->
            binding.exoplayer?.player = exoPlayer
            android.util.Log.d("ExoPlayerLoad", "Loading audio URL: ${soal.media_url}")
            val mediaItem = MediaItem.fromUri(Uri.parse(soal.media_url))
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
            exoPlayer.playWhenReady = false
            audioEnded = false
            exoPlayer.addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(state: Int) {
                    if (state == Player.STATE_ENDED) {
                        isPlaying = false
                        audioEnded = true
                    }
                }
            })
        }

        binding.txtPenjelasan.text = ""
        binding.textJudul.text = sharedPrefs.getString("judulLatihanTampil", "")

        val optionImageViews = listOf(binding.txtJawaban1, binding.txtJawaban2, binding.txtJawaban3, binding.txtJawaban4)
        val optionUrls = listOf(soal.opsi_a, soal.opsi_b, soal.opsi_c, soal.opsi_d)

        optionImageViews.forEachIndexed { index, imageView ->
            Glide.with(this).load(optionUrls[index]).into(imageView as ImageView)
        }

        resetOptionStyles()
    }

    private fun onOptionSelected(index: Int) {
        selectedOption = index
        resetOptionStyles()
        val cards = listOf(binding.option1, binding.option2, binding.option3, binding.option4)
        cards[index].setCardBackgroundColor(resources.getColor(R.color.warna_hijau_muda))
    }

    private fun resetOptionStyles() {
        listOf(binding.option1, binding.option2, binding.option3, binding.option4).forEach {
            it.setCardBackgroundColor(resources.getColor(R.color.white))
        }
    }

    private fun lanjutkanSoal() {
        currentIndex++
        selectedOption = -1
        if (currentIndex < soalList.size) {
            tampilkanSoal(soalList[currentIndex])
        } else {
            val bundle = Bundle().apply {
                putInt("jumlahBenarAudio", correctCount)
                putInt("jumlahSalahAudio", incorrectCount)
                putString("titleAudio", soalList[0].media_url)
                putString("subtitleAudio", binding.textJudul.text.toString())
            }
            findNavController().navigate(R.id.action_fragmentSoalLatihanAudio_to_fragmentHasilLatihanAudio, bundle)
        }
    }

    private fun releasePlayer() {
        player?.release()
        player = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        releasePlayer()
    }
}
