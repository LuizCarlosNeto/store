package com.study.store.domain.service

import com.study.store.domain.model.Payment

interface QueuePaymentService {

    fun sendPayment(payment: Payment)
}