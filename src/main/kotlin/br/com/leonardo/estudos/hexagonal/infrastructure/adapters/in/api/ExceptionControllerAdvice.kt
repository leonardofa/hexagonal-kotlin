package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.api

import br.com.leonardo.estudos.hexagonal.application.core.exceptions.ObjectNotFoundException
import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.`in`.api.response.ErrorMessageModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler
    fun handleIllegalStateException(ex: ObjectNotFoundException): ResponseEntity<ErrorMessageModel> {
        val errorMessage = ErrorMessageModel(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

}