package com.example.provaspring.Controllers;

import com.example.provaspring.Models.PadariaModel;
import com.example.provaspring.Services.PadariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/padarias")
public class PadariaController {

    @Autowired
    private PadariaService padariaService;

    @GetMapping
    public ResponseEntity<List<PadariaModel>> findAll(){
        List<PadariaModel> response = padariaService.findAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<PadariaModel> criarPadaria(@RequestBody PadariaModel padariaModel){
        PadariaModel response = padariaService.criarPadaria(padariaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPadaria(@PathVariable Long id){
        padariaService.deletarPadaria(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PadariaModel> atualizarPadaria(@PathVariable Long id, @RequestBody PadariaModel padariaModel){
        PadariaModel response = padariaService.atualizarPadaria(id, padariaModel);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PadariaModel> buscarPorId(@PathVariable Long id){
        PadariaModel response = padariaService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/nome/{nome}")
    public PadariaModel buscarPorNome(@PathVariable String nome){
        return padariaService.buscarPorNome(nome);
    }
}
