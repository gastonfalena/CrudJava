package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {

}
