package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out

import br.com.leonardo.estudos.hexagonal.application.core.domain.Address
import br.com.leonardo.estudos.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out.client.AddressClient
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(private val adressClient: AddressClient) : FindAddressByZipCodeOutputPort {

    override fun execute(zipCode: String): Address = adressClient.findByZipCode(zipCode).toAddress();

}