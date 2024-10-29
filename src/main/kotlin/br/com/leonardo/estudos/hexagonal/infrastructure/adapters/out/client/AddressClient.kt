package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out.client

import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out.client.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "AddressClient",
    url = "\${adapters.out.client.address.url}"
)
interface AddressClient {

    @GetMapping("/{zipCode}")
    fun findByZipCode(@PathVariable zipCode: String): AddressResponse

}