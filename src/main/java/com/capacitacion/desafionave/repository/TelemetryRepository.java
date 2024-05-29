package com.capacitacion.desafionave.repository;

import com.capacitacion.desafionave.models.Telemetry;
import org.springframework.data.repository.CrudRepository;

public interface TelemetryRepository extends CrudRepository<Telemetry,Integer> {
}
