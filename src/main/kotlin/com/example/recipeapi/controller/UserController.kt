package com.example.recipeapi.controller

import com.example.recipeapi.entity.UserEntity
import com.example.recipeapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/users")
class UserController(@Autowired val userService: UserService) {


    //Create a new User
    @PostMapping("/signup")
    fun create(@RequestBody userEntity: UserEntity) : ResponseEntity<UserEntity> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userEntity))
    }

    @PostMapping("/login")
    fun read(@RequestBody userEntity: UserEntity) : ResponseEntity<Optional<UserEntity>> {
        val optional = userService.findByUsernameAndPassword(userEntity.username, userEntity.password)
        return if(!optional.isPresent) ResponseEntity.notFound().build() else ResponseEntity.ok(optional);
    }

}