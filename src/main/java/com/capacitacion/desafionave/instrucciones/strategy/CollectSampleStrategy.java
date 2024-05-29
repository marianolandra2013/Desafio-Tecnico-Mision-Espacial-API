package com.capacitacion.desafionave.instrucciones.strategy;

public class CollectSampleStrategy implements InstructionStrategy {
    @Override
    public String ejecutar() {
        return "La nave ha comenzado a recolectar muestras del suelo. Las muestras serán enviadas de vuelta a la Tierra en breve.";

    }
}
