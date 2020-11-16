package com.squishy.pos.models.items

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "items")
data class OrderableItem(
        @Id
        val name: String,
        val description: String = "",
        val price: Double,
        val taxable: Boolean,
        val available: Boolean,
        val alcoholic: Boolean
)