package com.jawher.pide.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jawher.pide.entities.Competition;

public interface CompetitionsRepesitory extends CrudRepository<Competition, Long> {

}
