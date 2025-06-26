package com.test.qolami.view.account

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentProfileBinding
import com.test.qolami.viewnodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val userViewModel: UserViewModel by viewModels()  // Inisialisasi ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)

        // Mengambil userId menggunakan getInt, bukan getString
        val userId = sharedPreferences.getInt("userId", -1)  // (1) Mengambil userId dari SharedPreferences
        Log.d("ProfileFragment", "User ID retrieved: $userId")

        val currentName = sharedPreferences.getString("userName", "")

        binding.etNamalengkap.setText(currentName)

        // Tombol untuk kembali
        binding.icBack.setOnClickListener {
            findNavController().navigateUp()
        }

        // Tombol untuk mengubah field menjadi bisa diedit
        binding.buttonDaftar.setOnClickListener {
            binding.etNamalengkap.isEnabled = true
        }

        // Tombol untuk menyimpan nama yang diubah
        binding.buttonSimpan.setOnClickListener {
            val updatedName = binding.etNamalengkap.text.toString()

            if (updatedName.isNotBlank()) {
                if (userId != -1) {  // (2) Pastikan userId valid
                    // Memanggil ViewModel untuk update nama di server
                    userViewModel.updateUserName(userId, updatedName)
                } else {
                    // Jika userId tidak valid
                    Toast.makeText(requireContext(), "User ID tidak ditemukan", Toast.LENGTH_SHORT).show()
                }

                // Simpan nama yang diperbarui ke SharedPreferences
                sharedPreferences.edit().putString("userName", updatedName).apply()

                // Menonaktifkan EditText agar tidak bisa diedit setelah simpan
                binding.etNamalengkap.isEnabled = false

                // Debug untuk memastikan nama yang diubah sudah disimpan di SharedPreferences
                Log.d("ProfileFragment", "Updated Name: ${sharedPreferences.getString("userName", "")}")
            } else {
                Toast.makeText(requireContext(), "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }

        // Observe LiveData dari ViewModel untuk mendapatkan pesan sukses/gagal
        userViewModel.updateResponse.observe(viewLifecycleOwner, { message ->
            // Tampilkan pesan sukses atau gagal
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

            // Jika sukses, perbarui UI dengan nama baru
            if (message.contains("berhasil")) {
                binding.etNamalengkap.setText(binding.etNamalengkap.text.toString()) // Menampilkan nama yang baru
            }
        })
    }
}
