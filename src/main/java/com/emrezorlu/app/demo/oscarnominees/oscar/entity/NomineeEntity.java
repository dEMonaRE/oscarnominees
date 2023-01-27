package com.emrezorlu.app.demo.oscarnominees.oscar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("Nominee")
public class NomineeEntity {
    @Id
    private String id;
    private Integer year;
    private String name;
    private String categoryName;
    private String points;
}
