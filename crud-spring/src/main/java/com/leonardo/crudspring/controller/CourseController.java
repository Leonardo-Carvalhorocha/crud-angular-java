package com.leonardo.crudspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping
  public List<Courses> list() {
    return RepositoryCourse.findAll();
  }

}
