package com.study.store.domain.exception

import java.lang.RuntimeException


open class BusinessException(
        override val message: String,
        override val cause: Throwable? = null
) : RuntimeException(message, cause)