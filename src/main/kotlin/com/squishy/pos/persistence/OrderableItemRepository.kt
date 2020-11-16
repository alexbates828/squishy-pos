package com.squishy.pos.persistence

import com.squishy.pos.models.items.OrderableItem
import org.springframework.data.repository.CrudRepository
import java.util.*

interface OrderableItemRepository: CrudRepository<OrderableItem, String> {
}