package com.test.qolami.view.latihan

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.test.qolami.R
import com.test.qolami.databinding.FragmentSoalLatihanVideosBinding
import com.test.qolami.view.latihan.DataLatihan.SoalVideo
import com.test.qolami.viewnodel.LatihanHurufViewModel
import com.test.qolami.viewnodel.LatihanKataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSoalLatihanVideos : Fragment() {
    private lateinit var binding: FragmentSoalLatihanVideosBinding
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var latihanHurufViewModel: LatihanHurufViewModel
    private lateinit var latihanKataViewModel: LatihanKataViewModel

    private lateinit var soalList: List<SoalVideo>
    private lateinit var youTubePlayerView: YouTubePlayerView
    private var youTubePlayer: YouTubePlayer? = null
    private var indexTerkini = 0
    private var indexYangDipilih = -1
    private lateinit var optionCards: List<CardView>
    private lateinit var optionImages: List<ImageView>
    private var jumlahBenar = 0
    private var jumlahSalah = 0
    private var jawabanBenarList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSoalLatihanVideosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("judul", Context.MODE_PRIVATE)
        val judul = sharedPreferences.getString("judulLatihanTampil", "Latihan Huruf") ?: ""
        val latihanId = sharedPreferences.getInt("latihanId", -1)

        binding.textJudul.text = judul
        Log.d("SoalLatihan", "Judul tampil = $judul")

        optionCards = listOf(binding.option1, binding.option2, binding.option3, binding.option4)
        optionImages = listOf(binding.imgOptionA!!, binding.imgOptionB!!, binding.imgOptionC!!, binding.imgOptionD!!)

        setupYouTubePlayer()
        setupListeners()

        if (latihanId != -1) {
            if (judul.contains("Kata", ignoreCase = true)) {
                // Latihan Kata
                latihanKataViewModel = ViewModelProvider(this)[LatihanKataViewModel::class.java]
                latihanKataViewModel.loadSoalKata(latihanId)
                latihanKataViewModel.soalVideos.observe(viewLifecycleOwner) { list ->
                    if (list.isNotEmpty()) {
                        soalList = list
                        tampilkanSoal(soalList[indexTerkini])
                    }
                }
            } else {
                // Latihan Huruf
                latihanHurufViewModel = ViewModelProvider(this)[LatihanHurufViewModel::class.java]
                latihanHurufViewModel.loadSoalVideo(latihanId)
                latihanHurufViewModel.soalVideos.observe(viewLifecycleOwner) { list ->
                    if (list.isNotEmpty()) {
                        soalList = list
                        tampilkanSoal(soalList[indexTerkini])
                    }
                }
            }
        }
    }

    private fun setupYouTubePlayer() {
        youTubePlayerView = binding.ytPlayer
        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(player: YouTubePlayer) {
                youTubePlayer = player
                if (::soalList.isInitialized && soalList.isNotEmpty()) {
                    youTubePlayer?.cueVideo(extractYoutubeId(soalList[indexTerkini].media_url), 0f)
                }
            }
        })
    }

    private fun setupListeners() {
        binding.backImg.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.option1.setOnClickListener { onOptionSelected(0) }
        binding.option2.setOnClickListener { onOptionSelected(1) }
        binding.option3.setOnClickListener { onOptionSelected(2) }
        binding.option4.setOnClickListener { onOptionSelected(3) }

        binding.buttonCheckSoal.setOnClickListener {
            if (indexYangDipilih != -1) {
                if (checkSoal(soalList[indexTerkini])) {
                    jawabanBenarList.add("Benar")
                    jumlahBenar++
                } else {
                    jawabanBenarList.add("Salah")
                    jumlahSalah++
                }
                resetOptions()
                lanjutSoal()
            }
        }
    }

    private fun onOptionSelected(index: Int) {
        resetOptions()
        indexYangDipilih = index
        optionImages[index].setColorFilter(resources.getColor(R.color.white))
        optionCards[index].setCardBackgroundColor(resources.getColor(R.color.warna_hijau_muda))
    }

    private fun resetOptions() {
        indexYangDipilih = -1
        optionCards.forEach { it.setCardBackgroundColor(resources.getColor(R.color.white)) }
        optionImages.forEach { it.clearColorFilter() }
    }

    private fun tampilkanSoal(soal: SoalVideo) {
        Log.d("DEBUG_YOUTUBE", "media_url = ${soal.media_url}")
        Log.d("DEBUG_YOUTUBE", "Extracted ID = ${extractYoutubeId(soal.media_url)}")
        val youtubeId = extractYoutubeId(soal.media_url)
        if (youtubeId.isNotBlank()) {
            youTubePlayer?.cueVideo(youtubeId, 0f)
        } else {
            Log.e("DEBUG_YOUTUBE", "YouTube ID tidak valid dari URL: ${soal.media_url}")
        }

        Glide.with(this).load(soal.opsi_a).into(binding.imgOptionA!!)
        Glide.with(this).load(soal.opsi_b).into(binding.imgOptionB!!)
        Glide.with(this).load(soal.opsi_c).into(binding.imgOptionC!!)
        Glide.with(this).load(soal.opsi_d).into(binding.imgOptionD!!)

        resetOptions()
    }

    private fun checkSoal(soal: SoalVideo): Boolean {
        return when (indexYangDipilih) {
            0 -> soal.opsi_a == soal.jawaban
            1 -> soal.opsi_b == soal.jawaban
            2 -> soal.opsi_c == soal.jawaban
            3 -> soal.opsi_d == soal.jawaban
            else -> false
        }
    }

    private fun lanjutSoal() {
        indexTerkini++
        if (indexTerkini < soalList.size) {
            tampilkanSoal(soalList[indexTerkini])
        } else {
            val bundle = Bundle()
            bundle.putStringArrayList("jawabanBenarList", ArrayList(jawabanBenarList))
            bundle.putInt("jumlahBenar", jumlahBenar)
            bundle.putInt("jumlahSalah", jumlahSalah)
            findNavController().navigate(R.id.action_fragmentSoalLatihanVideos_to_fragmentHasilLatihanVideos, bundle)
        }
    }

    private fun extractYoutubeId(url: String): String {
        val regex = "(?<=v=|be/|embed/)[^&?\\n]+".toRegex()
        return regex.find(url)?.value ?: ""
    }
}
