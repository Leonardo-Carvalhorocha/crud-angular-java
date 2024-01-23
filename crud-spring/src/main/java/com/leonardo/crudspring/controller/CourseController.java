package com.leonardo.crudspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;

import com.leonardo.crudspring.Repositorio.RepositoryCourse;
import com.leonardo.crudspring.model.Courses;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

  @Autowired
  private RepositoryCourse RepositoryCourse;

  //Listar todos os cursos
  @GetMapping
  public List<Courses> list() {
    return RepositoryCourse.findAll();
  }

  //Listar o curso por ID
  @GetMapping("/{id}")
  public ResponseEntity<Courses> findById(@PathVariable Long id) {
    return RepositoryCourse.findById(id)
            .map(record -> ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
  }

  //Post de um novo curso.
  @PostMapping
  public ResponseEntity<Courses> create(@RequestBody Courses course) {
    return ResponseEntity.status(HttpStatus.CREATED)
    .body(RepositoryCourse.save(course));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Courses> update(@PathVariable Long id, @RequestBody Courses course) {
    return RepositoryCourse.findById(id)
            .map(recordFound ->{
              recordFound.setName(course.getName());
              recordFound.setCategory(course.getCategory());
              Courses update = RepositoryCourse.save(recordFound);
              return ResponseEntity.ok().body(update);
            })
            .orElse(ResponseEntity.notFound().build());
  }

  //deletar curso, buscando ele pelo ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    return RepositoryCourse.findById(id)
            .map(recordFound ->{
              RepositoryCourse.deleteById(id);
              return ResponseEntity.noContent().<Void>build();
            })
            .orElse(ResponseEntity.notFound().build());
  }
}
