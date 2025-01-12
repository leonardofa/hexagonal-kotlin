package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.queue.consumer

import br.com.leonardo.estudos.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.queue.message.CustomerMessage
import org.springframework.context.annotation.Profile
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
@Profile("kafka")
class ReceiveValidatedCustomerDataKafkaConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort
) : ReceiveValidatedCustomerDataConsumer {

    @KafkaListener(topics = ["TP_CPF_VALIDATED_OUTPUT"], groupId = "consumer-group-cpf-validated")
    override fun receive(message: CustomerMessage) {
        with(message) {
            updateCustomerInputPort.execute(toCustomer(), zipCode)
        }
    }

}