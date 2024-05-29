package com.capacitacion.desafionave.services;

import com.capacitacion.desafionave.models.Telemetry;

import java.util.Optional;

public interface TelemetryService {

    void crearTelemetria(Telemetry telemtry);

    Optional<Telemetry> buscarTelemtriaById(int id);
}
