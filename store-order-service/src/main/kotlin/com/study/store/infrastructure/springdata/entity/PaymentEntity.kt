package com.study.store.infrastructure.springdata.entity

import com.study.store.domain.model.Payment
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "t_payment")
class PaymentEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
        val cardNumber: String,
        val orderNumber: Long,
        val createDate: LocalDateTime,
        val confirmationDate: LocalDateTime) {


    companion object {
        fun toPayment(paymentEntity: PaymentEntity): Payment {
            return Payment(cardNumber = paymentEntity.cardNumber,
                    orderNumber = paymentEntity.orderNumber,
                    createDate = paymentEntity.createDate,
                    confirmationDate = paymentEntity.confirmationDate)
        }
        fun toPaymentEntity(payment: Payment): PaymentEntity {
            return PaymentEntity(0, payment.cardNumber, payment.orderNumber, payment.createDate, payment.confirmationDate)
        }
    }

}