package com.capacitacion.desafionave.instrucciones.strategy;

public class DeployRoverStrategy implements InstructionStrategy {
    @Override
    public String ejecutar() {
        return "La nave ha desplegado con éxito un rover en la superficie del planeta.";
    }
}
