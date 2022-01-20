package org.capgemini.repository;

import org.capgemini.model.DabbaOrdering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DabbaRepository extends JpaRepository<DabbaOrdering,Long>{

}
