package br.com.leonardo.estudos.hexagonal.infrastructure.client.response

import br.com.leonardo.estudos.hexagonal.application.core.domain.Address

class AddressResponse(
    private val street: String,
    private val city: String,
    private val state: String,
) {
    fun toAddress() = Address(street, city, state)
}
