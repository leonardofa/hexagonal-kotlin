package br.com.leonardo.estudos.hexagonal.application.ports.out

interface SendCpfForValidationOutputPort {

    fun execute(cpf: String);

}