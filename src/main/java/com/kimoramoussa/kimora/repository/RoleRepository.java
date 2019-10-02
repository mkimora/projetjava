package com.kimoramoussa.kimora.repository;

import com.kimoramoussa.kimora.model.Role;
import com.kimoramoussa.kimora.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
