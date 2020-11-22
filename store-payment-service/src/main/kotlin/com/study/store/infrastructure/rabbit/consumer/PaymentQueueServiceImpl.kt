package com.study.store.infrastructure.rabbit.consumer

import com.google.gson.Gson
import com.study.store.domain.model.Payment
import com.study.store.domain.service.PaymentQueueService
import com.study.store.infrastructure.rabbit.dto.PaymentConsumerDTO
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PaymentQueueServiceImpl(private val messageConverter: MessageConverter) : PaymentQueueService {

    private val log = LoggerFactory.getLogger(javaClass)


    @RabbitListener(queues = ["payment"])
    fun receiveMessageFromJsonQueue(message: String) {
        val result = Gson().fromJson(message, PaymentConsumerDTO::class.java)
        log.info("result: $result")
        receivedFromQueue(Payment(result.cardNumber, result.orderNumber, LocalDateTime.now(), LocalDateTime.now()))
    }

    override fun receivedFromQueue(payment: Payment) {
        //TODO fazer a implementação, e organizar as classes
    }

}