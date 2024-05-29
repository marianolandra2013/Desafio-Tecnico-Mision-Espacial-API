package com.capacitacion.desafionave;

import com.capacitacion.desafionave.API.ApiRest;
import com.capacitacion.desafionave.DTO.InstructionDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ApiRestTest {

    @InjectMocks
    private ApiRest apiRest;
    @Test
    public void testInstructionsScanSuccess() {
        InstructionDTO instructionDTO = new InstructionDTO();
        instructionDTO.setInstruccion("Scan");
        ResponseEntity<Map<String, String>> response = apiRest.instructions(instructionDTO, "Authorization");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody().get("status"));
        assertEquals("200", response.getBody().get("code"));
        assertEquals("La nave ha iniciado el escaneo del terreno. Los datos serán enviados a la Tierra pronto.",
                response.getBody().get("message"));

    }



    @Test
    public void testInstructionsDeployRoverSuccess() {
        InstructionDTO instructionDTO = new InstructionDTO();
        instructionDTO.setInstruccion("deploy rover");
        ResponseEntity<Map<String, String>> response = apiRest.instructions(instructionDTO, "Authorization");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody().get("status"));
        assertEquals("200", response.getBody().get("code"));
        assertEquals("La nave ha desplegado con éxito un rover en la superficie del planeta.",
                response.getBody().get("message"));


    }

    @Test
    public void testInstructionsCollectSampleSuccess() {
        InstructionDTO instructionDTO = new InstructionDTO();
        instructionDTO.setInstruccion("collect sample");
        ResponseEntity<Map<String, String>> response = apiRest.instructions(instructionDTO, "Authorization");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody().get("status"));
        assertEquals("200", response.getBody().get("code"));
        assertEquals("La nave ha comenzado a recolectar muestras del suelo. Las muestras serán enviadas de vuelta a la Tierra en breve.",
                response.getBody().get("message"));


    }

    @Test
    public void testInstructionsBadRequest() {
        InstructionDTO instructionDTO = null;
        ResponseEntity<Map<String, String>> response = apiRest.instructions(instructionDTO, "Authorization");
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testInstructionsBadRequestInstruccionNoReconocida() {
        InstructionDTO instructionDTO = new InstructionDTO();
        instructionDTO.setInstruccion("Recharge Energy");
        ResponseEntity<Map<String, String>> response = apiRest.instructions(instructionDTO, "Authorization");
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Instrucción no reconocida: " + "Recharge Energy", response.getBody().get("message"));
    }

}