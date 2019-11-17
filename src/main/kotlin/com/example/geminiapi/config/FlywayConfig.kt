package com.example.geminiapi.config

import org.flywaydb.core.Flyway
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FlywayConfig {

    @Bean
    fun strategy(): FlywayMigrationStrategy {
        return FlywayMigrationStrategy { flyway ->
            flyway?.clean()
            flyway?.migrate()
        }
    }
}
