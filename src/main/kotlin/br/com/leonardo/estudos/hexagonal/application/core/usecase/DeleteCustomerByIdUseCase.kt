package br.com.leonardo.estudos.hexagonal.application.core.usecase

import br.com.leonardo.estudos.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val deleteCustomerByIdOutputPort: DeleteCustomerByIdOutputPort
) : DeleteCustomerByIdInputPort {

    override fun execute(id: String) {
        deleteCustomerByIdOutputPort.execute(findCustomerByIdInputPort.execute(id).id!!)
    }

}