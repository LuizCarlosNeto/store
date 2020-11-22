package com.study.store.application.request

data class PaymentRequest(val cardNumber: String,
                          val orderNumber: Long)