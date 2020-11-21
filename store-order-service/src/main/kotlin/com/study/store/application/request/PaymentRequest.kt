package com.study.store.application.request

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

data class PaymentRequest(val cardNumber: String,
                          val orderNumber: Long,
                          @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                          val createDate: LocalDateTime,
                          @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                          val confirmationDate: LocalDateTime)