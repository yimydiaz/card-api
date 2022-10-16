package com.credibanco.assessment.card.repository;

import org.springframework.data.repository.CrudRepository;

import com.credibanco.assessment.card.model.entity.Transaccion;

public interface ITransaccionRepository extends CrudRepository<Transaccion, Long> {

	Transaccion findByNumeroReferencia(Integer numRef);

}
