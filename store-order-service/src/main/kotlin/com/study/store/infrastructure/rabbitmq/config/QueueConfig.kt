package com.study.store.infrastructure.rabbitmq.config

import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.QueueBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueueConfig {

    @Bean
    fun fanoutQueue(): Queue {
        return QueueBuilder
                .durable(FanoutConfig.QUEUE)
                .build()
    }
}