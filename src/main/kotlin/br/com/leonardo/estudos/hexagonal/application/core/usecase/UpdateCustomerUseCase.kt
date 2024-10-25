package br.com.leonardo.estudos.hexagonal.application.core.usecase

import br.com.leonardo.estudos.hexagonal.application.core.domain.Customer
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase (
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort,
): UpdateCustomerInputPort {

    override fun execute(customer: Customer, zipCode: String) {
        findCustomerByIdInputPort.execute(customer.id)
        customer.apply {
            address = findAddressByZipCodeOutputPort.execute(zipCode)
        }.let {
            updateCustomerOutputPort.execute(it)
        }
    }
}