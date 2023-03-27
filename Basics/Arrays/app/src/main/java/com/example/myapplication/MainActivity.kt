package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MemberList.memberList

private lateinit var members:List<NeonAcademyMember>

class MainActivity : AppCompatActivity() {
    private var memberList = MemberList.memberList
    lateinit var team :Team
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun deletethird(){
        memberList.removeAt(2)
    }

    fun sortbyage(){
        var sortedMemberAge= memberList.sortedByDescending {it.age}
        println(sortedMemberAge)

    }

    fun sortbyname(){
        var sortedMemberZA = memberList.sortedByDescending { it.fullName }
        println(sortedMemberZA)
    }

    fun olderthan24(){
        val filteredMembers = memberList.filter { it.age > 24 }
        filteredMembers.forEach {
            println(it.fullName)
        }
    }

    fun numberofAndroidDevelopers(){
        var androidDevCount = 0
        for(i in 0 until memberList.size)
        {
            if(memberList[i].title == "Android Developer"){
                androidDevCount++
            }
        }
        println("Toplam Android Developer sayısı: $androidDevCount")
    }

    fun arrayStep6(){
        var index =0
        for( i in 0 until memberList.size){
            if(memberList[i].fullName == "Kerem Erkubilay")
            {
                index = i
            }
        }
        println("KeremIndex: $index")
    }

    fun addamentor(){
        memberList.forEach{
            println(it.fullName)
            println(it.mentorLevel)
        }
    }

    fun everyonebutA1(){
        var membernotA1 = mutableListOf<NeonAcademyMember>()
        for (member in memberList){
            membernotA1  = memberList.filter { it.memberLevel != "A1" } as MutableList<NeonAcademyMember>
        }
        for (member in membernotA1){
            println(member.fullName)
        }
    }

    fun longestname(){
        var longestName = ""
        var longestNameLength = 0
        for (member in memberList) {
            val nameLength = member.fullName.length
            if (nameLength > longestNameLength) {
                longestName = member.fullName
                longestNameLength = nameLength
            }
        }
        println("longestName: $longestName")
        println("longestNameLength: $longestNameLength")
    }

}
fun samehoroscope(){
    val membersHoroscope= mutableListOf<NeonAcademyMember>()
    for (member in memberList){
        for(comparedMember in memberList){
            if (member.horoscope == comparedMember.horoscope && member != comparedMember) {
                membersHoroscope.add(member)
                break
            }
        }
    }
    println("horoscope")
    for (member in membersHoroscope) {
        println(member.fullName)
        println(member.horoscope)
    }
}

fun arrayStep11(){
    val newList = arrayListOf<String>()
    memberList.forEach{
        newList.add(it.homeTown)
    }
    val homeTownCount = newList.groupingBy { it }.eachCount()
    val maxCount = homeTownCount.values.max()
    val mostCommonHomeTown=homeTownCount.filter {it.value ==maxCount}.keys.first()
    println(mostCommonHomeTown)

}
fun avarageAge(){
    var averageAge :Double
    var totalAge = 0
    for (member in memberList){
        totalAge += member.age
    }
    averageAge = totalAge.toDouble()/memberList.size
    println("totalAge:${totalAge} averageAge: $averageAge ")

}
fun contact_email(){
    var arrayList = arrayListOf<ContactInformation>()
    memberList.forEach {
        arrayList.map { it.email }
    }
    arrayList.forEach { println(it.email) }

}
fun sortbymemberlevel(){
    val sortedMembers = memberList.sortedByDescending { it.memberLevel }
    for (member in sortedMembers) {
        println(member.fullName)
        println(member.memberLevel)
    }
}

fun findsametitle(title : String){
    val filterMember = memberList.filter { it.title == title }
    var conctacInformationList = filterMember.map{it.contact}
    for (i in conctacInformationList){
        println(i.phoneNumber)
    }
}
