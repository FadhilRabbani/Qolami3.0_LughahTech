package com.test.qolami.view.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentSendOtpBinding
import com.test.qolami.viewnodel.ResetPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSendOtp : Fragment() {

    private var _binding: FragmentSendOtpBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ResetPasswordViewModel by viewModels()
    private var sourceFragment: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sourceFragment = arguments?.getString("source_fragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSendOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FragmentSendOtp", "FragmentSendOtp berhasil dibuka")
        binding.imageBack.setOnClickListener {
            when (sourceFragment) {
                "login" -> findNavController().navigate(R.id.action_send_otp_to_login)
                "setting" -> findNavController().navigate(R.id.action_send_otp_to_akun)
                else -> findNavController().popBackStack()
            }
        }

        binding.buttonMasuk.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            if (email.isNotEmpty()) {
                viewModel.sendOtp(email)
            } else {
                Toast.makeText(requireContext(), "Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.message.observe(viewLifecycleOwner) { msg ->
            Log.d("OTP_DEBUG", "Message Received: '$msg'")
            Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()

            val normalized = msg?.replace(160.toChar(), ' ')?.trim()
            Log.d("OTP_DEBUG", "Normalized Message: '$normalized'")

            if (normalized?.contains("Kode OTP telah dikirim ke email.") == true) {
                val bundle = Bundle().apply {
                    putString("source_fragment", sourceFragment)
                }
                findNavController().navigate(R.id.action_send_otp_to_change_password, bundle)
            }
        }
        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Error: $it", Toast.LENGTH_LONG).show()
        }
        viewModel.isLoading.observe(viewLifecycleOwner) { loading ->
            if (loading) {
                binding.loadingContainer.visibility = View.VISIBLE
            } else {
                binding.loadingContainer.visibility = View.GONE
            }
            binding.buttonMasuk.isEnabled = !loading
            binding.etEmail.isEnabled = !loading
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
