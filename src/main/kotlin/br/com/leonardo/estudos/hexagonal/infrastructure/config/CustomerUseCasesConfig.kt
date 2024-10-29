package br.com.leonardo.estudos.hexagonal.infrastructure.config

import br.com.leonardo.estudos.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase
import br.com.leonardo.estudos.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import br.com.leonardo.estudos.hexagonal.application.core.usecase.InsertCustomerUseCase
import br.com.leonardo.estudos.hexagonal.application.core.usecase.UpdateCustomerUseCase
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomerUseCasesConfig {

    @Bean
    fun insertCustomerConfig(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        saveCustomerAdapter: SaveCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter,
    ) = InsertCustomerUseCase(findAddressByZipCodeAdapter, saveCustomerAdapter, sendCpfForValidationAdapter)

    @Bean
    fun findCustomerByIdConfig(
        findCustomerByIdAdapter: FindCustomerByIdAdapter
    ) = FindCustomerByIdUseCase(findCustomerByIdAdapter)

    @Bean
    fun updateCustomerConfig(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        saveCustomerAdapter: SaveCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter,
    ) = UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, saveCustomerAdapter, sendCpfForValidationAdapter)

    @Bean
    fun deleteCustomerByIdConfig(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        deleteCustomerByIdAdapter: DeleteCustomerByIdAdapter
    ) = DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter)

}