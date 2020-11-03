package com.squishy.pos.models.items

interface OrderableItem {
    val name: String
    val description: String
    val price: Double
    var available: Boolean
    val taxable: Boolean
}