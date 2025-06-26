package com.test.qolami.view.adapter.kuis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.qolami.R
import com.test.qolami.databinding.DataKuisItemBinding
import com.test.qolami.view.kuis.KuisItem

class KuisAdapter(private var kuisList: List<KuisItem>) :
    RecyclerView.Adapter<KuisAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: DataKuisItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataKuisItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = kuisList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = kuisList[position]
        with(holder.binding) {
            // Set nama kuis
            txtnamakuis.text = item.nama

            // Load logo kuis
            Glide.with(holder.itemView)
                .load(item.logo_kuis)
                .placeholder(R.drawable.ic_pelajaran_kata1)
                .into(imgLogo)

            // Tampilkan bintang
            bintang1.setImageResource(if (item.bintang >= 1) R.drawable.bintang_skor else R.drawable.bintang_skor_abu)
            bintang2.setImageResource(if (item.bintang >= 2) R.drawable.bintang_skor else R.drawable.bintang_skor_abu)
            bintang3.setImageResource(if (item.bintang == 3) R.drawable.bintang_skor else R.drawable.bintang_skor_abu)

            // Navigasi ke detail kuis universal
            btnDetil.setOnClickListener {
                val bundle = Bundle().apply {
                    putInt("kuisId", item.id)
                    putString("kuisNama", item.nama)
                }
                it.findNavController().navigate(R.id.action_list_kuis_to_kuis, bundle)
            }
        }
    }

    fun setData(newData: List<KuisItem>) {
        kuisList = newData
        notifyDataSetChanged()
    }
}
