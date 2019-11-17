package com.example.geminiapi.controller

import com.example.geminiapi.domain.Currency
import com.example.geminiapi.service.CurrencyService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequiredArgsConstructor
class CurrencyController(
    private val currencyService: CurrencyService
) {

    @GetMapping("/api/currency/")
    fun findAll(): ResponseEntity<CurrencyResponse> {
        return ResponseEntity(
            CurrencyResponse(currencyService.findAll()),
            HttpStatus.OK
        )
    }

    @PostMapping("/api/currency/")
    fun save(@RequestBody request: CurrencyAddRequest): ResponseEntity<HttpStatus> {
        currencyService.save(request.name, request.symbol)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @DeleteMapping("/api/currency/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<HttpStatus> {
        currencyService.delete(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}

data class CurrencyResponse(
    val currencies: List<Currency>
)

data class CurrencyAddRequest(
    val name: String,
    val symbol: String
)
