package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.queue.consumer

import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.queue.message.CustomerMessage

interface ReceiveValidatedCustomerDataConsumer {
    fun receive(message: CustomerMessage)
}