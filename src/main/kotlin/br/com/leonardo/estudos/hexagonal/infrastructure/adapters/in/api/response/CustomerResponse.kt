package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.api.response

import br.com.leonardo.estudos.hexagonal.application.core.domain.Customer


data class CustomerResponse(
    val id: String,
    val name: String,
    var address: AddressResponse,
    val cpf: String,
    var isValidCpf: Boolean = false
) {
    constructor(customer: Customer) : this(
        customer.id!!,
        customer.name,
        AddressResponse(customer.address!!),
        customer.cpf,
        customer.isValidCpf
    )
}
