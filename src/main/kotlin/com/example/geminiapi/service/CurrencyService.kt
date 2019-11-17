package com.example.geminiapi.service

import com.example.geminiapi.domain.Currency
import com.example.geminiapi.domain.CurrencyRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class CurrencyService(private val currencyRepository: CurrencyRepository) {

    fun findAll() : List<Currency> {
        return currencyRepository.findAll()
    }

    fun save(name: String, symbol: String): Currency {
        return currencyRepository.save(Currency(name = name, symbol = symbol))
    }

    fun delete(id: Long) {
        currencyRepository.findById(id)
            .ifPresent{ currency ->
                currencyRepository.delete(currency)
            }
    }
}