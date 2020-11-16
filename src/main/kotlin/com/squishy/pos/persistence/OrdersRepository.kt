package com.squishy.pos.persistence

import com.squishy.pos.models.orders.Order
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OrdersRepository: CrudRepository<Order, UUID>