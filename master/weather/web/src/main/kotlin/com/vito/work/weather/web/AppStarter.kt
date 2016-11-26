package com.vito.work.weather.web

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.web.filter.CharacterEncodingFilter
import javax.servlet.Filter

/**
 * Created by lingzhiyuan.
 * Date : 16/3/31.
 * Time : 下午4:28.
 * Description:
 *
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = arrayOf("com.vito.work.weather.domain.entities"))
@EnableJpaRepositories(basePackages = arrayOf("com.vito.work.weather.domain.daos"))
@ComponentScan(basePackages = arrayOf("com.vito.work.weather.web", "com.vito.work.weather.domain"))
open class AppStarter {

    @Bean
    open fun errorAttributes(): DefaultErrorAttributes {
        return DefaultErrorAttributes()
    }

    @Bean
    open fun charsetFilter(): Filter {
        val charFilter = CharacterEncodingFilter()
        charFilter.encoding = "UTF-8"
        charFilter.setForceEncoding(true)
        return charFilter;
    }

    @Bean
    open fun objectMapperBuilder(): Jackson2ObjectMapperBuilder
            = Jackson2ObjectMapperBuilder().modulesToInstall(KotlinModule())

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val application = SpringApplication(AppStarter::class.java)
            application.setAddCommandLineProperties(false)
            application.run(*args)
        }
    }
}