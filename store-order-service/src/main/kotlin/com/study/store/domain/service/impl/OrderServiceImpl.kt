package com.study.store.domain.service.impl

import com.study.store.domain.model.Order
import com.study.store.domain.repository.OrderRepository
import com.study.store.domain.service.OrderService

class OrderServiceImpl(private val orderRepository: OrderRepository) : OrderService {

    override fun createOrder(order: Order): Order = orderRepository.createOrder(order);

    override fun getOrderByOrderNumber(orderNumber: Long): Order  = orderRepository.findByByOrderNumber(orderNumber)
}