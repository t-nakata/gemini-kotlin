package com.example.geminiapi.domain

import org.springframework.data.jpa.repository.JpaRepository

interface CurrencyRepository : JpaRepository<Currency, Long>