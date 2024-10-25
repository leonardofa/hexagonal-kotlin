package br.com.leonardo.estudos.hexagonal.infrastructure.repository.entity

import br.com.leonardo.estudos.hexagonal.application.core.domain.Customer
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document(collection = "customers")
data class CustomerEntity(
    @MongoId val id: String?,
    val name: String,
    val address: AddressEntity,
    val cpf: String,
    val isValidCpf: Boolean,
) {
    constructor(customer: Customer) : this(
        customer.id,
        customer.name,
        AddressEntity(customer.address!!),
        customer.cpf,
        customer.isValidCpf,
    )

    fun toCustomer() = Customer(id, name, address.toAddress(), cpf, isValidCpf)
}