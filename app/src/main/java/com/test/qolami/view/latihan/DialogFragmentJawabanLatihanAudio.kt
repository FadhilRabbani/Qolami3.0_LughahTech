package com.test.qolami.view.latihan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.test.qolami.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DialogFragmentJawabanLatihanAudio : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_jawaban_latihan_audio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jawabanBenar = (requireParentFragment() as FragmentSoalLatihanAudio).checkJawaban()
        if (jawabanBenar == false) {
            view.findViewById<ConstraintLayout>(R.id.cr_ly_audio).setBackgroundColor(resources.getColor(R.color.merah))
            view.findViewById<ImageView>(R.id.img_emot_audio)
                .setImageResource(R.drawable.baseline_sentiment_very_dissatisfied_24)
            view.findViewById<TextView>(R.id.txt_detail_audio).text = "Salah!"
            view.findViewById<Button>(R.id.button_lanjutkan_soal_audio)
                .setTextColor(resources.getColor(R.color.merah))
        }
        view.findViewById<Button>(R.id.button_lanjutkan_soal_audio).setOnClickListener {
            val lanjutkanSoal = (requireParentFragment() as FragmentSoalLatihanAudio).lanjutkanSoal()
            lanjutkanSoal
            dismiss()
        }
    }


}