package com.study.store.domain.model

import java.io.Serializable
import java.time.LocalDateTime

data class Order (val orderNumber: Long, val createDate: LocalDateTime, val payment: Payment): Serializable