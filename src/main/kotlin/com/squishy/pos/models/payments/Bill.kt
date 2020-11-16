package com.squishy.pos.models.payments

import com.squishy.pos.models.orders.Order
import com.squishy.pos.models.payments.PaymentMethod

class Bill(
        val itemsPurchased: MutableList<FractionalItem> = mutableListOf(),
        val gratuityInPercent: Double = 0.0
) {
    val subtotal: Double = itemsPurchased.sumByDouble { it.cost }
    val tax: Double = calculateTax()
    val gratuityAmount = subtotal * gratuityInPercent
    val total = subtotal + tax + gratuityAmount
    var isOpen = true
    val payments: MutableList<PaymentMethod> = mutableListOf()

    fun show() {
        itemsPurchased.forEach { println("${it.weight}    ${it.orderableItem.name}") }
        println("-----")
        println("Subtotal: $subtotal")
        println("Tax:      $tax")
        println("Total:    $total")
    }

    fun calculateTax(): Double {
        return itemsPurchased.sumByDouble {
            val taxRate = if (it.orderableItem.taxable) 0.055 else 0.0
            it.cost * taxRate
        }
    }

    fun splitEvenly(ways: Int): List<Bill> {
        if (ways < 1) {
            throw IllegalArgumentException("Cannot split a bill less than 1 way!")
        }

        val splitItems = itemsPurchased.map { FractionalItem(it, it.weight/ways) }.toMutableList()
        return (1..ways).map { Bill(splitItems, gratuityInPercent) }
    }

    // single payer, direct order to bill
    constructor(order: Order, gratuityInPercent: Double = 0.0) : this(gratuityInPercent = gratuityInPercent) {
        val fractionalItems = order.items.map { FractionalItem(it) }
        this.itemsPurchased.addAll(fractionalItems)
    }
}