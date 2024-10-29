package br.com.leonardo.estudos.hexagonal.application.ports.`in`

interface DeleteCustomerByIdInputPort {

    fun execute(id: String)

}