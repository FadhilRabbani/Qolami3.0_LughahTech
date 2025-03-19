package com.test.qolami.view.latihan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.test.qolami.R


class DialogFragmentJawabanLatihanVideos : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_jawaban_latihan_videos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jawabanBenar = (requireParentFragment() as FragmentSoalLatihanVideos).checkSoal()
        if (jawabanBenar == false) {
            view.findViewById<ConstraintLayout>(R.id.cl_lyt).setBackgroundColor(resources.getColor(R.color.merah))
            view.findViewById<ImageView>(R.id.img_emot)
                .setImageResource(R.drawable.baseline_sentiment_very_dissatisfied_24)
            view.findViewById<TextView>(R.id.txt_detail).text = "Salah!"
            view.findViewById<Button>(R.id.button_lanjutkan_soal)
                .setTextColor(resources.getColor(R.color.merah))
        }
        view.findViewById<Button>(R.id.button_lanjutkan_soal).setOnClickListener {
            val lanjutkanSoal = (requireParentFragment() as FragmentSoalLatihanVideos).lanjutSoal()
            lanjutkanSoal
            dismiss()
        }
    }
}