package com.example.firestore.ada

import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

import com.example.firestore.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.firestore.HomepageFragmentDirections
import com.example.firestore.model.Post
import com.squareup.picasso.Picasso


class PostAdapter (val postList: ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.postHolder>() {
    class postHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.post_view,parent,false)
        return postHolder(view)
    }

    override fun onBindViewHolder(holder: postHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.UserIDTV).text = postList[position].userEmail
        holder.itemView.findViewById<TextView>(R.id.post_date).text = postList[position].date
        holder.itemView.findViewById<ImageButton>(R.id.commentButton).setOnClickListener {
            //resim url alıcak
            val action = HomepageFragmentDirections.actionHomepageFragmentToCommentFragment(url = postList[position].imageURL!!)
            holder.itemView.findNavController().navigate(action)

        }
        holder.itemView.findViewById<ImageView>(R.id.imageView2).visibility = View.VISIBLE
        Picasso.get().load(postList[position].imageURL).into(holder.itemView.findViewById<ImageView>(R.id.imageView2))


    }

    override fun getItemCount(): Int {
        return postList.size
    }


}