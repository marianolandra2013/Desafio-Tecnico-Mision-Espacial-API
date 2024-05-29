package com.capacitacion.desafionave.DTO;

public class TelemetryDTO {

    private String estado;
    private Double temperatura;
    private Double presion;

    public TelemetryDTO() {
    }

    public TelemetryDTO(String estado, Double temperatura, Double presion) {
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
