package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out

import org.springframework.context.annotation.Profile
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
@Profile("kafka")
class SendCpfForValidationKafkaAdapter(private val kafkaTemplate: KafkaTemplate<String, String>):SendCpfForValidationAdapter {

    override fun execute(cpf: String) {
        kafkaTemplate.send("TP_CPF_VALIDATION_INPUT", cpf)
    }

}