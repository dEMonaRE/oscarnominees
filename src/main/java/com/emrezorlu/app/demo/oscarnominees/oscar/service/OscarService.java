package com.emrezorlu.app.demo.oscarnominees.oscar.service;

import com.emrezorlu.app.demo.oscarnominees.oscar.datamodel.RequestSaveSelectedNominees;
import com.emrezorlu.app.demo.oscarnominees.oscar.datamodel.ResponseWebComponents;

import java.io.IOException;

public interface OscarService {
    void saveNominees(int year) throws IOException;

    ResponseWebComponents getWebComponents();

    String saveSelectedNominees(RequestSaveSelectedNominees request);

}
