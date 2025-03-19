package com.test.qolami.view.latihan

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.test.qolami.R
import com.test.qolami.databinding.FragmentSoalLatihanVideosBinding
import com.test.qolami.viewnodel.LatihanHurufViewModel
import dagger.hilt.android.AndroidEntryPoint


@Suppress("DEPRECATION")
@AndroidEntryPoint
class FragmentSoalLatihanVideos : Fragment() {
    private lateinit var binding: FragmentSoalLatihanVideosBinding
    private lateinit var latihanHurufViewModel: LatihanHurufViewModel
    private lateinit var sharedPreferences: SharedPreferences
    private var indexTerkini = 1
    private var indexYangDipilih = 0
    private var jumlahBenarVideos = 0
    private var jumlahSalahVideos = 0
    var subtitle = ""
    var title = ""
    private lateinit var youTubePlayerView: YouTubePlayerView
    private var youTubePlayer: YouTubePlayer? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSoalLatihanVideosBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backImg.setOnClickListener {
            findNavController().navigateUp()
        }
        sharedPreferences = requireContext().getSharedPreferences("judul", Context.MODE_PRIVATE)
        val judulLatihan = sharedPreferences.getString("latihanVideo", "")
        binding.textPelajaran.text = judulLatihan
        binding.backImg.setOnClickListener {
            findNavController().navigateUp()
        }
        youTubePlayerView = binding.ytPlayer
        latihanHurufViewModel = ViewModelProvider(this).get(LatihanHurufViewModel::class.java)
        binding.option1.setOnClickListener {
            selectedOption(0, binding.txtJawaban1, binding.option1)
        }
        binding.option2.setOnClickListener {
            selectedOption(1, binding.txtJawaban2, binding.option2)
        }
        binding.option3.setOnClickListener {
            selectedOption(2, binding.txtJawaban3, binding.option3)
        }
        binding.option4.setOnClickListener {
            selectedOption(3, binding.txtJawaban4, binding.option4)
        }
        when(binding.textPelajaran.text){
            "Latihan 1" ->
                setSoal1()
            "Latihan 2" ->
                setSoal2()
            "Latihan 3" ->
                setSoal3()
            "Latihan 4" ->
                setSoal4()
        }
        binding.buttonCheckSoal.setOnClickListener {
            if(checkSoal() == true){
                jumlahBenarVideos++
                Log.i("asas", "$jumlahBenarVideos")
            }else {
                jumlahSalahVideos++
                Log.i("asas", "$jumlahSalahVideos")
            }
            showBottomSheetDialog()
        }
    }
    private fun setSoal1(){
        latihanHurufViewModel.getSoalVideoHijaiyah()
        latihanHurufViewModel.dataSoalVideosHijaiyah.observe(viewLifecycleOwner){
            title = it.latihanHijaiyahVideo[indexTerkini - 1].title
            subtitle = it.latihanHijaiyahVideo[indexTerkini - 1].subtitle
            binding.textJudul.text = it.latihanHijaiyahVideo[indexTerkini - 1].subtitle
            youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    this@FragmentSoalLatihanVideos.youTubePlayer = youTubePlayer
                    this@FragmentSoalLatihanVideos.youTubePlayer?.cueVideo(it.latihanHijaiyahVideo[indexTerkini-1].videoId, 0f)
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
            binding.txtJawaban1.text = it.latihanHijaiyahVideo[indexTerkini - 1].options[0]
            binding.txtJawaban2.text = it.latihanHijaiyahVideo[indexTerkini - 1].options[1]
            binding.txtJawaban3.text = it.latihanHijaiyahVideo[indexTerkini - 1].options[2]
            binding.txtJawaban4.text = it.latihanHijaiyahVideo[indexTerkini - 1].options[3]
        }
        defaultStyle()
    }
    private fun setSoal2(){
        latihanHurufViewModel.getSoalVideoFathah()
        latihanHurufViewModel.dataSoalVideosFathah.observe(viewLifecycleOwner){
            title = it.latihanFathahVideo[indexTerkini - 1].title
            subtitle = it.latihanFathahVideo[indexTerkini - 1].subtitle
            binding.textJudul.text = it.latihanFathahVideo[indexTerkini - 1].subtitle
            youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    this@FragmentSoalLatihanVideos.youTubePlayer = youTubePlayer
                    this@FragmentSoalLatihanVideos.youTubePlayer?.cueVideo(it.latihanFathahVideo[indexTerkini-1].videoId, 0f)
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
            binding.txtJawaban1.text = it.latihanFathahVideo[indexTerkini - 1].options[0]
            binding.txtJawaban2.text = it.latihanFathahVideo[indexTerkini - 1].options[1]
            binding.txtJawaban3.text = it.latihanFathahVideo[indexTerkini - 1].options[2]
            binding.txtJawaban4.text = it.latihanFathahVideo[indexTerkini - 1].options[3]
        }
        defaultStyle()
    }
    private fun setSoal3(){
        latihanHurufViewModel.getSoalVideoKasrah()
        latihanHurufViewModel.dataSoalVideosKasrah.observe(viewLifecycleOwner){
            title = it.latihanKasrahVideo[indexTerkini - 1].title
            subtitle = it.latihanKasrahVideo[indexTerkini - 1].subtitle
            binding.textJudul.text = it.latihanKasrahVideo[indexTerkini - 1].subtitle
            youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    this@FragmentSoalLatihanVideos.youTubePlayer = youTubePlayer
                    this@FragmentSoalLatihanVideos.youTubePlayer?.cueVideo(it.latihanKasrahVideo[indexTerkini-1].videoId, 0f)
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
            binding.txtJawaban1.text = it.latihanKasrahVideo[indexTerkini - 1].options[0]
            binding.txtJawaban2.text = it.latihanKasrahVideo[indexTerkini - 1].options[1]
            binding.txtJawaban3.text = it.latihanKasrahVideo[indexTerkini - 1].options[2]
            binding.txtJawaban4.text = it.latihanKasrahVideo[indexTerkini - 1].options[3]
        }
        defaultStyle()
    }
    private fun setSoal4(){
        latihanHurufViewModel.getSoalVideoDhammah()
        latihanHurufViewModel.dataSoalVideosDhammah.observe(viewLifecycleOwner){
            title = it.latihanDhammahVideo[indexTerkini - 1].title
            subtitle = it.latihanDhammahVideo[indexTerkini - 1].subtitle
            binding.textJudul.text = it.latihanDhammahVideo[indexTerkini - 1].subtitle
            youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    this@FragmentSoalLatihanVideos.youTubePlayer = youTubePlayer
                    this@FragmentSoalLatihanVideos.youTubePlayer?.cueVideo(it.latihanDhammahVideo[indexTerkini-1].videoId, 0f)
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
            binding.txtJawaban1.text = it.latihanDhammahVideo[indexTerkini - 1].options[0]
            binding.txtJawaban2.text = it.latihanDhammahVideo[indexTerkini - 1].options[1]
            binding.txtJawaban3.text = it.latihanDhammahVideo[indexTerkini - 1].options[2]
            binding.txtJawaban4.text = it.latihanDhammahVideo[indexTerkini - 1].options[3]
        }
        defaultStyle()
    }
    private fun defaultStyle(){
        val options = ArrayList<CardView>()
        options.add(binding.option1)
        options.add(binding.option2)
        options.add(binding.option3)
        options.add(binding.option4)
        for(option in options){
            option.setCardBackgroundColor(resources.getColor(R.color.white))
        }
        val optionsText = ArrayList<TextView>()
        optionsText.add(binding.txtJawaban1)
        optionsText.add(binding.txtJawaban2)
        optionsText.add(binding.txtJawaban3)
        optionsText.add(binding.txtJawaban4)
        for (optionText in optionsText){
            optionText.setTextColor(resources.getColor(R.color.black))
        }
    }
    private fun selectedOption(indexDipilih: Int, tv: TextView, cv: CardView){
        defaultStyle()
        indexYangDipilih = indexDipilih
        tv.setTextColor(resources.getColor(R.color.white))
        cv.setCardBackgroundColor(resources.getColor(R.color.warna_hijau_muda))
    }
    fun checkSoal():Boolean{
        var indikator = false
        if (binding.textPelajaran.text == "Latihan 2") {
            latihanHurufViewModel.dataSoalVideosFathah.observe(viewLifecycleOwner) {
                if (indexYangDipilih == it.latihanFathahVideo[indexTerkini - 1].correctIndex) {
                    indikator = true
                } else {
                    indikator = false
                }
            }
        }else if (binding.textPelajaran.text == "Latihan 3"){
            latihanHurufViewModel.dataSoalVideosKasrah.observe(viewLifecycleOwner){
                if (indexYangDipilih == it.latihanKasrahVideo[indexTerkini - 1].correctIndex) {
                    indikator = true
                } else {
                    indikator = false
                }
            }
        }else if (binding.textPelajaran.text == "Latihan 4"){
            latihanHurufViewModel.dataSoalVideosDhammah.observe(viewLifecycleOwner){
                if (indexYangDipilih == it.latihanDhammahVideo[indexTerkini - 1].correctIndex) {
                    indikator = true
                } else {
                    indikator = false
                }
            }
        }else if (binding.textPelajaran.text == "Latihan 1"){
            latihanHurufViewModel.dataSoalVideosHijaiyah.observe(viewLifecycleOwner){
                if (indexYangDipilih == it.latihanHijaiyahVideo[indexTerkini - 1].correctIndex) {
                    indikator = true
                } else {
                    indikator = false
                }
            }
        }
        return  indikator
    }

    fun lanjutSoal(){
        indexTerkini ++
        indexYangDipilih = 0
        if (binding.textPelajaran.text == "Latihan 2") {
            if (checkJumlahSoal() == true) {
                latihanHurufViewModel.dataSoalVideosFathah.observe(viewLifecycleOwner) {
                    binding.textJudul.text = it.latihanFathahVideo[indexTerkini - 1].subtitle
                    youTubePlayer?.cueVideo(it.latihanFathahVideo[indexTerkini - 1].videoId, 0f)
                    Log.i("yt", it.latihanFathahVideo[indexTerkini - 1].videoId)
                    binding.txtJawaban1.text = it.latihanFathahVideo[indexTerkini - 1].options[0]
                    binding.txtJawaban2.text = it.latihanFathahVideo[indexTerkini - 1].options[1]
                    binding.txtJawaban3.text = it.latihanFathahVideo[indexTerkini - 1].options[2]
                    binding.txtJawaban4.text = it.latihanFathahVideo[indexTerkini - 1].options[3]
                }
            }
        }else if(binding.textPelajaran.text == "Latihan 3"){
            if (checkJumlahSoal() == true) {
                latihanHurufViewModel.dataSoalVideosKasrah.observe(viewLifecycleOwner) {
                    binding.textJudul.text = it.latihanKasrahVideo[indexTerkini - 1].subtitle
                    youTubePlayer?.cueVideo(it.latihanKasrahVideo[indexTerkini - 1].videoId, 0f)
                    Log.i("yt", it.latihanKasrahVideo[indexTerkini - 1].videoId)
                    binding.txtJawaban1.text = it.latihanKasrahVideo[indexTerkini - 1].options[0]
                    binding.txtJawaban2.text = it.latihanKasrahVideo[indexTerkini - 1].options[1]
                    binding.txtJawaban3.text = it.latihanKasrahVideo[indexTerkini - 1].options[2]
                    binding.txtJawaban4.text = it.latihanKasrahVideo[indexTerkini - 1].options[3]
                }
            }
        }else if(binding.textPelajaran.text == "Latihan 4"){
            if (checkJumlahSoal() == true) {
                latihanHurufViewModel.dataSoalVideosDhammah.observe(viewLifecycleOwner) {
                    binding.textJudul.text = it.latihanDhammahVideo[indexTerkini - 1].subtitle
                    youTubePlayer?.cueVideo(it.latihanDhammahVideo[indexTerkini - 1].videoId, 0f)
                    Log.i("yt", it.latihanDhammahVideo[indexTerkini - 1].videoId)
                    binding.txtJawaban1.text = it.latihanDhammahVideo[indexTerkini - 1].options[0]
                    binding.txtJawaban2.text = it.latihanDhammahVideo[indexTerkini - 1].options[1]
                    binding.txtJawaban3.text = it.latihanDhammahVideo[indexTerkini - 1].options[2]
                    binding.txtJawaban4.text = it.latihanDhammahVideo[indexTerkini - 1].options[3]
                }
            }
        }else if(binding.textPelajaran.text == "Latihan 1") {
            if (checkJumlahSoal() == true) {
                latihanHurufViewModel.dataSoalVideosHijaiyah.observe(viewLifecycleOwner) {
                    binding.textJudul.text = it.latihanHijaiyahVideo[indexTerkini - 1].subtitle
                    youTubePlayer?.cueVideo(it.latihanHijaiyahVideo[indexTerkini - 1].videoId, 0f)
                    Log.i("yt", it.latihanHijaiyahVideo[indexTerkini - 1].videoId)
                    binding.txtJawaban1.text = it.latihanHijaiyahVideo[indexTerkini - 1].options[0]
                    binding.txtJawaban2.text = it.latihanHijaiyahVideo[indexTerkini - 1].options[1]
                    binding.txtJawaban3.text = it.latihanHijaiyahVideo[indexTerkini - 1].options[2]
                    binding.txtJawaban4.text = it.latihanHijaiyahVideo[indexTerkini - 1].options[3]
                }
            }
        }
        defaultStyle()
    }

    private fun checkJumlahSoal():Boolean{
        var indikatorCheck = false
        val bundle = Bundle()
        bundle.putInt("JumlahBenarVideos", jumlahBenarVideos)
        bundle.putInt("JumlahSalahVideos", jumlahSalahVideos)
        bundle.putString("titleVideos", title)
        bundle.putString("subtitleVideos", subtitle)
        if(binding.textPelajaran.text == "Latihan 2") {
            latihanHurufViewModel.dataSoalVideosFathah.observe(viewLifecycleOwner) {
                if (indexTerkini > it.latihanFathahVideo.size) {
                    indikatorCheck = false
                    findNavController().navigate(
                        R.id.action_fragmentSoalLatihanVideos_to_fragmentHasilLatihanVideos,
                        bundle
                    )
                } else {
                    indikatorCheck = true
                }
            }
        }else if (binding.textPelajaran.text == "Latihan 3"){
            latihanHurufViewModel.dataSoalVideosKasrah.observe(viewLifecycleOwner) {
                if (indexTerkini > it.latihanKasrahVideo.size) {
                    indikatorCheck = false
                    findNavController().navigate(
                        R.id.action_fragmentSoalLatihanVideos_to_fragmentHasilLatihanVideos,
                        bundle
                    )
                } else {
                    indikatorCheck = true
                }
            }
        }else if (binding.textPelajaran.text == "Latihan 4"){
            latihanHurufViewModel.dataSoalVideosDhammah.observe(viewLifecycleOwner) {
                if (indexTerkini > it.latihanDhammahVideo.size) {
                    indikatorCheck = false
                    findNavController().navigate(
                        R.id.action_fragmentSoalLatihanVideos_to_fragmentHasilLatihanVideos, bundle
                    )
                } else {
                    indikatorCheck = true
                }
            }
        }else if (binding.textPelajaran.text == "Latihan 1"){
            latihanHurufViewModel.dataSoalVideosHijaiyah.observe(viewLifecycleOwner) {
                if (indexTerkini > it.latihanHijaiyahVideo.size) {
                    indikatorCheck = false
                    findNavController().navigate(
                        R.id.action_fragmentSoalLatihanVideos_to_fragmentHasilLatihanVideos, bundle
                    )
                } else {
                    indikatorCheck = true
                }
            }
        }
        return indikatorCheck
    }
    private fun showBottomSheetDialog() {
        val bottomSheetDialogFragment = DialogFragmentJawabanLatihanVideos()
        bottomSheetDialogFragment.isCancelable = false
        bottomSheetDialogFragment.show(childFragmentManager, bottomSheetDialogFragment.tag)
    }

}