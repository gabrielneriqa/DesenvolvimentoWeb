package com.example.demo.Controller;

import com.example.demo.Service.AlunoService;
import com.example.demo.entity.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    private List<Aluno> buscarAlunos() {
        return alunoService.findAllAlunos();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long Id) {
        return alunoService.findAlunoById(Id).map(aluno -> new ResponseEntity<>(aluno, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    private Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.createAluno(aluno);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirAluno(@PathVariable Long Id) {
        alunoService.deleteAluno(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping

}
