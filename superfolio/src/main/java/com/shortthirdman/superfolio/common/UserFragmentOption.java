package com.shortthirdman.superfolio.common;

import lombok.Getter;

@Getter
public enum UserFragmentOption {

    BASE("base", "user:*"),
    BASICS("basics", "user:basic_details"),
    CONTACTS_PHONE("phone", "user:phone_numbers"),
    CONTACTS_EMAIL("email", "user:email_address"),
    PERMANENT_LOCATION("permanentLocation", "user:permanent_location"),
    CURRENT_LOCATION("currentLocation", "user:current_location"),
    WORK_EXPERIENCES("workExperiences", "user:employment_history"),
    WORK_PREFERENCES("workPreferences", "user:employment_preferences"),
    SOCIAL_MEDIA_PROFILES("socialNetworks", "user:social_networks"),
    TECH_SKILLS("techSkills", "user:technology_skills"),
    EDUCATION_HISTORY("educationHistory", "user:education_history");

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
