package com.emrezorlu.app.demo.oscarnominees.oscar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("User")
public class UserEntity {
    @Id
    private String id;
    private String username;
    private String password;
    private Date guessDate;
    private Integer year;
    private Integer totalPoints;
    //categoryName-NomineeId
    private Map<String, String> selectedNominees;

}
