package com.emrezorlu.app.demo.oscarnominees.oscar.repository;

import com.emrezorlu.app.demo.oscarnominees.oscar.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

}
