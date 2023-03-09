package com.example.android3lesson1dz.ui.adaptetr

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android3lesson1dz.data.model.GeneralModel
import com.example.android3lesson1dz.databinding.ItemMainBinding

class GeneralAdapter(
    val onItemClick : (generalModel: GeneralModel) -> Unit) :
    RecyclerView.Adapter<GeneralAdapter.GeneralViewHolder>() {

    private var list: List<GeneralModel> = ArrayList()

    fun setList(list: List<GeneralModel>){
        this.list = list
        notifyDataSetChanged()
    }

    inner class GeneralViewHolder(private val binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener{
                onItemClick(list[adapterPosition])
            }
        }

        fun onBind(generalModel: GeneralModel) {
            binding.tvName.text = generalModel.name
            Glide.with(binding.imgLogo.context).load(generalModel.img).into(binding.imgLogo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralViewHolder {
        return GeneralViewHolder(
            ItemMainBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GeneralViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}