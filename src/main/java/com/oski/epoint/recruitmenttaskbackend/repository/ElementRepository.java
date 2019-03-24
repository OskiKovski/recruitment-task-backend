package com.oski.epoint.recruitmenttaskbackend.repository;

import com.oski.epoint.recruitmenttaskbackend.model.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ElementRepository extends JpaRepository<Element, Integer> {
}
