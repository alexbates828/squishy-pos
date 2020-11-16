package com.squishy.pos.services

import com.squishy.pos.models.items.OrderableItem
import com.squishy.pos.models.orders.Order
import com.squishy.pos.persistence.OrdersRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrdersService(
        private val ordersDao: OrdersRepository
) {
    fun getOrderById(orderId: UUID): Order {
        val optionalOrder = ordersDao.findById(orderId)
        if (optionalOrder.isEmpty) {
            throw RuntimeException("Order with the specified UUID was not found.")
        }

        return optionalOrder.get()
    }

    fun getAllOrders(): Iterable<Order> {
        return ordersDao.findAll()
    }

    fun addItemsToOrder(orderId: UUID, items: List<OrderableItem>) {
        val order = getOrderById(orderId)
        order.addItemsToOrder(items)
        ordersDao.save(order)
    }

    fun addItemToOrder(orderId: UUID, item: OrderableItem) = addItemsToOrder(orderId, listOf(item))

    fun cancelOrder(orderId: UUID) {
        ordersDao.deleteById(orderId)
    }

    /**
     * @return the created order
     */
    fun createOrder(items: Collection<OrderableItem>): Order {
        val order = Order(items)
        ordersDao.save(order)
        return order
    }

    fun createOrder(item: OrderableItem) = createOrder(listOf(item))
}