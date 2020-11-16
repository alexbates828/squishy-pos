package com.squishy.pos.controllers

import com.squishy.pos.models.items.OrderableItem
import com.squishy.pos.services.ItemsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/items")
class ItemController(private val itemsService: ItemsService) {

    @GetMapping("/food")
    fun getAllFoodItems(): ResponseEntity<List<OrderableItem>> {
        val all = itemsService.getAllFoodMenuItems()
        return ResponseEntity(all.toList(), HttpStatus.OK)
    }
}
