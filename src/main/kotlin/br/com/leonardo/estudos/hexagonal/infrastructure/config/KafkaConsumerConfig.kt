package br.com.leonardo.estudos.hexagonal.infrastructure.config

import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.queue.message.CustomerMessage
import org.apache.kafka.clients.consumer.ConsumerConfig.*
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConsumerConfig {

    private val configProps = mapOf(
        BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
        GROUP_ID_CONFIG to "consumer-group-cpf-validated",
        KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
        VALUE_DESERIALIZER_CLASS_CONFIG to JsonDeserializer::class.java,
        AUTO_OFFSET_RESET_CONFIG to "earliest"
    )

    @Bean
    fun consumerFactory(): ConsumerFactory<String, CustomerMessage> =
        DefaultKafkaConsumerFactory(configProps, StringDeserializer(), JsonDeserializer(CustomerMessage::class.java))

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> =
        ConcurrentKafkaListenerContainerFactory<String, CustomerMessage>().apply { this.consumerFactory = consumerFactory() }

}