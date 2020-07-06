package com.sam.learnmvvm

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sam.learnmvvm.databinding.ItemRssBinding

class RssAdapter : RecyclerView.Adapter<RssAdapter.RssViewHolder> {


    private var rssDatas: MutableList<RssData>

    constructor(rssDatas: MutableList<RssData>) {
        this.rssDatas = rssDatas
    }

    override fun onCreateViewHolder(group: ViewGroup, type: Int): RssViewHolder {
        // Lay context tu group ve
        // Tat ca cac loai view deu co context
        // Vi co context moi hien thi duoc

        val binding: ItemRssBinding = ItemRssBinding.inflate(
            LayoutInflater.from(group.context),
            group,
            false
        )
        return RssViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return rssDatas.size
    }

    // Do du lieu len itemview(viewHolder)
    override fun onBindViewHolder(holder: RssViewHolder, position: Int) {
        // Do du lieu len xml
        holder.binding.itemData = rssDatas.get(position)
//        if (rssDatas.get(position).isClick) {
//            Log.d(position.toString(), position.toString())
//        } else {
//            holder.itemView.setBackgroundColor(Color.TRANSPARENT)
//        }
//
//        holder.itemView.setOnClickListener({
//            rssDatas.get(position).isClick = !rssDatas.get(position).isClick
//            // reload lai item view nay => Se tu dong goi onBindViewHolder voi vi tri la
//            // position
//            notifyItemChanged(position)
//        }
//        )
    }

    class RssViewHolder : RecyclerView.ViewHolder {
        val binding: ItemRssBinding

        constructor(binding: ItemRssBinding) : super(binding.root) {
            this.binding = binding
        }
    }

}