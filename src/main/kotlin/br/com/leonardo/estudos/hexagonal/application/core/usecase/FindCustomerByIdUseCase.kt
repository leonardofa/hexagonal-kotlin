package br.com.leonardo.estudos.hexagonal.application.core.usecase

import br.com.leonardo.estudos.hexagonal.application.core.domain.Customer
import br.com.leonardo.estudos.hexagonal.application.core.exceptions.ObjectNotFoundException
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
): FindCustomerByIdInputPort {

    override fun execute(id: String?): Customer {
        if (id == null) throw IllegalArgumentException("The id must be not null to find a customer")
        return findCustomerByIdOutputPort.execute(id) ?: throw ObjectNotFoundException("Customer not found")
    }

}