package br.com.leonardo.estudos.hexagonal.application.core.usecase

import br.com.leonardo.estudos.hexagonal.application.core.domain.Customer
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.InsertCustomerInputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.InsertCustomerOutputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.SendCpfForValidationOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
) : InsertCustomerInputPort {

    override fun execute(customer: Customer, zipCode: String): Customer {
        customer.apply {
            address = findAddressByZipCodeOutputPort.execute(zipCode);
        }.let {
            sendCpfForValidationOutputPort.execute(it.cpf)
            return insertCustomerOutputPort.execute(it);
        }
    }
}