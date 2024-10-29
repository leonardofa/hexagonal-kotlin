package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.queue.consumer

import br.com.leonardo.estudos.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.queue.message.CustomerMessage
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCustomerDataConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort
) {

    @KafkaListener(topics = ["TP_CPF_VALIDATED_OUTPUT"], groupId = "consumer-group-cpf-validated")
    fun receive(message: CustomerMessage) {
        with(message) {
            updateCustomerInputPort.execute(toCustomer(), zipCode)
        }
    }

}