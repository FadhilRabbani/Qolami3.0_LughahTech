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
import com.test.qolami.databinding.FragmentPelajaranKataDhammahBinding
import com.test.qolami.databinding.FragmentPelajaranKataKasrahBinding

class PelajaranKataDhammah : Fragment() {
    private lateinit var binding: FragmentPelajaranKataDhammahBinding
    private var youTubePlayer: YouTubePlayer? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPelajaranKataDhammahBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gambarPelajaran.setImageResource(R.drawable.kamula)

        val youtubeId = "DazWszf03DE"
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
        binding.prevBtnKata.setOnClickListener {
            findNavController().navigate(R.id.action_dhammah_to_kasrah)
        }
        binding.nextBtnKata.setOnClickListener {
            findNavController().navigate(R.id.action_dhammah_to_fathah)
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