package com.example.reactiveProject.controllers

import com.example.reactiveProject.models.User
import com.example.reactiveProject.services.UserService
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@AllArgsConstructor
@RestController
@RequestMapping("users")
class UserController(@Autowired val userService: UserService) {
    @GetMapping
    fun getAll(): Flux<User?>? {
        return userService.getAll()
    }

    @PostMapping
    fun save(@RequestBody user: User): Mono<*>? {
        return userService.save(user)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Mono<User?>? {
        return userService.getById(id)
    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: String, @RequestBody user: User): Mono<User>? {
        return userService.update(user)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): Mono<*>? {
        return userService.delete(id)
    }
}