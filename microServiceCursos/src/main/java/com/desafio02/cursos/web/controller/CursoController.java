package com.desafio02.cursos.web.controller;

import com.desafio02.cursos.entities.Curso;
import com.desafio02.cursos.services.CursoService;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cursos")
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> criar(@RequestBody Curso curso) {
        Curso novoCurso = cursoService.salvar(curso);
        return ResponseEntity.status(201).body(novoCurso);
    }

    @PatchMapping("/desabilitar-curso/{id}")
    public ResponseEntity<Curso> inabilitarCurso(@PathVariable Long id) {
        Curso novoCurso = cursoService.desabilitarCurso(id);
        return ResponseEntity.status(HttpStatus.OK).body(novoCurso);
    }

    @PatchMapping("/{nome}")
    public ResponseEntity<Curso> alterarProfessor(@PathVariable String nome ,@RequestBody Curso curso) {
        Curso novoCurso = cursoService.mudarProfessor(nome ,curso);
        return ResponseEntity.status(201).body(novoCurso);
    }
}
