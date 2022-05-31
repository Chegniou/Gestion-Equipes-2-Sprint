package com.omar.equipe.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.omar.equipe.entities.Role;
@RepositoryRestResource(path = "rest")
public interface RoleRepository  extends JpaRepository<Role, Long> {

}
