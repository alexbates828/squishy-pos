package com.squishy.pos.models.orders

import com.squishy.pos.models.Customer
import com.squishy.pos.models.items.OrderableItem
import com.squishy.pos.models.payments.Bill

class Order(
        val items: MutableList<OrderableItem> = mutableListOf(),
        var customer: Customer
) {
    var priceTotal = items.sumByDouble { it.price }

    fun addItemToOrder(item: OrderableItem) {
        items.add(item)
    }

    fun toBill(): Bill {
        return Bill(this)
    }
}
