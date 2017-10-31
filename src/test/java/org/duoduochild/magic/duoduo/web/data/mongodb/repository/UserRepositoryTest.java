package org.duoduochild.magic.duoduo.web.data.mongodb.repository;

import org.duoduochild.magic.duoduo.web.Application;
import org.duoduochild.magic.duoduo.web.data.mongodb.model.MongoUser;
import org.duoduochild.magic.duoduo.web.data.mongodb.model.User;
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
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by levinliu on 2017/10/22
 * GitHub: https://github.com/levinliu
 * (Change file header on Settings -> Editor -> File and Code Templates)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("base")
public class UserRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;
    private long id;

    @Before
    public void setup() {
        this.id = System.currentTimeMillis();
    }

    @Test
    public void add() {
        logger.debug("test add");
        User mongoUser = new User();
        mongoUser.setUserId(this.id);
        mongoUser.setUserName("levin");
        mongoUser.setId(UUID.randomUUID().toString());
        userRepository.save(mongoUser);
    }

    @Test
    public void findOne() {
        logger.debug("test findOne");
        User targetUser = userRepository.findByUserId(this.id);
        System.out.println("targetUser=" + targetUser);
    }

    @Test
    public void delete() {
        logger.debug("test delete");
        User targetUser = userRepository.findByUserId(this.id);
        userRepository.delete(targetUser);
    }
}