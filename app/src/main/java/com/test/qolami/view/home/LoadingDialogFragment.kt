package com.test.qolami.view.common

import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.test.qolami.R

class LoadingDialogFragment(private val message: String = "Harap tunggu...") : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        val view = layoutInflater.inflate(R.layout.dialog_loading, null)
        view.findViewById<TextView>(R.id.tv_loading_message).text = message

        dialog.apply {
            setContentView(view)
            setCancelable(false)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
        }

        return dialog
    }

    companion object {
        fun newInstance(message: String = "Harap tunggu..."): LoadingDialogFragment {
            return LoadingDialogFragment(message)
        }
    }
}
