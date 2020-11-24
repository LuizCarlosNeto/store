package com.study.store.application.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.study.store.application.request.OrderRequest
import com.study.store.application.request.PaymentRequest
import com.study.store.domain.model.Order
import com.study.store.domain.model.Payment
import com.study.store.domain.service.OrderService
import com.study.store.infrastructure.rabbitmq.event.PaymentEventService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@ExtendWith(SpringExtension::class)
@WebMvcTest(controllers = arrayOf(OrderController::class))
@AutoConfigureMockMvc
class OrderControllerTest {

    private val URI_ORDERS = "/api/orders"

    @Autowired
    val mockMvc: MockMvc? = null

    @MockBean
    val orderService: OrderService? = null

    @MockBean
    val paymentService: PaymentEventService? = null

    //private val currentDate = LocalDateTime.parse("2020-11-19 15:30:22", DateTimeFormatter.ISO)
    private var currentDate = LocalDateTime.parse("2016-10-31 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))


    @Test
    fun `should be create order in api`() {
        val orderRequest = getOrderRequest()

        BDDMockito.given(orderService?.createOrder(any<Order>())).willReturn(getOrder())


        val json = ObjectMapper().writeValueAsString(orderRequest)
        val request: MockHttpServletRequestBuilder = MockMvcRequestBuilders
                .post(URI_ORDERS)
                .contentType(MediaType.APPLICATION_JSON)
                //.accept(MediaType.APPLICATION_JSON)
                .content(json)

        mockMvc?.perform(request)
                ?.andExpect(MockMvcResultMatchers.status().isCreated)

    }

    fun getOrder(): Order = Order(1, currentDate, getPayment())
    private fun getPayment(): Payment = Payment("", 1)

    private fun getOrderRequest(): OrderRequest = OrderRequest(1, "2020-11-19 15:30:22", getPaymentRequest())

    private fun getPaymentRequest(): PaymentRequest = PaymentRequest("3212321232", 1)

    inline fun <reified T : Any> any() = Mockito.any(Order::class.java) ?: getOrder()
}