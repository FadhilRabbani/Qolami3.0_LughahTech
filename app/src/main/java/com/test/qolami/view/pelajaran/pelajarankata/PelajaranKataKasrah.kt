package com.test.qolami.view.pelajaran.pelajarankata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.test.qolami.R
import com.test.qolami.databinding.FragmentPelajaranKataBinding
import com.test.qolami.databinding.FragmentPelajaranKataFathahBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.test.qolami.databinding.FragmentPelajaranKataKasrahBinding

class PelajaranKataKasrah : Fragment() {
    private lateinit var binding: FragmentPelajaranKataKasrahBinding
    private var youTubePlayer: YouTubePlayer? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPelajaranKataKasrahBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gambarPelajaran.setImageResource(R.drawable.hasiba)

        val youtubeId = "Fq4T2v8B2bk"
        lifecycle.addObserver(binding.ytPlayer)
        binding.ytPlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(player: YouTubePlayer) {
                youTubePlayer = player
                player.cueVideo(youtubeId, 0f)
            }

            override fun onStateChange(
                youTubePlayer: YouTubePlayer,
                state: PlayerConstants.PlayerState
            ) {
                if (state == PlayerConstants.PlayerState.ENDED) {
                    youTubePlayer.seekTo(0f)
                    youTubePlayer.play()
                }
            }
        })
        binding.backImg.setOnClickListener{
            findNavController().navigate(R.id.action_kasrah_to_pelajara_kata)
        }
        binding.prevBtnKata.setOnClickListener {
            findNavController().navigate(R.id.action_kasrah_to_fathah)
        }
        binding.nextBtnKata.setOnClickListener{
            findNavController().navigate(R.id.action_kasrah_to_dhammah)
        }
    }
    override fun onPause() {
        super.onPause()
        youTubePlayer?.pause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.ytPlayer.release()
        youTubePlayer = null
    }
}