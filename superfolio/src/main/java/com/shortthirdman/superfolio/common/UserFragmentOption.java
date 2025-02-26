package com.shortthirdman.superfolio.common;

import lombok.Getter;

@Getter
public enum UserFragmentOption {

    BASE("base", "user:*"),
    BASICS("basics", "user:basics"),
    CONTACTS_PHONE("phone", "user:contact:phone_numbers"),
    CONTACTS_EMAIL("email", "user:contact:email_address"),
    WORK_EXPERIENCES("work-experiences", "user:employment_history"),
    WORK_PREFERENCES("work-preferences", "user:employment_preferences");

    private final String fragment;
    private final String prefix;

    UserFragmentOption(String fragment, String prefix) {
        this.fragment = fragment;
        this.prefix = prefix;
    }

    public static String fromPrefix(String prefix) {
        for (UserFragmentOption option : UserFragmentOption.values()) {
            if (option.getPrefix().equals(prefix)) {
                return option.getFragment();
            }
        }

        return null;
    }

    public static String fromFragment(String fragment) {
        for (UserFragmentOption option : UserFragmentOption.values()) {
            if (option.getFragment().equals(fragment)) {
                return option.getPrefix();
            }
        }

        return null;
    }

    public static boolean isValid(String fragment) {
        return fromFragment(fragment) != null;
    }
}
