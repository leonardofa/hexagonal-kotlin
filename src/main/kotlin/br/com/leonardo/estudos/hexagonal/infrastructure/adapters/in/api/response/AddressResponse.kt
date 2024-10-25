package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.api.response

import br.com.leonardo.estudos.hexagonal.application.core.domain.Address

data class AddressResponse(
    val street: String,
    val city: String,
    val state: String,
) {
    constructor(address: Address) : this(
        address.street,
        address.city,
        address.state
    )
}
