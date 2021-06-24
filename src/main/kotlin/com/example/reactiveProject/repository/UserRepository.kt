package com.example.reactiveProject.repository

import com.example.reactiveProject.models.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono


interface UserRepository : ReactiveMongoRepository<User, Long> {
    fun findByUsername(name: String?): Mono<User?>?
}