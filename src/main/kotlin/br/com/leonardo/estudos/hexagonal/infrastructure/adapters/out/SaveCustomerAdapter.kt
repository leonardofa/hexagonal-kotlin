package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out

import br.com.leonardo.estudos.hexagonal.application.core.domain.Customer
import br.com.leonardo.estudos.hexagonal.application.ports.out.InsertCustomerOutputPort
import br.com.leonardo.estudos.hexagonal.application.ports.out.UpdateCustomerOutputPort
import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out.repository.CustomerRepository
import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out.repository.entity.CustomerEntity
import org.springframework.stereotype.Component

@Component
class SaveCustomerAdapter(private val customerRepository: CustomerRepository) : InsertCustomerOutputPort, UpdateCustomerOutputPort {

    override fun execute(customer: Customer): Customer {
        return customerRepository.save(CustomerEntity(customer)).toCustomer()
    }

}