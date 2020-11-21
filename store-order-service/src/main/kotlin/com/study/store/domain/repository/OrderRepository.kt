package com.study.store.domain.repository

import com.study.store.domain.model.Order
import java.util.*

interface OrderRepository {

    fun createOrder(order: Order): Order
    fun findByByOrderNumber(orderNumber: Long): Order
}