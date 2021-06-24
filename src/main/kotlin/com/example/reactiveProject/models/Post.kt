package com.example.reactiveProject.models

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.ToString
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
class Post {
    @Id
    private var id: Long? = null
    private var authorId: Long? = null
    private var text: String? = null

    fun getId() : Long? {
        return id
    }

    fun getAuthorId(): Long? {
        return authorId
    }

    fun getText() : String? {
        return text
    }
}