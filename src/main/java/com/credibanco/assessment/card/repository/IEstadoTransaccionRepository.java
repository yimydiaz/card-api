package com.credibanco.assessment.card.repository;

import org.springframework.data.repository.CrudRepository;

import com.credibanco.assessment.card.model.entity.EstadoTransaccion;

public interface IEstadoTransaccionRepository extends CrudRepository<EstadoTransaccion, Long> {

}
