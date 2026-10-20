package com.example.provaspring.Repositories;

import com.example.provaspring.Models.PadariaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PadariaRepository extends JpaRepository<PadariaModel, Long> {

    Optional<PadariaModel> findByNome(String nome);


}
