package com.study.store.infrastructure.springdata.entity;

import com.study.store.domain.model.Order
import com.study.store.domain.model.Payment
import java.time.LocalDateTime
import javax.persistence.*;

@Entity
@Table(name = "t_order")
class OrderEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val orderNumber: Long,
        val createDate: LocalDateTime,
        @OneToOne(cascade = [CascadeType.ALL],
                fetch = FetchType.LAZY, optional = false)
        val paymentEntity: PaymentEntity) {

    companion object {
        fun fromOrder(order: Order): OrderEntity {
            return OrderEntity(order.orderNumber, order.createDate, PaymentEntity.toPaymentEntity(order.payment))
        }
    }
    fun toModel(): Order {
        return Order(orderNumber = orderNumber, createDate = createDate, payment = PaymentEntity.toPayment(this.paymentEntity))
    }
}
