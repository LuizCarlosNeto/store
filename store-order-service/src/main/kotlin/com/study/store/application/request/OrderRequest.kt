package com.study.store.application.request;

import com.fasterxml.jackson.annotation.JsonFormat
import com.study.store.domain.model.Order
import com.study.store.domain.model.Payment
import com.study.store.presentation.dto.OrderDTO
import com.sun.istack.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class OrderRequest(@NotNull val orderNumber: Long,
                        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                        val createDate: String,
                        val paymentRequest: PaymentRequest) {
    fun toModel(): Order {
        return Order(orderNumber, LocalDateTime.parse(createDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), toPayment(paymentRequest));
    }

    private fun toPayment(paymentRequest: PaymentRequest): Payment {
        return Payment(paymentRequest.cardNumber, paymentRequest.orderNumber)
    }
}
