package com.shortthirdman.superfolio.service;

import com.shortthirdman.superfolio.model.User;

import java.util.Map;

public interface IUserService {

    Boolean saveUserDetailFragment(String fragment, Map<String, ?> details);

    Boolean updateUserDetailFragment(String fragment, Map<String, ?> details);

    Boolean deleteUserDetailFragment(String fragment, Map<String, ?> details);

    User getUserDetails(String fragment);
}
