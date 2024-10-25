package br.com.leonardo.estudos.hexagonal.application.ports.`in`

import br.com.leonardo.estudos.hexagonal.application.core.domain.Customer

interface FindCustomerByIdInputPort {

    fun execute(id: String?): Customer

}