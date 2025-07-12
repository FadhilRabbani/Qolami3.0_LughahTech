package com.test.qolami.view.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.test.qolami.R
import com.test.qolami.databinding.FragmentChangePasswordBinding
import com.test.qolami.viewnodel.ResetPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentChangePassword : Fragment() {

    private var _binding: FragmentChangePasswordBinding? = null
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
        _binding = FragmentChangePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageBack.setOnClickListener{
            findNavController().navigate(R.id.action_change_password_to_send_otp)
        }
        binding.buttonChangepassword.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val otp = binding.etOtp.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val repassword = binding.etRepassword.text.toString().trim()

            if (email.isEmpty() || otp.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
                Toast.makeText(requireContext(), "Semua field wajib diisi", Toast.LENGTH_SHORT).show()
            } else if (password != repassword) {
                Toast.makeText(requireContext(), "Password tidak cocok", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.resetPassword(email, otp, password, repassword)
                binding.loadingContainer.visibility = View.VISIBLE
            }
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.message.observe(viewLifecycleOwner) {
            binding.loadingContainer.visibility = View.GONE
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            if (it == "Password berhasil diubah.") {
                when (sourceFragment) {
                    "login" -> findNavController().navigate(R.id.action_change_password_to_login)
                    "setting" -> findNavController().navigate(R.id.action_change_password_to_akun)
                    else -> findNavController().popBackStack(R.id.homeFragment, false) // atau fallback
                }
            }
        }

        viewModel.error.observe(viewLifecycleOwner) {
            binding.loadingContainer.visibility = View.GONE
            Toast.makeText(requireContext(), "Error: $it", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
