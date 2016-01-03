package com.pt.service;

import com.pt.persistence.entity.Set;
import com.pt.persistence.entity.User;

import java.util.List;

/**
 *  Service to encapsulate business logic for anything related to fetching data for a specific User or set of Users.
 *  See: {@link User}
 */
public interface UserService {

    /**
     * Retrieve all workout sets from the database for a particular user
     *
     * @param user - {@link User} for whom we want to fetch workout sets
     * @return a List of workout sets belonging to the provided user
     */
    List<Set> fetchSetsForUser(User user);

}
