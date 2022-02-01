package com.example.recipeapi.service

import com.example.recipeapi.entity.UserEntity
import java.util.*

interface UserService {

    fun findByUsernameAndPassword(username: String, password: String) : Optional<UserEntity>
    fun save(recipeEntity: UserEntity) : UserEntity
}