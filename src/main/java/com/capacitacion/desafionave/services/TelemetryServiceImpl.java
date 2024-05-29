package com.capacitacion.desafionave.services;

import com.capacitacion.desafionave.models.Telemetry;
import com.capacitacion.desafionave.repository.TelemetryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelemetryServiceImpl implements TelemetryService {
    @Autowired
    TelemetryRepository telemetryRepository;

    @Override
    public void crearTelemetria(Telemetry telemtry) {
        telemetryRepository.save(telemtry);
    }

    @Override
    public Optional<Telemetry> buscarTelemtriaById(int id) {
        return telemetryRepository.findById(id);
    }
}
