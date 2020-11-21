package com.study.store.application.controller

import com.study.store.application.request.OrderRequest
import com.study.store.domain.exception.BusinessException
import com.study.store.domain.model.Order
import com.study.store.domain.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/orders"])
class OrderController(private val orderService: OrderService) {

    @PostMapping
    fun createOrder(@RequestBody orderRequest: OrderRequest): ResponseEntity<Order> = ResponseEntity.ok(orderService.createOrder(orderRequest.toModel()));

    @GetMapping("/{numberOrder}")
    fun getOrderByNumberOrder(@PathVariable(name = "numberOrder") orderNumber: Long): ResponseEntity<Order> {
        return ResponseEntity.ok(orderService.getOrderByOrderNumber(orderNumber))
    }
}