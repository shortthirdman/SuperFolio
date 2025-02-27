package com.shortthirdman.superfolio.service;

import com.shortthirdman.superfolio.common.UserFragmentOption;
import com.shortthirdman.superfolio.exception.InvalidFragmentException;
import com.shortthirdman.superfolio.exception.SuperFolioException;
import com.shortthirdman.superfolio.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
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
    private static final String USER_FRAGMENT_PREFIX = "user:";

    @Override
    public Boolean saveUserDetailFragment(String fragment, Map<String, ?> details) {
        if (fragment == null || fragment.isBlank() || !UserFragmentOption.isValid(fragment)) {
            throw new InvalidFragmentException("Invalid fragment name: " + fragment);
        }

        log.info("Saving user profile fragment {}", fragment);
        StringBuilder key = new StringBuilder();
        try {
            key.append(UserFragmentOption.fromFragment(fragment));
            var status = redisTemplate.opsForValue().setIfAbsent(key.toString(), details);

            log.info("Saving user profile fragment {} status: {}", fragment, status);

            return Boolean.TRUE.equals(status);
        } catch (Exception e) {
            log.error("Error saving user profile fragment: {}", ExceptionUtils.getFullStackTrace(e));
            throw new SuperFolioException("Could not save user profile fragment: " + fragment);
        }
    }

    @Override
    public Boolean updateUserDetailFragment(String fragment, Map<String, ?> details) {
        if (fragment == null || fragment.isBlank() || !UserFragmentOption.isValid(fragment)) {
            throw new InvalidFragmentException("Invalid fragment name: " + fragment);
        }

        log.info("Updating user profile fragment {}", fragment);
        StringBuilder key = new StringBuilder();
        try {
            key.append(UserFragmentOption.fromFragment(fragment));
        } catch (Exception e) {
            log.error("Error updating user profile fragment: {}", ExceptionUtils.getFullStackTrace(e));
            throw new SuperFolioException("Could not update user profile fragment: " + fragment);
        }
        return true;
    }

    @Override
    public Boolean deleteUserDetailFragment(String fragment) {
        if (!UserFragmentOption.isValid(fragment)) {
            throw new InvalidFragmentException("Invalid fragment name: " + fragment);
        }

        log.info("Removing user profile fragment {}", fragment);
        StringBuilder key = new StringBuilder();

        try {
            if (fragment != null && !fragment.isBlank()) {
                key.append(UserFragmentOption.fromFragment(fragment));
            } else {
                key.append(UserFragmentOption.BASE.getPrefix());
            }
            var status = redisTemplate.opsForValue().getAndDelete(key.toString());
        } catch (Exception e) {
            log.error("Error deleting user profile fragment: {}", ExceptionUtils.getFullStackTrace(e));
            throw new SuperFolioException("Could not deleting user profile fragment: " + fragment);
        }

        return null;
    }

    @Override
    public User getUserDetails(String fragment) {
        if (!UserFragmentOption.isValid(fragment)) {
            throw new InvalidFragmentException("Invalid fragment name: " + fragment);
        }

        if (fragment == null || fragment.isBlank()) {
            return User.builder().build();
        }

        return User.builder().build();
    }
}
