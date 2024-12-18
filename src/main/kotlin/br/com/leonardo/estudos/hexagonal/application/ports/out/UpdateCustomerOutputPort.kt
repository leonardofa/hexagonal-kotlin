package br.com.leonardo.estudos.hexagonal.application.ports.out

import br.com.leonardo.estudos.hexagonal.application.core.domain.Customer

interface UpdateCustomerOutputPort {

    fun execute(customer: Customer): Customer

}