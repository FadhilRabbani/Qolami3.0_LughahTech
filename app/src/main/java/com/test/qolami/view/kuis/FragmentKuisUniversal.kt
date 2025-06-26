package com.test.qolami.view.kuis

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.test.qolami.R
import com.test.qolami.databinding.FragmentKuisUniversalBinding
import com.test.qolami.view.kuis.SoalKuis
import com.test.qolami.view.kuis.JawabanRequest
import com.test.qolami.viewnodel.KuisViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException

@AndroidEntryPoint
class FragmentKuisUniversal : Fragment() {
    private lateinit var binding: FragmentKuisUniversalBinding
    private lateinit var viewModel: KuisViewModel
    private var soalList: List<SoalKuis> = emptyList()
    private var currentIndex = 0
    private var selectedOption = -1
    private var correctCount = 0
    private var mediaPlayer: MediaPlayer? = null
    private var youTubePlayer: YouTubePlayer? = null
    private var isYouTubePlayerReady = false
    private var countDownTimer: CountDownTimer? = null
    private val waktuPerSoal: Long = 10_000L

    private var userId: Int = 0
    private var kuisId: Int = 0
    private val jawabanUserList = mutableListOf<JawabanRequest.JawabanItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentKuisUniversalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        userId = sharedPreferences.getInt("userId", 0)
        Log.d("DEBUG_USER_ID", "User ID yang diambil dari SharedPreferences: $userId")

        viewModel = ViewModelProvider(this)[KuisViewModel::class.java]
        lifecycle.addObserver(binding.ytPlayer)

        userId = arguments?.getInt("user_id") ?: 0
        kuisId = arguments?.getInt("kuisId") ?: 1

        binding.ytPlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(player: YouTubePlayer) {
                youTubePlayer = player
                isYouTubePlayerReady = true
                showQuestion(soalList.getOrNull(currentIndex) ?: return)
            }
        })

        val kategoriNama = arguments?.getString("kategori") ?: "kata"
        viewModel.loadKuis(kategoriNama, kuisId)

        viewModel.soalList.observe(viewLifecycleOwner) {
            soalList = it
            if (soalList.isNotEmpty() && isYouTubePlayerReady) {
                showQuestion(soalList[currentIndex])
            }
        }

        binding.btnNext.setOnClickListener {
            if (selectedOption != -1) {
                countDownTimer?.cancel()
                checkAnswer(soalList[currentIndex])
                selectedOption = -1
                currentIndex++
                if (currentIndex < soalList.size) {
                    showQuestion(soalList[currentIndex])
                } else {
                    val bundle = Bundle().apply {
                        putInt("user_id", userId)
                        putInt("kuis_id", kuisId)
                        putParcelableArrayList("jawaban", ArrayList(jawabanUserList))
                    }
                    findNavController().navigate(R.id.action_kuis_to_hasil_kuis, bundle)
                }
            } else {
                Toast.makeText(requireContext(), "Pilih salah satu jawaban", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showQuestion(soal: SoalKuis) {
        binding.textJudul.text = "Kuis Kata"
        binding.txtPenjelasan.text = if (soal.jenis == "audio") "Dengarkan audionya" else "Tonton videonya"
        binding.audioLayout.visibility = if (soal.jenis == "audio") View.VISIBLE else View.GONE
        binding.videoLayout.visibility = if (soal.jenis == "video") View.VISIBLE else View.GONE
        startTimer()

        val options = listOf(soal.opsi["a"], soal.opsi["b"], soal.opsi["c"], soal.opsi["d"]).filterNotNull()
        val optionImageViews = listOf(binding.imgOptionA, binding.imgOptionB, binding.imgOptionC, binding.imgOptionD)
        val optionCards = listOf(binding.option1, binding.option2, binding.option3, binding.option4)

        optionImageViews.forEachIndexed { i, img ->
            Glide.with(this).load(options[i]).into(img)
            optionCards[i].setCardBackgroundColor(resources.getColor(R.color.white))
            img.setOnClickListener {
                selectedOption = i
                optionCards.forEach { card -> card.setCardBackgroundColor(resources.getColor(R.color.white)) }
                optionCards[i].setCardBackgroundColor(resources.getColor(R.color.warna_hijau_muda))
            }
        }

        mediaPlayer?.release()
        mediaPlayer = null
        binding.ytPlayer.visibility = View.GONE

        if (soal.jenis == "audio") {
            mediaPlayer = MediaPlayer().apply {
                setAudioAttributes(AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build())
                try {
                    setDataSource(soal.file_url)
                    prepare()
                    start()
                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(requireContext(), "Gagal memutar audio", Toast.LENGTH_SHORT).show()
                }
            }

            binding.btnPlayAudio.setOnClickListener {
                mediaPlayer?.seekTo(0)
                mediaPlayer?.start()
            }
        } else if (soal.jenis == "video" && isYouTubePlayerReady) {
            binding.ytPlayer.visibility = View.VISIBLE
            val videoId = extractYoutubeId(soal.file_url)
            Log.d("YOUTUBE_DEBUG", "URL: ${soal.file_url}, ID: $videoId")
            youTubePlayer?.loadVideo(videoId, 0f)
        }
    }

    private fun startTimer() {
        countDownTimer?.cancel()
        binding.progressBar.max = (waktuPerSoal / 1000).toInt()
        binding.progressBar.progress = binding.progressBar.max
        binding.txtCountdown.text = (waktuPerSoal / 1000).toString()

        countDownTimer = object : CountDownTimer(waktuPerSoal, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val detik = (millisUntilFinished / 1000).toInt()
                binding.progressBar.progress = detik
                binding.txtCountdown.text = detik.toString()

                val drawableRes = when {
                    detik in 8..10 -> R.drawable.progress_green
                    detik in 4..7 -> R.drawable.progress_orange
                    else -> R.drawable.progress_red
                }
                binding.progressBar.progressDrawable = ContextCompat.getDrawable(requireContext(), drawableRes)
            }

            override fun onFinish() {
                binding.txtCountdown.text = "0"
                Toast.makeText(requireContext(), "Waktu habis!", Toast.LENGTH_SHORT).show()
                checkAnswer(soalList[currentIndex])
                selectedOption = -1
                currentIndex++
                if (currentIndex < soalList.size) {
                    showQuestion(soalList[currentIndex])
                } else {
                    val bundle = Bundle().apply {
                        putInt("user_id", userId)
                        putInt("kuis_id", kuisId)
                        putParcelableArrayList("jawaban", ArrayList(jawabanUserList))
                    }
                    findNavController().navigate(R.id.action_kuis_to_hasil_kuis, bundle)
                }
            }
        }.start()
    }

    private fun checkAnswer(soal: SoalKuis) {
        val options = listOf(soal.opsi["a"], soal.opsi["b"], soal.opsi["c"], soal.opsi["d"]).filterNotNull()
        val jawabanDipilih = if (selectedOption != -1 && selectedOption < options.size) {
            options[selectedOption]
        } else {
            // Jawaban kosong karena tidak dijawab → anggap salah
            "kosong"
        }

        if (jawabanDipilih == soal.jawaban) {
            correctCount++
        }

        jawabanUserList.add(
            JawabanRequest.JawabanItem(
                soal_id = soal.id,
                jenis = soal.jenis,
                jawaban_user = jawabanDipilih
            )
        )

        Log.d("KUIS_DEBUG", "Jawaban benar sejauh ini: $correctCount dari ${jawabanUserList.size}")
    }



    private fun extractYoutubeId(url: String): String {
        val regex = "(?<=v=|be/|embed/)[^&?\\n]+".toRegex()
        return regex.find(url)?.value ?: ""
    }

    override fun onDestroyView() {
        super.onDestroyView()
        countDownTimer?.cancel()
        mediaPlayer?.release()
        mediaPlayer = null
        youTubePlayer = null
    }
}