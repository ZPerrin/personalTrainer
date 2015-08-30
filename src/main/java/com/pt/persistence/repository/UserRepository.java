package com.pt.persistence.repository;

import com.pt.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *  Repository for {@link User}
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
