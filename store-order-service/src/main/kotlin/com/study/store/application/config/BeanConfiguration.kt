package com.study.store.application.config

import com.study.store.domain.repository.OrderRepository
import com.study.store.domain.service.OrderService
import com.study.store.domain.service.impl.OrderServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {

    @Bean
    fun orderService(orderRepository: OrderRepository): OrderService {
        return OrderServiceImpl(orderRepository);
    }

}