package com.example.recipeapi.service

import com.example.recipeapi.entity.RecipeEntity
import com.example.recipeapi.repository.RecipeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class RecipeServiceImpl(@Autowired private val recipeRepository: RecipeRepository) : RecipeService {

    @Transactional(readOnly = true)
    override fun findAll(): Iterable<RecipeEntity> {
        return recipeRepository.findAll()
    }

    @Transactional(readOnly = true)
    override fun findAll(pageable: Pageable): Page<RecipeEntity> {
        return recipeRepository.findAll(pageable)
    }

    @Transactional(readOnly = true)
    override fun findById(id: Long): Optional<RecipeEntity> {
        return recipeRepository.findById(id)
    }

    @Transactional
    override fun save(recipeEntity: RecipeEntity): RecipeEntity {
        return recipeRepository.save(recipeEntity)
    }

    @Transactional
    override fun deleteById(id: Long) {
        return recipeRepository.deleteById(id)
    }


}