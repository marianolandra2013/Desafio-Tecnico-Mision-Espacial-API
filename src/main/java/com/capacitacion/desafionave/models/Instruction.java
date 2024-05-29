package com.capacitacion.desafionave.models;

import com.capacitacion.desafionave.instrucciones.strategy.InstructionStrategy;

public class Instruction {


    private InstructionStrategy estrategia;

    public Instruction(InstructionStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public String ejecutarEstrategia() {
        return estrategia.ejecutar();
    }
}
