package com.example.reactiveProject.controllers

import com.example.reactiveProject.models.Post
import com.example.reactiveProject.services.PostService
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import org.springframework.web.bind.annotation.RequestBody
import reactor.core.publisher.Mono
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping


@AllArgsConstructor
@RestController
@RequestMapping("posts")
class PostController(@Autowired val postService: PostService) {

    @GetMapping
    fun getAll(): Flux<Post?>? {
        println("GET_ALL Posts::")
        return postService.getAll()
    }

    @PostMapping
    fun save(@RequestBody post: Post): Mono<*>? {
        println(
            "will insert the post ::  id = " + post.getId() + " authorId = " + post.getAuthorId() + "  text: " + post.getText()
        )
        return postService.save(post)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Mono<Post?>? {
        println("get Post with id = $id ")
        return postService.getById(id)
    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: Long, @RequestBody post: Post): Mono<*>? {
        println("update the Post :: id = " + post.getId() + " authorId = " + post.getAuthorId() + "  text: " + post.getText())
        return postService.update(post)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): Mono<*>? {
        println("will delete Post with id = $id ")
        return postService.delete(id)
    }
}