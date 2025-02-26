package com.shortthirdman.superfolio.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Basics {

    private String firstName;
    private String lastName;
    private String fullName;
    private String gender;
    private String birthDate;
    private String birthPlace;
    private String nationality;
}
