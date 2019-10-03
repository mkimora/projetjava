package com.kimoramoussa.kimora.repository;


import com.kimoramoussa.kimora.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Long> {
    Optional<Partenaire> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}