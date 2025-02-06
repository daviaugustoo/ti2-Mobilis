package com.mobilis.tis2mobilis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobilis.tis2mobilis.models.Paciente;
import com.mobilis.tis2mobilis.services.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.salvarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPaciente);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        return ResponseEntity.ok(pacientes);
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.buscarPacientePorId(id);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }*/

    @GetMapping("/id/{id}") //CRIADA
    public ResponseEntity<Optional<Paciente>> getPatientById(@RequestBody @PathVariable Long id) {
        Optional<Paciente> patient = pacienteService.getPatientById(id);
        if (patient.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(patient);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, @RequestBody Paciente pacienteAtualizado) {
        Optional<Paciente> pacienteOptional = pacienteService.getPatientById(id);

        if (!pacienteOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Paciente pacienteExistente = pacienteOptional.get();
        pacienteExistente.setCep(pacienteAtualizado.getCep());
        
        pacienteExistente.setNumeroResidencia(pacienteAtualizado.getNumeroResidencia());
        
        pacienteExistente.setDescricaoDoPaciente(pacienteAtualizado.getDescricaoDoPaciente());
        // pacienteExistente.setUsuario(pacienteAtualizado.getUsuario());

        Paciente pacienteAtualizadoFinal = pacienteService.salvarPaciente(pacienteExistente);
        return ResponseEntity.ok(pacienteAtualizadoFinal);
    }
     @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Paciente> buscarPacientePorCpf(@PathVariable String cpf) {
        Optional<Paciente> paciente = pacienteService.buscarPacientePorCpf(cpf);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        if (!pacienteService.getPatientById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pacienteService.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }
    
}