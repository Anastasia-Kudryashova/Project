package com.example.project.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Task(
    @SerialName("Id")
    val  id: Int? = null,
    @SerialName("Title")
    var title: String,
    @SerialName("Text")
    var text: String,
    @Transient
    var expended: Boolean = false
)
