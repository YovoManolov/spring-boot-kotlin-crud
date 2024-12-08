package com.jetbrains.yovocodes.springboot_kotlin

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/articles")
class ArticleController(val repository: ArticleRepository) {

    @GetMapping
    fun articles() = repository.findAllByOrderByCreatedAtDesc()

    @GetMapping("/{slug}")
    fun articles(@PathVariable slug: String) =
        repository.findBySlug(slug).orElseThrow() {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }

    @PostMapping
    fun newArticle(@RequestBody article: Article): Article {
        repository.save(article)
        return article
    }

    @PutMapping("/{slug}")
    fun updateArticle(@RequestBody article: Article, @PathVariable slug: String): Article {
        val existingArticle = repository.findBySlug(slug).orElseThrow() {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        existingArticle.content = article.content
        repository.save(article)
        return article
    }


    @DeleteMapping("/{slug}")
    fun deleteArticle(@PathVariable slug: String) {

        val existingArticle = repository.findBySlug(slug).orElseThrow() {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        repository.delete(existingArticle)

    }



}