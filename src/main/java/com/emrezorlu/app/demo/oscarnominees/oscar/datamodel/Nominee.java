package com.emrezorlu.app.demo.oscarnominees.oscar.datamodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nominee {
    private String id;
    private Integer year;
    private String name;
    private String categoryName;
    private String points;
}
