package com.example.homework_10_profile

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_10_profile.databinding.UserOptionLayoutBinding

class OptionsAdapter: RecyclerView.Adapter<OptionsAdapter.OptionsViewHolder>() {
    private val diffCallback = object: DiffUtil.ItemCallback<Options>() {
        override fun areItemsTheSame(oldItem: Options, newItem: Options): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Options, newItem: Options): Boolean {
            return oldItem == newItem
        }
    }

    private val diffList = AsyncListDiffer(this, diffCallback)
    fun submitOptionData(value: List<Options>?) = diffList.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        return OptionsViewHolder(UserOptionLayoutBinding.inflate(inflate, parent, false))
    }

    override fun getItemCount(): Int {
        return diffList.currentList.size
    }

    override fun onBindViewHolder(holder: OptionsViewHolder, position: Int) {
        val modelView = diffList.currentList[position]
        holder.bind(modelView)
    }

    inner class OptionsViewHolder(private val binding: UserOptionLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(option: Options) {
            binding.apply {
                ivIcon.setImageResource(option.image)
                tvTitle.text = option.title
                if(option.language != null) {
                    tvLanguage.visibility = View.VISIBLE
                    tvLanguage.text = option.language
                }
                if(option.title == "Dark Mode") {
                    ivNextArrow.visibility = View.GONE
                    switchMaterial.visibility = View.VISIBLE
                }
                if(option.title == "Logout") {
                    ivNextArrow.visibility = View.GONE
                    tvTitle.setTextColor(Color.parseColor("#F10707"))
                }
            }
        }
    }
}