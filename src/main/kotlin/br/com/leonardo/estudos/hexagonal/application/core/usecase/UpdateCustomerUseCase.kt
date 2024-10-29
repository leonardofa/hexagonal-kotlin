package br.com.leonardo.estudos.hexagonal.application.core.usecase

import br.com.leonardo.estudos.hexagonal.application.core.domain.Customer
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.SendCpfForValidationOutputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort,
) : UpdateCustomerInputPort {

    override fun execute(customer: Customer, zipCode: String): Customer {
        findCustomerByIdInputPort.execute(customer.id).let {
            customer.apply { address = findAddressByZipCodeOutputPort.execute(zipCode) }
            if (it.cpf != customer.cpf) {
                sendCpfForValidationOutputPort.execute(customer.cpf)
            }
            return updateCustomerOutputPort.execute(customer)
        }
    }
}