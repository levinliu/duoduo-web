package org.duoduochild.magic.duoduo.web.data.mongodb.repository;

import org.duoduochild.magic.duoduo.web.data.mongodb.model.MongoUser;

import java.io.Serializable;

public interface MongoUserRepository extends BaseMongoRepository<MongoUser, Serializable> {
    MongoUser findByUserIdAndUserName(Long userId, String userName);
}