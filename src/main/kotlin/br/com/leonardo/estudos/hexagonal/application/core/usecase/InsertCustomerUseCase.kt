package br.com.leonardo.estudos.hexagonal.application.core.usecase

import br.com.leonardo.estudos.hexagonal.application.core.domain.Customer
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.InsertCustomerInputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.InsertCustomerOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort
) : InsertCustomerInputPort {

    override fun execute(customer: Customer, zipCode: String) {
        customer.apply {
            address = findAddressByZipCodeOutputPort.execute(zipCode);
        }.let {
            insertCustomerOutputPort.execute(it);
        }
    }
}