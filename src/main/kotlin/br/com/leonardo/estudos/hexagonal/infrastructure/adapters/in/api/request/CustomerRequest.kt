package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.api.request

import jakarta.validation.constraints.NotBlank

data class CustomerRequest(
    @field:NotBlank(message = "Name must not be blank")
    val name: String,
    @field:NotBlank(message = "CPF must not be blank")
    val cpf: String,
    @field:NotBlank(message = "ZipCode must not be blank")
    val zipCode: String,
)
