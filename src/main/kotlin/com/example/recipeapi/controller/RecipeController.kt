package com.example.recipeapi.controller

import com.example.recipeapi.entity.RecipeEntity
import com.example.recipeapi.service.RecipeService
import org.springframework.http.ResponseEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors
import java.util.stream.StreamSupport

@RestController
@RequestMapping("/api/recipes")
class RecipeController(@Autowired val recipeService: RecipeService) {



    //Create a new Recipe
    @PostMapping
    fun create(@RequestBody recipeEntity: RecipeEntity) : ResponseEntity<RecipeEntity> {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.save(recipeEntity))
    }

    //Read a Recipe
    @GetMapping("/{id}")
    fun read(@PathVariable id: Long) : ResponseEntity<Optional<RecipeEntity>> {
        val optional = recipeService.findById(id)
        return if(!optional.isPresent) ResponseEntity.notFound().build() else ResponseEntity.ok(optional);
    }

    //Update a Recipe
    @PutMapping("{id}")
    fun update(@RequestBody recipeEntity: RecipeEntity, @PathVariable id : Long) : ResponseEntity<RecipeEntity> {
        val recipe = recipeService.findById(id)

        if(!recipe.isPresent){
            return ResponseEntity.notFound().build();
        }

        recipe.get().name = recipeEntity.name
        recipe.get().description = recipeEntity.description
        recipe.get().image = recipeEntity.image

        return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.save(recipe.get()))
    }

    //Delete a Recipe
    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<RecipeEntity> {

        if(!recipeService.findById(id).isPresent){
            return ResponseEntity.notFound().build();
        }

        recipeService.deleteById(id)
        return ResponseEntity.ok().build()
    }

    //Read all recipes
    @GetMapping
    fun readAll() : List<RecipeEntity> {
        return StreamSupport.stream(recipeService.findAll().spliterator(), false).collect(Collectors.toList())
    }

//    @GetMapping("/search")
//    fun search(@RequestParam String filter): ResponseEntity<> {
//        return  ResponseEntity.status(HttpStatus.OK).body(recipeService.save(filter))
//    }


}