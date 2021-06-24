package com.example.reactiveProject


import com.example.reactiveProject.webClient.GreetingWebClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class ReactiveProjectApplication

fun main(args: Array<String>) {
	runApplication<ReactiveProjectApplication>(*args)
}