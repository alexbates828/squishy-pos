package com.squishy.pos.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TerminalController {
    @GetMapping("/terminal")
    fun getTerminal(): String {
        return "terminal"
    }
}
