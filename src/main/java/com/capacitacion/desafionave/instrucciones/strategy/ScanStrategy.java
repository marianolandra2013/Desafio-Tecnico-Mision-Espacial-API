package com.capacitacion.desafionave.instrucciones.strategy;

import com.capacitacion.desafionave.instrucciones.strategy.InstructionStrategy;

public class ScanStrategy implements InstructionStrategy {
    @Override
    public String ejecutar() {
        return "La nave ha iniciado el escaneo del terreno. Los datos serán enviados a la Tierra pronto.";
    }
}
