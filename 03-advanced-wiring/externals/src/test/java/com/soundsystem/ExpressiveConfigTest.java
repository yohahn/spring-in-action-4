package com.soundsystem;

import org.junit.Assert;
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
@ContextConfiguration(classes = ExpressiveConfig.class)
public class ExpressiveConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void externalProperties() {
        BlankDisc blankDisc = context.getBean(BlankDisc.class);
        Assert.assertEquals("Sgt. Peppers Lonely Hearts Club Band", blankDisc.getTitle());
        Assert.assertEquals("The Beatles", blankDisc.getArtist());
    }
}
