package com.emrezorlu.app.demo.oscarnominees.oscar.datamodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String id;
    private String username;
    private String password;
    private Date guessDate;
    private Integer totalPoints;
    //categoryName-NomineeId
    private Map<String, String> selectedNominees;

}
