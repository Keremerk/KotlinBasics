package com.example.myapplication
object MemberList {


    val memberList = arrayListOf(NeonAcademyMember("atilla","Android Developer","aslan","A1","malatya",28,
        ContactInformation(54345445454,"atilla@neonapps.co"),Team.ANDROID_DEVELOPMENT,10,mentorLevel(false)),
        NeonAcademyMember("steve jobs","İOS Developer","ikizler","A3","bursa",26,
            ContactInformation(543,"steve@neonapps.co"),Team.IOS_DEVELOPMENT,1,mentorLevel(false)),
        NeonAcademyMember("emirhan","Android Developer","boğa","B1","malatya",22,
            ContactInformation(586,"emirhan@neonapps.co"),Team.ANDROID_DEVELOPMENT,null,mentorLevel(false)),
        NeonAcademyMember("mahmut","İOS Developer","boğa","A5","bursa",55,
            ContactInformation(544,"mahmut@neonapps.co"),Team.UI_UX_DESIGN,3,mentorLevel(false)),
        NeonAcademyMember("KeremErkubilay","Android Developer","Taurus","A1","Düzce",21,
            ContactInformation(5434549137,"kerem@neonapps.co"),Team.ANDROID_DEVELOPMENT,10,mentorLevel(false)),
        NeonAcademyMember("oguzhansatilmis","Android Developer","ikizler","A1","ankara",25,
            ContactInformation(536,"deneme@neonapps.co"),Team.ANDROID_DEVELOPMENT,8,mentorLevel(true)))
}