package com.study.store.infrastructure.springdata.entity

import com.study.store.domain.model.Payment
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "t_payment")
class PaymentEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
        val cardNumber: String,
        val orderNumber: Long): Serializable {


    companion object {
        fun toPayment(paymentEntity: PaymentEntity): Payment {
            return Payment(cardNumber = paymentEntity.cardNumber,
                    orderNumber = paymentEntity.orderNumber)
        }
        fun toPaymentEntity(payment: Payment): PaymentEntity {
            return PaymentEntity(0, payment.cardNumber, payment.orderNumber)
        }
    }

}