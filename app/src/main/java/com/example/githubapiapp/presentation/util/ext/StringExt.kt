package com.example.githubapiapp.presentation.util.ext

fun String.replaceSlash() = this.replace("/", "\\fakeSlash\\")

fun String.replaceFakeSlash() = this.replace("\\fakeSlash\\", "/")

fun String.setSizeInImageUrl(size: Int) = "$this&size=$size"
