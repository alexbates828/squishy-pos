package com.squishy.pos.controllers

import com.squishy.pos.models.items.OrderableItem
import com.squishy.pos.models.orders.Order
import com.squishy.pos.services.OrdersService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import java.util.*
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.HttpHeaders


@RestController
@RequestMapping("/orders")
class OrderController(
        private val ordersService: OrdersService
) {
    @PostMapping("/create")
    fun startOrder(@RequestParam items: List<OrderableItem>?): ResponseEntity<String> {
        val order = ordersService.createOrder(items ?: listOf())

        val location: URI = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/orders/{orderId}")
                .buildAndExpand(order.id)
                .toUri()

        return ResponseEntity.status(HttpStatus.CREATED)
                .header(HttpHeaders.LOCATION, location.toString())
                .build<String>()
    }

    @PostMapping("/{orderId}/addItems")
    fun addItemsToOrder(@PathVariable orderId: UUID, @RequestParam items: List<OrderableItem>) {
        ordersService.addItemsToOrder(orderId, items)
    }

    @DeleteMapping("/{orderId}")
    fun cancelOrder(@PathVariable orderId: UUID) {
        ordersService.cancelOrder(orderId)
    }

    @GetMapping("/{orderId}")
    fun getOrderById(@PathVariable orderId: UUID): ResponseEntity<Order> {
        try {
            val order = ordersService.getOrderById(orderId)
            return ResponseEntity(order, HttpStatus.OK)
        } catch (e: RuntimeException) {
            throw WebApplicationException(e.message)
        }
    }

    @GetMapping("/all")
    fun getAllOrders(): ResponseEntity<Iterable<Order>> {
        val orders = ordersService.getAllOrders()
        return ResponseEntity(orders, HttpStatus.OK)
    }
}