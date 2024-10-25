package br.com.leonardo.estudos.hexagonal.application.core.domain

data class Customer(
    val id:String? = null,
    val name: String,
    var address: Address? = null,
    val cpf: String,
    var isValidCpf: Boolean = false
)
