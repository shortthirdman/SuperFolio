package com.shortthirdman.superfolio.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_EMPTY)
public class User {

    private Basics basicDetails;
    private Map<String, String> contactDetails;
    private Map<String, String> educationDetails;
    private Set<SocialNetwork> socialNetworks;
    private Set<String> skills;
}
