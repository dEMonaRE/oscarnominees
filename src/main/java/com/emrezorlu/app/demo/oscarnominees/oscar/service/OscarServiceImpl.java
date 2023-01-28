package com.emrezorlu.app.demo.oscarnominees.oscar.service;

import com.emrezorlu.app.demo.oscarnominees.common.constants.ApiPath;
import com.emrezorlu.app.demo.oscarnominees.oscar.datamodel.Nominee;
import com.emrezorlu.app.demo.oscarnominees.oscar.datamodel.RequestSaveSelectedNominees;
import com.emrezorlu.app.demo.oscarnominees.oscar.datamodel.ResponseWebComponents;
import com.emrezorlu.app.demo.oscarnominees.oscar.entity.NomineeEntity;
import com.emrezorlu.app.demo.oscarnominees.oscar.repository.NomineeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OscarServiceImpl implements OscarService {

    @Autowired
    NomineeRepository nomineeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveNominees(int year) throws IOException {
        String url = ApiPath.OSCAR_URL + String.valueOf(year);
        Document doc = Jsoup.connect(url).get();

        Element content = doc.getElementById("quicktabs-tabpage-honorees-0");
        Elements categoryList = content.getElementsByClass("view-grouping-header");
        List<NomineeEntity> nomineeEntityList = new ArrayList<>();
        for (Element category : categoryList) {
            System.out.println("Category: " + category.text() + "\n");
            Elements nextElementSiblings = category.nextElementSiblings();

            for (int i = 0; i < nextElementSiblings.size(); i++) {
                Elements nameList = nextElementSiblings.get(i).getElementsByClass("views-field views-field-field-actor-name");

                Elements titleList = nextElementSiblings.get(i).getElementsByClass("views-field views-field-title");

                for (int j = 0; j < nameList.size(); j++) {
                    System.out.println(j + " : " + nameList.get(j).text() + " - " + titleList.get(j).text());

                    NomineeEntity nomineeEntity = NomineeEntity.builder().categoryName(category.text()).name(nameList.get(j).text() + " - " + titleList.get(j).text()).year(year).build();
                    nomineeEntityList.add(nomineeEntity);
                }


            }

        }
        //TODO EMRE save DB
        System.out.println(nomineeEntityList.size());

    }

    @Override
    public ResponseWebComponents getWebComponents() {
        List<NomineeEntity> nomineeEntityList = nomineeRepository.findAll();

        List<Nominee> nomineeList = new ArrayList<>();
        for (NomineeEntity nomineeEntity : nomineeEntityList) {
            nomineeList.add(modelMapper.map(nomineeEntity, Nominee.class));

        }
        return ResponseWebComponents.builder().nomineeList(nomineeList).build();
    }

    @Override
    public String saveSelectedNominees(RequestSaveSelectedNominees request) {
        return "Saved Successfully";
    }
}
