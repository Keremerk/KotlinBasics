package com.example.firestore

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firestore.ada.PostAdapter
import com.example.firestore.databinding.FragmentHomepageBinding
import com.example.firestore.model.Post

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var auth: FirebaseAuth
    val db = Firebase.firestore
    var paylasimListesi = ArrayList<Post>()
    private lateinit var postAdapterRecycler : PostAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        binding.buttonLogout.setOnClickListener {
            auth.signOut()
            Toast.makeText(requireContext(), "Logout Successful !", Toast.LENGTH_SHORT).show()
            findNavController().navigate(
                HomepageFragmentDirections.actionHomepageFragmentToRegisterFragment()
            )
        }
        binding.buttonAdd.setOnClickListener {
            findNavController().navigate(HomepageFragmentDirections.actionHomepageFragmentToUploadFragment())
        }


        firebaseVerileriAl()

        var layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView1.layoutManager = layoutManager
        postAdapterRecycler = PostAdapter(paylasimListesi)
        binding.recyclerView1.adapter= postAdapterRecycler


    }





    @SuppressLint("NotifyDataSetChanged")
    fun firebaseVerileriAl(){

        //whereEqulTo() // ASCENDİNG ,DESCENDİNG(en yeni olan en üstte çıkar) limit ile sınırlandırabilir.
        db.collection("Post").orderBy("date",
            Query.Direction.DESCENDING).addSnapshotListener { snapshot, error ->
            if(error != null){
                Toast.makeText(requireContext(), "There was en error getting data", Toast.LENGTH_SHORT).show()
            }
            else{
                if (snapshot != null){
                    if(!snapshot.isEmpty){
                        val documents = snapshot.documents
                        paylasimListesi.clear()
                        for (document in documents){

                            val userEmail = document.get("userEmail").toString()
                            val imageUrl = document.get("imageUrl").toString()
                            val date = document.get("date").toString()
                            var downloadedPost =Post(userEmail,imageUrl,date)
                            paylasimListesi.add(downloadedPost)
                        }
                        postAdapterRecycler.notifyDataSetChanged()
                    }
                }
           }
        }
    }
}

