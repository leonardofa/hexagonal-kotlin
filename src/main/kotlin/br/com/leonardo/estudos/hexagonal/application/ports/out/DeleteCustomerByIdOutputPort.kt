package br.com.leonardo.estudos.hexagonal.application.ports.out

interface DeleteCustomerByIdOutputPort {

    fun execute(id: String)

}