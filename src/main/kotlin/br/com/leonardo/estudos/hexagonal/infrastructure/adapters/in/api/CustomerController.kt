package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.api

import br.com.leonardo.estudos.hexagonal.application.core.domain.Customer
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.InsertCustomerInputPort
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.api.request.CustomerRequest
import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.api.response.CustomerResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/customers")
class CustomerController(
    private val insertCustomerInputPort: InsertCustomerInputPort,
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val updateCustomerInputPort: UpdateCustomerInputPort,
    private val deleteCustomerByIdInputPort: DeleteCustomerByIdInputPort,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest):CustomerResponse {
        with(customerRequest) {
            return CustomerResponse(insertCustomerInputPort.execute(Customer(name = name, cpf = cpf), zipCode));
        }
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): CustomerResponse {
        return CustomerResponse(findCustomerByIdInputPort.execute(id));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable id: String, @Valid @RequestBody customerRequest: CustomerRequest):CustomerResponse {
        with(customerRequest) {
            return CustomerResponse(updateCustomerInputPort.execute(Customer(id = id, name = name, cpf = cpf), zipCode));
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        deleteCustomerByIdInputPort.execute(id);
    }

}