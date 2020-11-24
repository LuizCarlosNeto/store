package com.study.store.domain.service.impl

import com.study.store.domain.exception.BusinessException
import com.study.store.domain.model.Order
import com.study.store.domain.repository.OrderRepository
import com.study.store.domain.service.OrderService

class OrderServiceImpl(private val orderRepository: OrderRepository) : OrderService {

    override fun createOrder(order: Order): Order  {
        if (orderRepository.findByByOrderNumberCheck(order.orderNumber)) {
            throw BusinessException("Ordem já cadastrada já cadastrada")
        }
        return orderRepository.createOrder(order);
    }

    override fun getOrderByOrderNumber(orderNumber: Long): Order  = orderRepository.findByByOrderNumber(orderNumber)
}