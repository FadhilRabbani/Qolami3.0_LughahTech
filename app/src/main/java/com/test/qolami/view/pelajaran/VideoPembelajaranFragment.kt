package com.test.qolami.view.pelajaran

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.test.qolami.R
import com.test.qolami.databinding.FragmentVideoPembelajaranBinding
import com.test.qolami.viewnodel.PelajaranHurufViewModel
import dagger.hilt.android.AndroidEntryPoint


@Suppress("DEPRECATION")
@AndroidEntryPoint
class VideoPembelajaranFragment : Fragment() {
    private lateinit var binding: FragmentVideoPembelajaranBinding
    private lateinit var pelajaranHurufViewModel: PelajaranHurufViewModel
    private lateinit var youTubePlayerView: YouTubePlayerView
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
        pelajaranHurufViewModel = ViewModelProvider(this).get(PelajaranHurufViewModel::class.java)
        youTubePlayerView = binding.ytPlayer
        val getJudul = this.arguments?.get("judul")
        binding.textPelajaran.text = getJudul.toString()
        when (binding.textPelajaran.text.toString()) {
            "Pelajaran 2" -> {
                return ytPlayer2()
            }
            "Pelajaran 3" -> {
                return ytPlayer3()
            }
            "Pelajaran 4" -> {
                return ytPlayer4()
            }
        }

    }

    private fun ytPlayer2(){
        val getId2 = this.arguments?.get("id2")
        val data2 = pelajaranHurufViewModel.hurufListFathah
        for(i in data2.indices) {
            var getDataId2 = data2[i].id
            if(getDataId2 == getId2){
                binding.textJudul.text = data2[i].pelajaran
                youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                    override fun onReady(player: YouTubePlayer) {
                        youTubePlayer = player
                        player.cueVideo(data2[i].idYoutube, 0f)
                    }

                    override fun onStateChange(
                        youTubePlayer: YouTubePlayer,
                        state: PlayerConstants.PlayerState
                    ) {
                        if (state == PlayerConstants.PlayerState.ENDED)
                            binding.btnPly.visibility= View.VISIBLE
                    }
                })
                binding.btnPly.setOnClickListener {
                    youTubePlayer?.play()
                    binding.btnPly.visibility = View.INVISIBLE
                }
                binding.detail.text = data2[i].detail
                Glide.with(this).load(data2[i].gambar).into(binding.gambarPelajaran)
            }
        }

    }
    private fun ytPlayer3(){
        val getId3 = this.arguments?.get("id3")
        val data3 = pelajaranHurufViewModel.hurufListKasrah
        for(i in data3.indices) {
            var getDataId3 = data3[i].id
            if(getDataId3 == getId3){
                binding.textJudul.text = data3[i].pelajaran
                youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                    override fun onReady(player: YouTubePlayer) {
                        youTubePlayer = player
                        player.cueVideo(data3[i].idYoutube, 0f)
                    }

                    override fun onStateChange(
                        youTubePlayer: YouTubePlayer,
                        state: PlayerConstants.PlayerState
                    ) {
                        if (state == PlayerConstants.PlayerState.ENDED)
                            binding.btnPly.visibility= View.VISIBLE
                    }
                })
                binding.btnPly.setOnClickListener {
                    youTubePlayer?.play()
                    binding.btnPly.visibility = View.INVISIBLE
                }
                binding.detail.text = data3[i].detail
                Glide.with(this).load(data3[i].gambar).into(binding.gambarPelajaran)
            }
        }

    }
    private fun ytPlayer4(){
        val getId4 = this.arguments?.get("id4")
        val data4 = pelajaranHurufViewModel.hurufListDhammah
        for(i in data4.indices) {
            var getDataId4 = data4[i].id
            if(getDataId4 == getId4){
                binding.textJudul.text = data4[i].pelajaran
                youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                    override fun onReady(player: YouTubePlayer) {
                        youTubePlayer = player
                        player.cueVideo(data4[i].idYoutube, 0f)
                    }

                    override fun onStateChange(
                        youTubePlayer: YouTubePlayer,
                        state: PlayerConstants.PlayerState
                    ) {
                        if (state == PlayerConstants.PlayerState.ENDED)
                            binding.btnPly.visibility= View.VISIBLE
                    }
                })
                binding.btnPly.setOnClickListener {
                    youTubePlayer?.play()
                    binding.btnPly.visibility = View.INVISIBLE
                }
                binding.detail.text = data4[i].detail
                Glide.with(this).load(data4[i].gambar).into(binding.gambarPelajaran)
            }
        }

    }


}