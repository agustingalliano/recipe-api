package com.example.recipeapi

import com.example.recipeapi.repository.RecipeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class RecipeApiApplication

fun main(args: Array<String>) {


    runApplication<RecipeApiApplication>(*args)
}
