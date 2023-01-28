package com.emrezorlu.app.demo.oscarnominees.oscar.datamodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseWebComponents {

    private List<Nominee> nomineeList;
}
