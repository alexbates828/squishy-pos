package com.squishy.pos.models.orders

import com.squishy.pos.models.items.OrderableItem
import com.squishy.pos.models.payments.Bill
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "orders")
data class Order(
        @Column(name = "items", insertable = true, updatable = true)
        @OneToMany(targetEntity = OrderableItem::class)
        val items: MutableList<OrderableItem> = mutableListOf()
) {
    constructor(items: Collection<OrderableItem>): this(items.toMutableList())
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    val id: UUID? = null

//    @CreatedDate
//    @Column(name = "created_date", nullable = false, updatable = false)
//    val createdDate: LocalDateTime? = null
//
//    @LastModifiedDate
//    @Column(name = "updated_date", nullable = false, updatable = true)
//    val updatedDate: LocalDateTime? = null

    fun getPriceTotal() = items.sumByDouble { it.price }

    fun addItemToOrder(item: OrderableItem) {
        items.add(item)
    }

    fun addItemsToOrder(itemsToAdd: Collection<OrderableItem>) {
        items.addAll(itemsToAdd)
    }

    fun toBill(): Bill {
        return Bill(this)
    }
}
