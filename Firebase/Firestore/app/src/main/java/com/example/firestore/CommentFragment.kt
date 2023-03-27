package com.example.firestore

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firestore.adapter.CommentAdapter
import com.example.firestore.databinding.FragmentCommentBinding
import com.example.firestore.model.Comment
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class CommentFragment : Fragment() {
    private lateinit var binding: FragmentCommentBinding
    private val db = Firebase.firestore
    private lateinit var auth: FirebaseAuth
    private var  commentList = ArrayList<Comment>()
    private lateinit var commentAdapterRecycler : CommentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentCommentBinding.inflate(inflater,container,false)


        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewComment.layoutManager = layoutManager
        commentAdapterRecycler = CommentAdapter(commentList)
        binding.recyclerViewComment.adapter= commentAdapterRecycler

        getComment()

        binding.sendCommentIcon.setOnClickListener {
            comment()
        }


    }
    private fun comment()
    {

        val userComment = binding.commentEdtText.text.toString()
        val userEmail  = auth.currentUser?.email.toString()
        val dateNow = Timestamp.now()
        val commentMap = hashMapOf<String,Any>()
        val url = arguments?.getString("url")
        if (url != null) {
            commentMap["imageUrl"] = url.toString()
        }
        commentMap["CommentDate"] = dateNow
        commentMap["userEmail"] = userEmail
        commentMap["comment"] = userComment


        if (url != null) {
            db.collection("Comment").add(commentMap).addOnCompleteListener {  task ->

                    if (task.isSuccessful) {
                        Toast.makeText(requireContext(),"comment successful", Toast.LENGTH_LONG).show()
                    } else{
                        Toast.makeText(requireContext(),"comment error", Toast.LENGTH_LONG).show()
                    }

                }
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun getComment() {
        val url = arguments?.getString("url")
        db.collection("Comment").
        whereEqualTo("imageUrl", url).orderBy("CommentDate",
            Query.Direction.DESCENDING)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Toast.makeText(requireContext(), error.localizedMessage, Toast.LENGTH_LONG)
                        .show()
                } else {
                    if (snapshot != null) {
                        if (!snapshot.isEmpty) {

                            val documents = snapshot.documents
                            commentList.clear()
                            for (document in documents) {
                                val comment = document.get("comment").toString()
                                val userEmail = document.get("userEmail").toString()
                                val date = document.get("CommentDate").toString()

                                val commentInfo = Comment(userEmail, comment,date)
                                commentList.add(commentInfo)
                            }
                            commentAdapterRecycler.notifyDataSetChanged()
                        }
                    }
                }
            }
    }
}