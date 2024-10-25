package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out

import br.com.leonardo.estudos.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import br.com.leonardo.estudos.hexagonal.infrastructure.repository.CustomerRepository
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(private val customerRepository: CustomerRepository) : FindCustomerByIdOutputPort {

    override fun execute(id: String) = customerRepository.findById(id).getOrNull()?.toCustomer()

}