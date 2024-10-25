package br.com.leonardo.estudos.hexagonal.application.ports.`in`

import br.com.leonardo.estudos.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {

    fun execute(customer: Customer, zipCode: String)

}