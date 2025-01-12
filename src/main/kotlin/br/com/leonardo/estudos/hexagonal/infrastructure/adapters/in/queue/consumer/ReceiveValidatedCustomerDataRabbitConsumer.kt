package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.queue.consumer

import br.com.leonardo.estudos.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.queue.message.CustomerMessage
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.context.annotation.Profile
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
@Profile("rabbit")
class ReceiveValidatedCustomerDataRabbitConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort
) : ReceiveValidatedCustomerDataConsumer {

    @RabbitListener(queues = ["TP_CPF_VALIDATED_OUTPUT"])
    override fun receive(@Payload message: CustomerMessage) {
        with(message) {
            updateCustomerInputPort.execute(toCustomer(), zipCode)
        }
    }

}