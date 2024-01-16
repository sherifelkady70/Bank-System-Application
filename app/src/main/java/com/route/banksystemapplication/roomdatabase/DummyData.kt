package com.route.banksystemapplication.roomdatabase

import com.route.banksystemapplication.roomdatabase.entities.UsersTable

class DummyData {
    companion object{
        val dummyList = ArrayList<UsersTable>()

        fun getDummyData() : List<UsersTable>{
            dummyList.add(UsersTable(1,"sherif Abdelrhman","selkady038@gmail.com",10000))
            dummyList.add(UsersTable(2,"mohamed Abelrhman","mohamed@gmail.com",10000))
            dummyList.add(UsersTable(3,"amr Abdelrhman","amr@gmail.com",15000))
            dummyList.add(UsersTable(4,"Abdelrhman Shehata","abdo@gmail.com",20000))
            dummyList.add(UsersTable(5,"sahar Twfik","sahar@gmail.com",5000))
            dummyList.add(UsersTable(6,"ahmed mostafa","ahmed@gmail.com",10000))
            dummyList.add(UsersTable(7,"mohamed Ayoub","ayoub@gmail.com",8000))
            dummyList.add(UsersTable(8,"mohamed waleed","waleed@gmail.com",9000))
            dummyList.add(UsersTable(9,"mostafa alaa","alaa@gmail.com",7000))
            dummyList.add(UsersTable(10,"tamer ahmed","tamer@gmail.com",6000))
            return dummyList
        }
    }
}