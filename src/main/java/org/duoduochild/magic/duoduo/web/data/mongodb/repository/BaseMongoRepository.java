package org.duoduochild.magic.duoduo.web.data.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by levinliu on 2017/10/18
 * GitHub: https://github.com/levinliu
 * (Change file header on Settings -> Editor -> File and Code Templates)
 */
@NoRepositoryBean
public interface BaseMongoRepository <T,ID extends Serializable> extends MongoRepository<T,ID>{
}
