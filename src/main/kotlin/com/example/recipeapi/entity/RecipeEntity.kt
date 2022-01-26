package com.example.recipeapi.entity

import lombok.Getter
import lombok.Setter
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "recipe_entity")
@Getter
@Setter
class RecipeEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "name", nullable = false)
    var name: String = ""

    @Column(name = "description", nullable = false, length = 350)
    var description: String = ""

    @Column(name = "image")
    var image : String = ""

}