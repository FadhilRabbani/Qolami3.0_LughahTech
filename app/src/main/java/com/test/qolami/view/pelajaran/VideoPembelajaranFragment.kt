package com.test.qolami.view.pelajaran

import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.common.Player


import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.test.qolami.R
import com.test.qolami.databinding.FragmentVideoPembelajaranBinding
import com.test.qolami.model.network.RetrofitClient
import com.test.qolami.view.pelajaran.data.IsiPelajaran
import com.test.qolami.view.pelajaran.data.PelajaranResponse
import com.test.qolami.viewnodel.PelajaranHurufViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Suppress("DEPRECATION")
@AndroidEntryPoint
class VideoPembelajaranFragment : Fragment() {
    private lateinit var binding: FragmentVideoPembelajaranBinding
    private lateinit var pelajaranHurufViewModel: PelajaranHurufViewModel
    private lateinit var youTubePlayerView: YouTubePlayerView
    private lateinit var exoPlayer: ExoPlayer
    private var youTubePlayer: YouTubePlayer? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentVideoPembelajaranBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backImg.setOnClickListener {
            findNavController().navigateUp()
        }
        exoPlayer = ExoPlayer.Builder(requireContext()).build()
        pelajaranHurufViewModel = ViewModelProvider(this).get(PelajaranHurufViewModel::class.java)
        youTubePlayerView = binding.ytPlayer
        val getJudul = this.arguments?.get("judul")
        binding.textPelajaran.text = getJudul.toString()
        when (binding.textPelajaran.text.toString()) {
            "Pelajaran 2" -> {
                return PelajaranFathah()
            }
            "Pelajaran 3" -> {
                return PelajaranKasroh()
            }
            "Pelajaran 4" -> {
                return PelajaranDhammah()
            }
            "Pelajaran 5" -> {
                return PelajaranFathahtain()
            }
            "Pelajaran 6" -> {
                return PelajaranKasrahtain()
            }
            "Pelajaran 7" -> {
                return PelajaranDhammahtain()
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        youTubePlayerView.release()
        youTubePlayer = null
    }
    override fun onPause() {
        super.onPause()
        youTubePlayer?.pause()
    }

    private fun PelajaranFathah() {
        val getId2 = this.arguments?.get("id2")
        val data2 = pelajaranHurufViewModel.hurufListFathah
        for (i in data2.indices) {
            var getDataId2 = data2[i].id
            if (getDataId2 == getId2) {
                binding.textJudul.text = data2[i].pelajaran
                youTubePlayerView.addYouTubePlayerListener(object :
                    AbstractYouTubePlayerListener() {
                    override fun onReady(player: YouTubePlayer) {
                        youTubePlayer = player
                        player.cueVideo(data2[i].idYoutube, 0f)
                    }

                    override fun onStateChange(
                        youTubePlayer: YouTubePlayer,
                        state: PlayerConstants.PlayerState
                    ) {
                        if (state == PlayerConstants.PlayerState.ENDED){
                            youTubePlayer.seekTo(0f)
                            youTubePlayer.play()
                        }
                    }
                })
                binding.detail.text = data2[i].detail
                Glide.with(this).load(data2[i].gambar).into(binding.gambarPelajaran)
            }
        }
    }


    private fun PelajaranKasroh() {
        val getId3 = this.arguments?.get("id3")
        val data3 = pelajaranHurufViewModel.hurufListKasrah
        for (i in data3.indices) {
            var getDataId3 = data3[i].id
            if (getDataId3 == getId3) {
                binding.textJudul.text = data3[i].pelajaran
                youTubePlayerView.addYouTubePlayerListener(object :
                    AbstractYouTubePlayerListener() {
                    override fun onReady(player: YouTubePlayer) {
                        youTubePlayer = player
                        player.cueVideo(data3[i].idYoutube, 0f)
                    }

                    override fun onStateChange(
                        youTubePlayer: YouTubePlayer,
                        state: PlayerConstants.PlayerState
                    )
                    {
                        if (state == PlayerConstants.PlayerState.ENDED)
                            youTubePlayer.seekTo(0f)
                        youTubePlayer.play()
                    }
                })
                binding.detail.text = data3[i].detail
                Glide.with(this).load(data3[i].gambar).into(binding.gambarPelajaran)
            }
        }

    }

    private fun PelajaranDhammah() {
        val getId4 = this.arguments?.get("id4")
        val data4 = pelajaranHurufViewModel.hurufListDhammah
        for (i in data4.indices) {
            var getDataId4 = data4[i].id
            if (getDataId4 == getId4) {
                binding.textJudul.text = data4[i].pelajaran
                youTubePlayerView.addYouTubePlayerListener(object :
                    AbstractYouTubePlayerListener() {
                    override fun onReady(player: YouTubePlayer) {
                        youTubePlayer = player
                        player.cueVideo(data4[i].idYoutube, 0f)
                    }

                    override fun onStateChange(
                        youTubePlayer: YouTubePlayer,
                        state: PlayerConstants.PlayerState
                    ) {
                        if (state == PlayerConstants.PlayerState.ENDED)
                            youTubePlayer.seekTo(0f)
                        youTubePlayer.play()
                    }
                })
                binding.detail.text = data4[i].detail
                Glide.with(this).load(data4[i].gambar).into(binding.gambarPelajaran)
            }
        }

    }
    private fun PelajaranFathahtain() {
        val getId5 = this.arguments?.get("id5")
        val data5 = pelajaranHurufViewModel.hurufListFathahtain
        for (i in data5.indices) {
            var getDataId5 = data5[i].id
            if (getDataId5 == getId5) {
                binding.textJudul.text = data5[i].pelajaran
                youTubePlayerView.addYouTubePlayerListener(object :
                    AbstractYouTubePlayerListener() {
                    override fun onReady(player: YouTubePlayer) {
                        youTubePlayer = player
                        player.cueVideo(data5[i].idYoutube, 0f)
                    }

                    override fun onStateChange(
                        youTubePlayer: YouTubePlayer,
                        state: PlayerConstants.PlayerState
                    ) {
                        if (state == PlayerConstants.PlayerState.ENDED)
                            youTubePlayer.seekTo(0f)
                        youTubePlayer.play()
                    }
                })
                binding.detail.text = data5[i].detail
                Glide.with(this).load(data5[i].gambar).into(binding.gambarPelajaran)
            }
        }

    }
    private fun PelajaranKasrahtain(){
        val getId6 = this.arguments?.get("id6")
        val data6 = pelajaranHurufViewModel.hurufListKasrahtain
        for (i in data6.indices) {
            var getDataId6 = data6[i].id
            if (getDataId6 == getId6) {
                binding.textJudul.text = data6[i].pelajaran
                youTubePlayerView.addYouTubePlayerListener(object :
                    AbstractYouTubePlayerListener() {
                    override fun onReady(player: YouTubePlayer) {
                        youTubePlayer = player
                        player.cueVideo(data6[i].idYoutube, 0f)
                    }

                    override fun onStateChange(
                        youTubePlayer: YouTubePlayer,
                        state: PlayerConstants.PlayerState
                    ) {
                        if (state == PlayerConstants.PlayerState.ENDED)
                            youTubePlayer.seekTo(0f)
                        youTubePlayer.play()
                    }
                })
                binding.detail.text = data6[i].detail
                Glide.with(this).load(data6[i].gambar).into(binding.gambarPelajaran)
            }
        }
    }
    private fun PelajaranDhammahtain(){
        val getId7 = this.arguments?.get("id7")
        val data7 = pelajaranHurufViewModel.hurufListDhammahtain
        for (i in data7.indices) {
            var getDataId7 = data7[i].id
            if (getDataId7 == getId7) {
                binding.textJudul.text = data7[i].pelajaran
                youTubePlayerView.addYouTubePlayerListener(object :
                    AbstractYouTubePlayerListener() {
                    override fun onReady(player: YouTubePlayer) {
                        youTubePlayer = player
                        player.cueVideo(data7[i].idYoutube, 0f)
                    }

                    override fun onStateChange(
                        youTubePlayer: YouTubePlayer,
                        state: PlayerConstants.PlayerState
                    ) {
                        if (state == PlayerConstants.PlayerState.ENDED)
                            youTubePlayer.seekTo(0f)
                        youTubePlayer.play()
                    }
                })
                binding.detail.text = data7[i].detail
                Glide.with(this).load(data7[i].gambar).into(binding.gambarPelajaran)
            }
        }
    }
}
