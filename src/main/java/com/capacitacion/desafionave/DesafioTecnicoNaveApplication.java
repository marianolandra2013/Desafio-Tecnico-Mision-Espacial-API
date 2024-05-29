package com.capacitacion.desafionave;

import com.capacitacion.desafionave.models.Telemetry;
import com.capacitacion.desafionave.services.TelemetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

@EnableScheduling
@SpringBootApplication
@EnableAsync
public class DesafioTecnicoNaveApplication {


    @Autowired
    TelemetryService telemetryService;

    @PostConstruct
    private void started() {

        if (telemetryService.buscarTelemtriaById(1).isEmpty()) {
            Telemetry telemetria = new Telemetry("En órbita", 20.5, 0.0);
            telemetryService.crearTelemetria(telemetria);
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(DesafioTecnicoNaveApplication.class, args);
    }


}
