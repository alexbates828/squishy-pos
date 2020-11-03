package com.squishy.pos

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration(exclude= [DataSourceAutoConfiguration::class, HibernateJpaAutoConfiguration::class])
class PosApplication

fun main(args: Array<String>) {
	runApplication<PosApplication>(*args)
}
