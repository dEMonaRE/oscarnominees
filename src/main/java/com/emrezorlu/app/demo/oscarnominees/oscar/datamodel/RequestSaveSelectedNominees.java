package com.emrezorlu.app.demo.oscarnominees.oscar.datamodel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestSaveSelectedNominees {
    @NotBlank(message = "Source currency should not be null")
    private String username;
    //degisebilir categoryname-selected nomineeID
    private Map<String, String> selectedNominees;

}
