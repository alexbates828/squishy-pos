package com.squishy.pos

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration//(exclude= [DataSourceAutoConfiguration::class, HibernateJpaAutoConfiguration::class])
class PosApplication

fun main(args: Array<String>) {
	runApplication<PosApplication>(*args)
}
