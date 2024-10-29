package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out

import br.com.leonardo.estudos.hexagonal.application.ports.out.SendCpfForValidationOutputPort
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class SendCpfForValidationAdapter(
    private val kafkaTemplate: KafkaTemplate<String, String>
): SendCpfForValidationOutputPort {

    override fun execute(cpf: String) {
        kafkaTemplate.send("TP_CPF_VALIDATION_INPUT", cpf)
    }

}