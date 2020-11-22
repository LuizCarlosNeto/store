package com.study.store.infrastructure.rabbitmq.config

import org.springframework.amqp.core.*
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FanoutConfig(private val fanoutQueue: Queue) {

    companion object {
        const val FANOUT_EXCHANGE_PAYMENT = "fanout-exchange-payment"
        const val QUEUE = "payment"
        const val ROUTING_KEY= "payment-key"

    }

    @Bean
    fun fanoutExchange(): Exchange {
        return ExchangeBuilder
                .fanoutExchange(FANOUT_EXCHANGE_PAYMENT)
                .durable(true)
                .build()
    }

    @Bean
    fun firstFanoutBinding(): Binding {
        return BindingBuilder
                .bind(fanoutQueue)
                .to(fanoutExchange())
                .with(ROUTING_KEY)
                .noargs()
    }

    @Bean
    fun jsonMessageConverter(): MessageConverter? {
        return Jackson2JsonMessageConverter()
    }



}