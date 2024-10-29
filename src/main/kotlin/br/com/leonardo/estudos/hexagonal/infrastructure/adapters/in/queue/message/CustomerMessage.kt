package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.queue.message

import br.com.leonardo.estudos.hexagonal.application.core.domain.Customer

data class CustomerMessage(
    val id:String,
    val name: String,
    val zipCode: String,
    val cpf: String,
    val isValidCpf: Boolean,
) {
    fun toCustomer() = Customer(id = id, name = name, cpf = cpf, isValidCpf = isValidCpf)
}
