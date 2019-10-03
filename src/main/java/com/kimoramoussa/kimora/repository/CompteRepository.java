package com.kimoramoussa.kimora.repository;


import com.kimoramoussa.kimora.model.Compte;
import com.kimoramoussa.kimora.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    //Optional<Compte> findByNum_compte(int num_compte);
   // Boolean existsByNum_compte(int num_compte);
   // Boolean existsByEmail(String email);
}