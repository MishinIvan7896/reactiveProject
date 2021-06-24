package com.example.reactiveProject.repository

import com.example.reactiveProject.models.Post
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface PostRepository : ReactiveMongoRepository<Post, Long> {
    abstract fun save(post: Post?): Mono<Post?>
}