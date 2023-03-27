package com.example.myapplication

data class NeonAcademyMember(
    val fullName: String,
    val title: String,
    val horoscope: String,
    val memberLevel: String,
    val homeTown: String,
    var age: Int,
    val contact: ContactInformation,
    var team :Team,
    val mentorLevel1: Int?,
    val mentorLevel: mentorLevel,
    var motivationLevel :Int?
)
enum class Team {
        IOS_DEVELOPMENT,
        ANDROID_DEVELOPMENT,
        UI_UX_DESIGN
}
