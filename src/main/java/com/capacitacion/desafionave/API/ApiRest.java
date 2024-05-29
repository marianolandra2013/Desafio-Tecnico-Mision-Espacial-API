package com.capacitacion.desafionave.API;


import com.capacitacion.desafionave.DTO.InstructionDTO;
import com.capacitacion.desafionave.instrucciones.strategy.CollectSampleStrategy;
import com.capacitacion.desafionave.instrucciones.strategy.DeployRoverStrategy;
import com.capacitacion.desafionave.instrucciones.strategy.ScanStrategy;
import com.capacitacion.desafionave.models.Instruction;
import com.capacitacion.desafionave.models.Telemetry;
import com.capacitacion.desafionave.services.TelemetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ApiRest {


    @Autowired
    TelemetryService telemetryService;


    @GetMapping(value = "/telemetry")
    @ResponseBody
    public ResponseEntity<?> telemetry(@RequestHeader(value = "Authorization") String authorizationHeader) {


        Optional<Telemetry> telemetria = telemetryService.buscarTelemtriaById(1);

        Map response = new HashMap();
        response.put("status", "OK");
        response.put("code", "200");
        response.put("data", telemetria);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/instructions")
    @ResponseBody
    public ResponseEntity<Map<String, String>> instructions(@RequestBody InstructionDTO instruction, @RequestHeader(value = "Authorization") String authorizationHeader) {

        try {

            Instruction instructionStrategy;
            switch (instruction.getInstruccion().toLowerCase()) {
                case "scan":
                    instructionStrategy = new Instruction(new ScanStrategy());
                    break;
                case "collect sample":
                    instructionStrategy = new Instruction(new CollectSampleStrategy());
                    break;
                case "deploy rover":
                    instructionStrategy = new Instruction(new DeployRoverStrategy());
                    break;
                default:
                    throw new HttpMessageNotReadableException("Instrucción no reconocida: " + instruction.getInstruccion());
            }

            Map response = new HashMap();
            response.put("status", "OK");
            response.put("code", "200");
            response.put("message", instructionStrategy.ejecutarEstrategia());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (HttpMessageNotReadableException e) {
            return handleUnrecognizedInstruction(e);
        } catch (NullPointerException e) {
            return handleNull(e, "Se requiere el campo 'instruccion'");
        } catch (Exception e) {
            return handleInternalServerError(e);
        }

    }

    @GetMapping(value = "/authenticate")
    @ResponseBody
    public ResponseEntity<Map<String, String>> authenticate(@RequestHeader(value = "Authorization") String authorizationHeader) {

        Map response = new HashMap();
        response.put("status", "OK");
        response.put("code", "200");
        response.put("message", "¡Autenticación exitosa!");
        return new ResponseEntity<>(response, HttpStatus.OK);


    }


   @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleUnrecognizedInstruction(HttpMessageNotReadableException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "BAD_REQUEST");
        response.put("code", "400");
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleNull(NullPointerException ex, String message) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "BAD_REQUEST");
        response.put("code", "400");
        response.put("message", message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, String>> handleInternalServerError(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "INTERNAL_SERVER_ERROR");
        response.put("code", "500");
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}





