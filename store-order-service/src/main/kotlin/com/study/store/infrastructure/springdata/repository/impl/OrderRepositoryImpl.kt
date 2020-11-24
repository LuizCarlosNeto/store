package com.study.store.infrastructure.springdata.repository.impl

import com.study.store.domain.exception.BusinessException
import com.study.store.domain.model.Order
import com.study.store.domain.repository.OrderRepository
import com.study.store.infrastructure.springdata.entity.OrderEntity
import com.study.store.infrastructure.springdata.repository.OrderEntityRepository
import org.springframework.stereotype.Component

@Component
class OrderRepositoryImpl(private val orderEntityRepository: OrderEntityRepository):  OrderRepository{
    override fun createOrder(order: Order): Order {
      return orderEntityRepository.save(OrderEntity.fromOrder(order))?.let { savedOrder -> savedOrder.toModel() }
    }

    override fun findByByOrderNumber(orderNumber: Long): Order {
        val order = orderEntityRepository.findByOrderNumber(orderNumber)
        if (order.isEmpty) {
            throw BusinessException("Ordem não encontrada")
        } else return order.get().toModel()
    }

    override fun findByByOrderNumberCheck(orderNumber: Long): Boolean {
        val order = orderEntityRepository.findByOrderNumber(orderNumber)
        if (order.isPresent) {
            throw BusinessException("Ordem já cadastrada na base de dados")
        }
        return order.isPresent
    }
}