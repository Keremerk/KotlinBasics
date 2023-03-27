package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

private lateinit var members:List<NeonAcademyMember>

class MainActivity : AppCompatActivity() {
    private var memberList = MemberList.memberList
    lateinit var team: Team
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun motivationLevel(motivation :Int) :String {
        return when {
            motivation == null -> "This member has no motivation level set"
            motivation > 5 -> "This member is highly motivated"

            else -> {
                "Motivation cannot be lower than 0"
            }
        }
    }


    fun returnMotivationLevel(member: NeonAcademyMember): Int{
        return member.motivationLevel ?: 0
    }

    fun checkMotivationLevel(member: NeonAcademyMember,targetLevel :Int): Boolean{
        return if(member.motivationLevel !=null){
            member.motivationLevel!! >= targetLevel
        }else{
            false
        }
    }
}