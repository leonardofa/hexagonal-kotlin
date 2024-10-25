package br.com.leonardo.estudos.hexagonal.infrastructure.config

import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out.FindAddressByZipCodeAdapter
import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out.FindCustomerByIdAdapter
import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out.SaveCustomerAdapter
import br.com.leonardo.estudos.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import br.com.leonardo.estudos.hexagonal.application.core.usecase.InsertCustomerUseCase
import br.com.leonardo.estudos.hexagonal.application.core.usecase.UpdateCustomerUseCase
import br.com.leonardo.estudos.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomerUseCasesConfig {

    @Bean
    fun insertCustomerConfig(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        saveCustomerAdapter: SaveCustomerAdapter
    ) = InsertCustomerUseCase(findAddressByZipCodeAdapter, saveCustomerAdapter)

    @Bean
    fun updateCustomerConfig(
        findCustomerByIdInputPort: FindCustomerByIdInputPort,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        saveCustomerAdapter: SaveCustomerAdapter
    ) = UpdateCustomerUseCase(findCustomerByIdInputPort, findAddressByZipCodeAdapter, saveCustomerAdapter)

    @Bean
    fun findCustomerByIdConfig(
        findCustomerByIdAdapter: FindCustomerByIdAdapter
    ) = FindCustomerByIdUseCase(findCustomerByIdAdapter)

}