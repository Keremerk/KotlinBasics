package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemSlideBinding


class ViewPagerAdapter(
    private val images: List<Int>,
    private val subtitles: List<String>,
    private val titles: List<String>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(val binding: ItemSlideBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = ItemSlideBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentImage = images[position]
        val currentSubtitle = subtitles[position]
        val currentTitle = titles[position]
        holder.binding.imageView.setImageResource(currentImage)
        holder.binding.subTitleTV.text = currentSubtitle
        holder.binding.titleTV.text = currentTitle
    }

    override fun getItemCount(): Int {
        return images.size
    }
}