package com.glaucus.IncrementNumber.repository;

import com.glaucus.IncrementNumber.model.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Used to perform CRUD operations on Number entity.
 *
 * @author Vipul Kumar Singh
 * @version 1.0
 * @since 2020-11-09
 */
@Repository
public interface NumberRepository extends JpaRepository<Number, Integer> {

}
