package com.capacitacion.desafionave.models;

import com.capacitacion.desafionave.DTO.TelemetryDTO;


import javax.persistence.*;

@Entity
public class Telemetry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String estado;
    private Double temperatura;
    private Double presion;


    public Telemetry(TelemetryDTO telemetryDTO) {

        this.estado = telemetryDTO.getEstado();
        this.presion=telemetryDTO.getPresion();
        this.temperatura = telemetryDTO.getTemperatura();


    }

    public Telemetry() {

    }

    public Telemetry(String estado, Double temperatura, Double presion) {
        this.estado = estado;
        this.temperatura = temperatura;
        this.presion = presion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getPresion() {
        return presion;
    }

    public void setPresion(Double presion) {
        this.presion = presion;
    }
}
