package com.study.store.domain.model

import java.io.Serializable
import java.time.LocalDateTime

data class Payment(val cardNumber: String, val orderNumber: Long, val createDate: LocalDateTime, val confirmationDate: LocalDateTime): Serializable