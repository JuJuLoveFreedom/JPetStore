package cn.net.pikachu

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration

@SpringBootApplication
class SpringDataJspMvcApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringDataJspMvcApplication::class.java, *args)
}
@Configuration
class MyRepositoryRestMvcConfiguration : RepositoryRestMvcConfiguration()

@Configuration
@Import(RepositoryRestMvcConfiguration::class)
@EnableCaching
class AppConfig