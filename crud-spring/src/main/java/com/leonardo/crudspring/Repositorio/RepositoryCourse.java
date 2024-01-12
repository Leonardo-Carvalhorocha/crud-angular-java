package com.leonardo.crudspring.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonardo.crudspring.model.Courses;

@Repository
public interface RepositoryCourse extends JpaRepository<Courses, Long> {

}
