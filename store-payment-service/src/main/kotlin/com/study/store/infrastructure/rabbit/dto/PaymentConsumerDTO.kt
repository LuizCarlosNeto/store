package com.study.store.infrastructure.rabbit.dto

import java.io.Serializable
import java.time.LocalDateTime

data class PaymentConsumerDTO(val cardNumber: String, val orderNumber: Long): Serializable