package br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out.repository

import br.com.leonardo.estudos.hexagonal.infrastructure.adapters.out.repository.entity.CustomerEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: MongoRepository<CustomerEntity, String>