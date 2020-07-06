package com.sam.learnmvvm

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class Utils {
    //Cac phuong thuc, thuoc tinh static nen nam trong companion object
    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(iv: ImageView, link: String?) {
            if (link == null || link.equals("")) {
                Glide.with(iv)
                    .load(R.drawable.item_bg)
                    .into(iv)
            }else{
                Glide.with(iv)
                    .load(link)
                    .placeholder(R.drawable.item_bg)
                    .into(iv)
            }
        }
    }
}