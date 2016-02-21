package com.habuma.restfun;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yohahn on 2/21/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MagicConfig.class)
public class MagicExistsTest {

    @Autowired
    private ApplicationContext context;

    @BeforeClass
    public static void setup() {
        System.setProperty("magic", "pow!");
    }

    @Test
    public void shouldNotBeNull() {
        Assert.assertTrue(context.containsBean("magicBean"));
    }
}
