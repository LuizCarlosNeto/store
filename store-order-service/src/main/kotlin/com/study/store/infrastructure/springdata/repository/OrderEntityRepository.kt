package com.study.store.infrastructure.springdata.repository

import com.study.store.domain.model.Order
import com.study.store.infrastructure.springdata.entity.OrderEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OrderEntityRepository: CrudRepository<OrderEntity, Long> {

    fun findByOrderNumber(orderNumber: Long): Optional<OrderEntity>
}