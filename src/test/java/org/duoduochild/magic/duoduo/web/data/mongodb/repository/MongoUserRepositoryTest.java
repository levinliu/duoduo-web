package org.duoduochild.magic.duoduo.web.data.mongodb.repository;

import org.duoduochild.magic.duoduo.web.Application;
import org.duoduochild.magic.duoduo.web.data.mongodb.model.MongoUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ActiveProfilesResolver;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by levinliu on 2017/10/18
 * GitHub: https://github.com/levinliu
 * (Change file header on Settings -> Editor -> File and Code Templates)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("base")
public class MongoUserRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MongoUserRepository mongoUserRepository;

    private long id;

    @Before
    public void setup() {
        this.id = System.currentTimeMillis();
    }

    @Test
    public void add() {
        logger.debug("test add");
        MongoUser mongoUser = new MongoUser();
        mongoUser.setUserId(this.id);
        mongoUser.setUserName("levin");
        mongoUser.setId(UUID.randomUUID().toString());
        mongoUserRepository.save(mongoUser);
    }

    @Test
    public void findOne() {
        logger.debug("test findOne");
        MongoUser mongoUser = new MongoUser();
        mongoUser.setUserName("levin");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.exact());
        Example<MongoUser> ex = Example.of(mongoUser, matcher);
        MongoUser targetUser = mongoUserRepository.findOne(ex);
        System.out.println("targetUser=" + targetUser);
        assertThat(targetUser.getUserName()).isEqualTo(mongoUser.getUserName());
        targetUser = mongoUserRepository.findByUserIdAndUserName(this.id, mongoUser.getUserName());
        System.out.println("targetUser=" + targetUser);
    }

    @Test
    public void delete() {
        logger.debug("test delete");
        MongoUser mongoUser = new MongoUser();
        mongoUser.setUserId(this.id);
        mongoUser.setUserName("levin");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.caseSensitive());
        Example<MongoUser> ex = Example.of(mongoUser, matcher);
        MongoUser targetUser = mongoUserRepository.findOne(ex);
        mongoUserRepository.delete(targetUser);
    }

}
