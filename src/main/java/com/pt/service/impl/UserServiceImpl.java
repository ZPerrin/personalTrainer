package com.pt.service.impl;

import com.pt.persistence.entity.Set;
import com.pt.persistence.entity.User;
import com.pt.persistence.repository.SetRepository;
import com.pt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@inheritDoc} - Implementing class
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SetRepository setRepository;


    /**
     * This implementation will return NULL if no sets can be found
     *
     * @param user - {@link User} for whom we want to fetch workout sets
     * @return a List of workout sets belonging to the provided user, or null if there are none
     */
    @Override
    @Transactional(readOnly = true)
    public List<Set> fetchSetsForUser(User user) {
        List<Set> setList = setRepository.fetchByUserId(user.getId());
        return setList.isEmpty() ? null : setList;
    }
}
