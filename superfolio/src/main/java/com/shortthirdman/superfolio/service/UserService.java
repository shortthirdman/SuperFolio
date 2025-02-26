package com.shortthirdman.superfolio.service;

import com.shortthirdman.superfolio.common.UserFragmentOption;
import com.shortthirdman.superfolio.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final RedisTemplate<String, Object> redisTemplate;

    private static final String USER_PREFIX = "user:";

    @Override
    public Boolean saveUserDetailFragment(String fragment, Map<String, ?> details) {
        if (fragment == null || fragment.isBlank() || !UserFragmentOption.isValid(fragment)) {
            throw new IllegalArgumentException("Invalid fragment name");
        }
        return true;
    }

    @Override
    public Boolean updateUserDetailFragment(String fragment, Map<String, ?> details) {
        if (fragment == null || fragment.isBlank() || !UserFragmentOption.isValid(fragment)) {
            throw new IllegalArgumentException("Invalid fragment name");
        }
        return true;
    }

    @Override
    public Boolean deleteUserDetailFragment(String fragment, Map<String, ?> details) {
        if (fragment == null || fragment.isBlank() || !UserFragmentOption.isValid(fragment)) {
            throw new IllegalArgumentException("Invalid fragment name");
        }
        return null;
    }

    @Override
    public User getUserDetails(String fragment) {
        if (fragment == null || fragment.isBlank()) {
            return User.builder().build();
        }
        return User.builder().build();
    }
}
