package com.example.firestore.adapter

import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firestore.R
import com.example.firestore.ada.PostAdapter
import com.example.firestore.model.Comment


class CommentAdapter (private val commentList: ArrayList<Comment>) : RecyclerView.Adapter<PostAdapter.postHolder>()  {
    class commentHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.postHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.comment_view,parent,false)
        return PostAdapter.postHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.postHolder, position: Int) {

       holder.itemView.findViewById<TextView>(R.id.comment).text = commentList[position].comment
        holder.itemView.findViewById<TextView>(R.id.userEmail).text = commentList[position].commentEmail

    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}