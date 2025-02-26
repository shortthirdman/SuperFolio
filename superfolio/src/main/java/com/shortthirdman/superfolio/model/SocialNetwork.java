package com.shortthirdman.superfolio.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SocialNetwork {

    private String network;
    private String username;
    private String url;
}
