package com.example.reactiveProject.services

import com.example.reactiveProject.models.User
import com.example.reactiveProject.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(@Autowired val userRepository: UserRepository) : ReactiveUserDetailsService {
    fun getAll(): Flux<User?>? {
        return userRepository.findAll().switchIfEmpty(Flux.empty())
    }

    fun save(user: User): Mono<*>? {
        return userRepository.save(user)
    }

    fun getById(id: Long): Mono<User?> {
        return userRepository.findById(id)
    }

    fun update(user: User): Mono<User>? {
        return userRepository.save(user)
    }

    fun delete(id: Long): Mono<*>? {
        return userRepository.deleteById(id)
    }

    override fun findByUsername(username: String?): Mono<UserDetails>? {
        return userRepository.findByUsername(username)?.cast(UserDetails::class.java)
    }
}