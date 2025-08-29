package com.example.demo.Service;

import com.example.demo.Repository.AlunoRepository;
import com.example.demo.entity.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAllAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findAlunoById(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    public Aluno updateAluno(Long id, Aluno updateAluno) {
        return alunoRepository.findById(id).map(aluno -> {
            aluno.setNome(updateAluno.getNome());
            aluno.setEmail(updateAluno.getEmail());
            aluno.setDataNasc(updateAluno.getDataNasc());
            aluno.setSenha(updateAluno.getSenha());
            return alunoRepository.save(aluno);
        }).orElseThrow(() -> new RuntimeException("Tem esse aluno aí não mah!"));
    }

}
