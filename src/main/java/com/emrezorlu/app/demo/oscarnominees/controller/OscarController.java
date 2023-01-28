package com.emrezorlu.app.demo.oscarnominees.controller;

import com.emrezorlu.app.demo.oscarnominees.common.constants.ApiPath;
import com.emrezorlu.app.demo.oscarnominees.oscar.service.OscarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static java.lang.Integer.parseInt;

@Tag(name = "OSCAR")
@RestController
@RequestMapping(path = ApiPath.OSCAR, produces = "application/json")
@AllArgsConstructor
public class OscarController {

    @Autowired
    OscarService oscarService;

    @Operation(summary = "saveOscar")
    @PutMapping(path = "/saveNominees")
    public ResponseEntity<?> saveNominees(
            @RequestParam(value = "year", required = true) @NotBlank(message = "Year should not be null") @Size(min = 4, max = 4, message = "Year must be 4 digits") String year) throws IOException {
        oscarService.saveNominees(parseInt(year));
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
