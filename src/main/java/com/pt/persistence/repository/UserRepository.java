package com.pt.persistence.repository;

import com.pt.persistence.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *  Repository for {@link User}
 */
@SuppressWarnings("JpaQlInspection")
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select u from User u where u.displayName = :userName or u.email = :userName")
    User findByUserNameOrEmail(@Param("userName") String userName);
}
