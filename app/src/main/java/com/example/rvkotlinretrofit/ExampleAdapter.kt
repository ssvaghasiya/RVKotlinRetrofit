package com.example.rvkotlinretrofit

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.example_item.view.*

class ExampleAdapter(private val dataList: List<Data>): RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        context = parent.context
        var itemview = LayoutInflater.from(parent.context).inflate(R.layout.example_item,parent,false)
        return ExampleViewHolder(itemview)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        var currentitem = dataList[position]

        holder.textView1.text = currentitem.email
        holder.textview2.text = currentitem.first_name
//        Glide.with(context).load(currentitem.avatar).into(holder.imageView)
        Picasso.get().load("${currentitem.avatar}").into(holder.imageView)
    }


    class ExampleViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){

        val imageView: ImageView = itemview.image_view
        val textView1: TextView = itemview.text_view_1
        val textview2: TextView = itemview.text_view_2
    }
}