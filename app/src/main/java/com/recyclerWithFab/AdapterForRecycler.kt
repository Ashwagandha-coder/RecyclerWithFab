package com.recyclerWithFab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recyclerWithFab.databinding.ItemRecyclerBinding

class AdapterForRecycler(private val list: List<RecyclerViewData>): RecyclerView.Adapter<AdapterForRecycler.ViewHolderForRecycler>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderForRecycler {

        val inflater = LayoutInflater.from(parent.context)

        return ViewHolderForRecycler(binding = ItemRecyclerBinding.inflate(inflater,parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolderForRecycler, position: Int) {

        val currentItem = list[position]

        holder.bind(currentItem)


    }

    override fun getItemCount(): Int {
        return list.size
    }



    inner class ViewHolderForRecycler(private val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {


        fun bind(item: RecyclerViewData) {

            binding.tvNumber.text = item.text1
            binding.tvNumbersInText.text = item.text2



        }


    }


}