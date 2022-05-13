package com.example.githubapiapp.domain.model.dto

interface Dto<T> {
    fun toUi(): T
}