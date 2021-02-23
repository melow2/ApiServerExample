package com.khs.example.user

import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class UserDaoService {

    fun findAll() = users

    fun findOne(id:Int): User? {
        var user:User?=null
        users.forEach {
            if(it.id==id) {
                user= it
                return@forEach
            }
        }
        return user
    }

    fun save(user:User){
        if(user.id==null) user.id == users.size+1
        users.add(user)
    }


    companion object{
        private val users = ArrayList<User>().apply {
            add(User(1,"Kevin", Date()))
            add(User(2,"Lonely", Date()))
            add(User(3,"Happy", Date()))
        }
    }

}