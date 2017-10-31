package org.duoduochild.magic.duoduo.web.data.mongodb.repository;

import org.duoduochild.magic.duoduo.web.data.mongodb.model.MongoUser;
import org.duoduochild.magic.duoduo.web.data.mongodb.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by levinliu on 2017/10/21
 * GitHub: https://github.com/levinliu
 * (Change file header on Settings -> Editor -> File and Code Templates)
 */

public interface UserRepository extends JpaRepository<User, Serializable> {
    Page<User> findByUserIdAndUserName(long id, String userName);

    User findByUserId(long id);
}
