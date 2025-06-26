package com.test.qolami.view.kuis

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentHasilKuisBinding // ✅ Ganti ke binding layout yang sesuai
import com.test.qolami.model.network.RestfulApi
import com.test.qolami.model.network.RetrofitClient
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import android.view.animation.Animation
import android.view.animation.ScaleAnimation

@AndroidEntryPoint
class FragmentHasilKuis : Fragment() {
    @Inject
    lateinit var retrofitClient: RetrofitClient
    private lateinit var binding: FragmentHasilKuisBinding // ✅ Ganti nama binding
    private var userId: Int = 0
    private var kuisId: Int = 0
    private var jawabanUser: List<JawabanRequest.JawabanItem> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHasilKuisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ✅ Ambil argumen dari Bundle
        arguments?.let {
            userId = it.getInt("user_id")
            kuisId = it.getInt("kuis_id")
            jawabanUser = it.getParcelableArrayList<Parcelable>("jawaban")
                ?.filterIsInstance<JawabanRequest.JawabanItem>()
                ?: emptyList()


        }
        binding.bintang1.visibility = View.INVISIBLE
        binding.bintang2.visibility = View.INVISIBLE
        binding.bintang3.visibility = View.INVISIBLE

        submitJawaban()

        // ✅ Tombol kembali ke beranda
        binding.btnLanjutkan.setOnClickListener {
            findNavController().navigate(R.id.action_hasil_kuis_to_listKuis)
        }
    }

    private fun submitJawaban() {
        lifecycleScope.launch {
            try {
                val response = retrofitClient.apiService.submitJawabanKuis(
                    JawabanRequest(
                        user_id = userId,
                        kuis_id = kuisId,
                        jawaban = jawabanUser
                    )
                )

                if (response.isSuccessful) {
                    val hasil = response.body()?.data
                    hasil?.let {
                        val benar = it.jumlah_benar
                        val salah = jawabanUser.size - benar
                        android.util.Log.d("HASIL_KUIS", "Benar: $benar, Salah: $salah, Bintang: ${it.bintang}")
                        binding.nilaiBenar.text = benar.toString()
                        binding.nilaiSalah.text = salah.toString()
                        tampilkanBintang(it.bintang)
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    // ✅ Log dan tampilkan isi error response
                    android.util.Log.e("SUBMIT_ERROR", "Code: ${response.code()}, Error: $errorBody")
                    Toast.makeText(requireContext(), "Gagal submit\n$errorBody", Toast.LENGTH_LONG).show()
                }

            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Terjadi kesalahan: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun animasiPop(view: View) {
        val scale = ScaleAnimation(
            0f, 1f, // fromX, toX
            0f, 1f, // fromY, toY
            Animation.RELATIVE_TO_SELF, 0.5f, // pivotX
            Animation.RELATIVE_TO_SELF, 0.5f  // pivotY
        ).apply {
            duration = 400
            fillAfter = true
        }
        view.startAnimation(scale)
    }
    private fun tampilkanBintang(jumlah: Int) {
        val bintangViews = listOf(binding.bintang1, binding.bintang2, binding.bintang3)

        // Awalnya semua bintang invisible
        bintangViews.forEach { it.visibility = View.INVISIBLE }

        bintangViews.forEachIndexed { index, imageView ->
            // Set drawable dulu (emas atau abu-abu)
            val isBintangAktif = index < jumlah
            imageView.setImageResource(
                if (isBintangAktif) R.drawable.bintang_skor
                else R.drawable.bintang_skor_abu
            )

            // Delay + animasi pop
            imageView.postDelayed({
                imageView.visibility = View.VISIBLE
                animasiPop(imageView)
            }, (index * 300).toLong()) // Delay bertahap
        }
    }




}
