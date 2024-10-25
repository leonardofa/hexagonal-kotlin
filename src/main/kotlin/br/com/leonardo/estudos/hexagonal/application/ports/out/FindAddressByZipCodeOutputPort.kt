package br.com.leonardo.estudos.hexagonal.application.ports.out

import br.com.leonardo.estudos.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun execute(zipCode: String): Address

}