package com.karelie.arch.response

class ResponseThrowable (
    var errorCode: Int,
    var errorMessage: String,
    throwable: Throwable
) : Exception(throwable)