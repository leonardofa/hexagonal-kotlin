package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("rabbit")
class SendCpfForValidationRabbitAdapter(
    private val rabbitTemplate: RabbitTemplate,
    private val queue: Queue
) : SendCpfForValidationAdapter {

    override fun execute(cpf: String) {
        rabbitTemplate.convertAndSend(queue.name, cpf);
    }

}