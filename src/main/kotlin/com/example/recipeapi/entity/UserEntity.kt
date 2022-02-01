package com.example.recipeapi.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "user_entity")
@Getter
@Setter
class UserEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "username", nullable = false)
    var username: String = ""

    @Column(name = "password", nullable = false)
    var password: String = ""

}