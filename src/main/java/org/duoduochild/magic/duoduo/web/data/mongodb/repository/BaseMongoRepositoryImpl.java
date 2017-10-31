package org.duoduochild.magic.duoduo.web.data.mongodb.repository;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.io.Serializable;

/**
 * Created by levinliu on 2017/10/18
 * GitHub: https://github.com/levinliu
 * (Change file header on Settings -> Editor -> File and Code Templates)
 */
public class BaseMongoRepositoryImpl<T, ID extends Serializable> extends SimpleMongoRepository<T, ID> implements BaseMongoRepository<T, ID> {

    private final MongoOperations mongoTempate;
    private final MongoEntityInformation<T, ID> entityInformation;

    public BaseMongoRepositoryImpl(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
        this.mongoTempate = mongoOperations;
        this.entityInformation = metadata;
    }

    protected Class<T> getEntityClass(){return entityInformation.getJavaType();}

}
