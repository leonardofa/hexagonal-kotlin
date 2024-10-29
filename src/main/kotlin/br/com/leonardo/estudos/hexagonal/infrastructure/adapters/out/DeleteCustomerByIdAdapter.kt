package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out

import br.com.leonardo.estudos.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import br.com.leonardo.estudos.hexagonal.infrastructure.repository.CustomerRepository
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class DeleteCustomerByIdAdapter(private val customerRepository: CustomerRepository) : DeleteCustomerByIdOutputPort {

    override fun execute(id: String) = customerRepository.deleteById(id)

}