package br.com.leonardo.estudos.hexagonal.application.ports.out

import br.com.leonardo.estudos.hexagonal.application.core.domain.Address
import br.com.leonardo.estudos.hexagonal.application.core.exceptions.ObjectNotFoundException

interface FindAddressByZipCodeOutputPort {

    @Throws(ObjectNotFoundException::class)
    fun execute(zipCode: String): Address

}