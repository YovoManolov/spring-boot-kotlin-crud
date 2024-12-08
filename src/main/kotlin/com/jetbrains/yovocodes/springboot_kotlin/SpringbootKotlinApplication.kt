package com.jetbrains.yovocodes.springboot_kotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringbootKotlinApplication>(*args)
	//SpringApplication.run(SpringbootKotlinApplication::class.java, *args)
}
