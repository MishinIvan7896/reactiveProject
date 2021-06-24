package com.example.reactiveProject.services

import com.example.reactiveProject.models.Post
import com.example.reactiveProject.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class PostService(@Autowired val postRepository: PostRepository) {

    fun getAll(): Flux<Post?>? {
        return postRepository.findAll().switchIfEmpty(Flux.empty())
    }

    fun save(post: Post): Mono<*>? {
        return postRepository.save(post)
    }

    fun getById(id: Long): Mono<Post?> {
        return postRepository.findById(id)
    }

    fun update(post: Post): Mono<*>? {
        return postRepository.save(post)
    }

    fun delete(id: Long): Mono<*>? {
        return postRepository.deleteById(id)
    }

}


