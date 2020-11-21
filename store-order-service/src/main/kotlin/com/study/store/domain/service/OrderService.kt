package com.study.store.domain.service

import com.study.store.domain.model.Order
import java.util.*

interface OrderService {
    fun createOrder(order: Order): Order
    fun getOrderByOrderNumber(orderNumber: Long): Order
}