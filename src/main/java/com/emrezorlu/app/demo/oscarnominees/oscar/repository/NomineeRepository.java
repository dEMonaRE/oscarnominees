package com.emrezorlu.app.demo.oscarnominees.oscar.repository;

import com.emrezorlu.app.demo.oscarnominees.oscar.entity.NomineeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomineeRepository extends MongoRepository<NomineeEntity, String> {
}
