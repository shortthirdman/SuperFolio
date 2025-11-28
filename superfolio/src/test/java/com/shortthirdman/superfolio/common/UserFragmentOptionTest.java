package com.shortthirdman.superfolio.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFragmentOptionTest {

    @Test
    void fromPrefix() {
        // Test with a valid prefix
        assertEquals("base", UserFragmentOption.fromPrefix("user:*"));
        assertEquals("basics", UserFragmentOption.fromPrefix("user:basics"));
        assertNull(UserFragmentOption.fromPrefix("user:nonexistent"), "Should return null for an invalid prefix");
    }

    @Test
    void fromFragment() {
        // Test with a valid fragment
        assertEquals("user:*", UserFragmentOption.fromFragment("base"));
        assertEquals("user:basics", UserFragmentOption.fromFragment("basics"));
        assertNull(UserFragmentOption.fromFragment("nonexistent"), "Should return null for an invalid fragment");
    }

    @Test
    void isValid() {
    }

    @Test
    void getFragment() {
    }

    @Test
    void getPrefix() {
    }
}