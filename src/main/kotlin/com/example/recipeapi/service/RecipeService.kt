package com.example.recipeapi.service

import com.example.recipeapi.entity.RecipeEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface RecipeService {

    fun findAll() : Iterable<RecipeEntity>
    fun findAll(pageable: Pageable) : Page<RecipeEntity>
    fun findById(id : Long) : Optional<RecipeEntity>
    fun save(recipeEntity: RecipeEntity) : RecipeEntity
    fun deleteById(id : Long)

}