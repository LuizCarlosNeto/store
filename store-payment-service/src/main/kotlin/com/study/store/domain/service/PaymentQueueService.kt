package com.study.store.domain.service

import com.study.store.domain.model.Payment
import com.study.store.infrastructure.rabbit.dto.PaymentConsumerDTO
import java.util.*

interface PaymentQueueService {

    fun receivedFromQueue(objects: Payment)
}