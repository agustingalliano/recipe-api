package com.example.recipeapi.repository

import com.example.recipeapi.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByUsernameAndPassword(username: String, password: String) : Optional<UserEntity>

}