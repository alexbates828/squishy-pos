package com.squishy.pos.models.payments

import com.squishy.pos.models.items.OrderableItem

class FractionalItem(val orderableItem: OrderableItem, val weight: Double = 1.0) {
    val cost = orderableItem.price * weight

    constructor(fractionalItem: FractionalItem, weight: Double) {
        FractionalItem(fractionalItem.orderableItem, weight)
    }
}
