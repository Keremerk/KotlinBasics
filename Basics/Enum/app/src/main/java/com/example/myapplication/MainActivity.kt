package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

private lateinit var members:List<NeonAcademyMember>

class MainActivity : AppCompatActivity() {
    private var memberList = MemberList.memberList
    lateinit var team :Team
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onlyAndroid(team :Team){
        val teamMembers = MemberList.memberList.filter { it.team == team }
        teamMembers.forEach { println(it.fullName) }
    }

    fun UIMemberNames(){
        var teamUI = mutableListOf<NeonAcademyMember>()
        teamUI = MemberList.memberList.filter { it.team == Team.UI_UX_DESIGN } as MutableList<NeonAcademyMember>
        teamUI.forEach {
            println(it.fullName)
        }
    }

    fun printTeam(team :Team): Double {
        var membersInTeam = memberList.filter { it.team == team }
        var totalAge =0
        membersInTeam.forEach {
            when(it.team){
                team -> totalAge += it.age
                else -> {
                    println("else ifadesi")
                }
            }
        }
        return totalAge.toDouble() /membersInTeam.size
        //Create a function that takes a team as an input and calculates the average age of the members in that team.
    }

    fun skilleddeveloper(team: Team,age :Int){
        MemberList.memberList.filter { it.team == team && it.age > age }
            .forEach {
                when(it.team.toString()){
                    "ANDROID_DEVELOPMENT" -> println("${it.fullName} is an experienced Android developer")
                    "IOS_DEVELOPMENT" -> println("${it.fullName} is an experienced İOS developer")
                    "UI_UX_DESIGN" -> println("${it.fullName} is a talented designer")
                    else -> {
                        println("else ifadesi")
                    }
                }
            }
    }

    fun step5(team: Team,age :Int){
        val members = memberList.filter { it.age > age && it.team == team }
        for (member in members) {
            println("Full name: ${member.fullName} ${member.age}")
        }
    //Create a function that takes an age as an input and prints out the full
    // names of all members that are older than that age
    // and belong to a specific team (Android Development Team for example)
    }

    fun changetitle(team: Team) :String{
        return  when (team.toString()) {
            "ANDROID_DEVELOPMENT" -> "Senior Android Developer"
            "UI_UX_DESIGN" -> "Lead Designer"
            else -> "Team member"
        }
    }

    fun AndroidAvarageAge(team :Team): Double {
        var membersInTeam = MemberList.memberList.filter { it.team == team }
        var totalAge =0
        membersInTeam.forEach {
            when(it.team){
                team -> totalAge += it.age
                else -> {
                    println("else ifadesi")
                }
            }
        }
        return totalAge.toDouble() /membersInTeam.size
    }

    fun specialMessages(team: Team){
        when(team){
            Team.ANDROID_DEVELOPMENT -> println("The Android Development Team is the backbone of our academy")
            Team.IOS_DEVELOPMENT -> println("The IOS Development Team is the backbone of our academy")
            Team.UI_UX_DESIGN -> println("The UI/UX Design Team is the face of our academy")
            else -> {
                println("team not found")
            }
        }
    }

    fun Step9(team :Team){
        val newList = arrayListOf<NeonAcademyMember>()
        memberList.forEach { memberList ->
            when(memberList.team){
                team -> newList.add(memberList)
                else -> {}
            }
        }
        newList.forEach { newList->
            println("${newList.fullName} : ${newList.contact.email} ${newList.contact.phoneNumber}")
        }
    //Create a function that takes a team as an input and returns
    // an array of the contact information of all members in that team.
    }


    fun Laststep(member :NeonAcademyMember,increaseBy :Int){
        when {
            member.team == Team.ANDROID_DEVELOPMENT && member.age > 23 -> println("${member.fullName} member is a seasoned Android developer")
            member.team == Team.UI_UX_DESIGN && member.age < 24 -> println("${member.fullName} member is a rising star in the design world")
            else -> println("${member.fullName} member is a valued member of our academy")
        }
        //Create a when statement that performs different actions based on the team of a member and their age.
        // For example, if a member is in the Android Development Team and is over 23 years old,
        // the function could print out "XXX member is a seasoned Android developer",
        // and if the member is in the UI/UX Design Team and is under 24,
        // the function could print out "XXX member is a rising star in the design world".
    }



}