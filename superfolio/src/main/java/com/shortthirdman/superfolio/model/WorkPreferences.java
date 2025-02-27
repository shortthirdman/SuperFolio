package com.shortthirdman.superfolio.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkPreferences {

    private Boolean remote;
    private Boolean hybrid;
    private Boolean freelancing;
    private Boolean relocation;
    private Boolean contractToHire;
}
