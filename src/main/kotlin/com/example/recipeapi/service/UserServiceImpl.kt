package com.example.recipeapi.service

import com.example.recipeapi.entity.UserEntity
import com.example.recipeapi.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Service
class UserServiceImpl(@Autowired private val userRepository: UserRepository) : UserService {


    @Transactional(readOnly = true)
    override fun findByUsernameAndPassword(username: String, password: String): Optional<UserEntity> {
        return userRepository.findByUsernameAndPassword(username, password)
    }

    @Transactional
    override fun save(userEntity: UserEntity): UserEntity {
        return userRepository.save(userEntity)
    }


}