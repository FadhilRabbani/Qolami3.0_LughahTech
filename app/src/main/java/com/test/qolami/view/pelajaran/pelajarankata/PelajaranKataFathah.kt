package com.test.qolami.view.pelajaran.pelajarankata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.test.qolami.R
import com.test.qolami.databinding.FragmentPelajaranKataBinding
import com.test.qolami.databinding.FragmentPelajaranKataFathahBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import androidx.navigation.fragment.findNavController

class PelajaranKataFathah : Fragment() {
    private lateinit var binding: FragmentPelajaranKataFathahBinding
    private var youTubePlayer: YouTubePlayer? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPelajaranKataFathahBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gambarPelajaran.setImageResource(R.drawable.malaka)

        val youtubeId = "QEH0V_LZOnY"
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
        binding.nextBtnKata.setOnClickListener {
            findNavController().navigate(R.id.action_fathah_to_kasrah)
        }
        binding.prevBtnKata.setOnClickListener{
            findNavController().navigate(R.id.action_fathah_to_dhammah)
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