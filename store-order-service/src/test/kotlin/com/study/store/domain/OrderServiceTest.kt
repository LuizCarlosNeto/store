package com.study.store.domain

import com.study.store.domain.model.Order
import com.study.store.domain.model.Payment
import com.study.store.domain.repository.OrderRepository
import com.study.store.domain.service.OrderService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime
import java.time.Month

@ExtendWith(SpringExtension::class)
@ActiveProfiles("test")
@SpringBootTest
class OrderServiceTest {

    @MockBean
    private val orderRepository: OrderRepository? = null

    @Autowired
    private val orderService: OrderService? = null

    private val currentDate = LocalDateTime.of(2020, Month.OCTOBER, 8, 10, 49, 27)

    @BeforeEach
    internal fun setUp() {

    }

    @Test
    fun `should be create a order`() {
        val order = getOrder()
        BDDMockito.given(orderService?.createOrder(order)).willReturn(getOrder())
        val saved = orderService?.createOrder(order)

        //utilizando jupiter
        Assertions.assertNotNull(saved)
        Assertions.assertEquals(saved?.orderNumber, order.orderNumber)
        Assertions.assertEquals(saved?.createDate, order.createDate)

        //utilizando assertj
        org.assertj.core.api.Assertions.assertThat(saved?.orderNumber).isEqualTo(order.orderNumber)


    }

    @Test
    fun `should be get a order by order number`() {
        BDDMockito.given(orderRepository?.findByByOrderNumber(Mockito.anyLong())).willReturn(getOrder())
        val order = orderService?.getOrderByOrderNumber(1)
        Assertions.assertNotNull(order)
        org.assertj.core.api.Assertions.assertThat(order?.orderNumber).isEqualTo(1)

    }

    fun getOrder(): Order = Order(1, currentDate, getPayment())
    fun getPayment(): Payment = Payment("",1)
}