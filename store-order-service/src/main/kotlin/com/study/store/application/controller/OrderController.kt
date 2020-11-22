package com.study.store.application.controller

import com.study.store.application.request.OrderRequest
import com.study.store.domain.exception.BusinessException
import com.study.store.domain.model.Order
import com.study.store.domain.service.OrderService
import com.study.store.infrastructure.rabbitmq.event.PaymentEventService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/orders"])
class OrderController(private val orderService: OrderService, private val paymentEventService: PaymentEventService) {

    @PostMapping
    fun createOrder(@RequestBody orderRequest: OrderRequest): ResponseEntity<Order>  {
        val order = orderRequest.toModel()
        paymentEventService.sendPayment(order.payment)
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping("/{numberOrder}")
    fun getOrderByNumberOrder(@PathVariable(name = "numberOrder") orderNumber: Long): ResponseEntity<Order> {
        return ResponseEntity.ok(orderService.getOrderByOrderNumber(orderNumber))
    }
}