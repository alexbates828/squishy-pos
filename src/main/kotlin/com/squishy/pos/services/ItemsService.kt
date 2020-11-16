package com.squishy.pos.services

import com.squishy.pos.models.items.OrderableItem
import com.squishy.pos.persistence.OrderableItemRepository
import org.springframework.stereotype.Service

@Service
class ItemsService(
        private val orderableItemRepository: OrderableItemRepository
) {
    fun getAllFoodMenuItems(): Iterable<OrderableItem> {
        return orderableItemRepository.findAll()
    }

    fun findItem(name: String): OrderableItem {
        return orderableItemRepository.findById(name).get()
    }
}