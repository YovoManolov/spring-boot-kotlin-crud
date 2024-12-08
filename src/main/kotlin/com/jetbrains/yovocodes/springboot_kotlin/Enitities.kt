package com.jetbrains.yovocodes.springboot_kotlin

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.aot.generate.GeneratedTypeReference
import java.time.LocalDateTime

@Entity
class Article(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var title: String,
    var content: String,
    var createdAt: LocalDateTime = LocalDateTime.now(),

    var slug: String = title.toSlug()

)
