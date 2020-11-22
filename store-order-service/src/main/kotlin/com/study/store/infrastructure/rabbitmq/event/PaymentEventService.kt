package com.study.store.infrastructure.rabbitmq.event

import com.google.gson.Gson
import com.study.store.domain.model.Payment
import com.study.store.domain.service.QueuePaymentService
import com.study.store.infrastructure.rabbitmq.config.FanoutConfig
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class PaymentEventService(private val rabbitTemplate: RabbitTemplate): QueuePaymentService {
    override fun sendPayment(payment: Payment) {
        rabbitTemplate.convertAndSend(FanoutConfig.FANOUT_EXCHANGE_PAYMENT, FanoutConfig.ROUTING_KEY, Gson().toJson(payment))
    }

}