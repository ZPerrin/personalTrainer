package com.pt.persistence.repository;

import com.pt.persistence.entity.Set;
import com.pt.persistence.entity.SetPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  Repository for {@link com.pt.persistence.entity.Set}
 */
@Repository
public interface SetRepository extends CrudRepository<Set,SetPK> {

    @Query("select s from Set s where s.user.id = :userId")
    List<Set> fetchByUserId(@Param("userId") Integer userId);

}
