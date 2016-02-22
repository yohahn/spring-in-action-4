package bakery;

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
@ContextConfiguration(classes = BakeryConfig.class)
public class BakeryConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void primaryDessertIsCake() {
        DessertCourse dessertCourse = context.getBean(DessertCourse.class);
        Assert.assertTrue(dessertCourse.getPrimaryDessert() instanceof Cake);
    }
    @Test
    public void coldDesertIsIceCream() {
        DessertCourse dessertCourse = context.getBean(DessertCourse.class);
        Assert.assertTrue(dessertCourse.getColdDessert() instanceof IceCream);
    }

    @Test
    public void surpriseDessertIsPopsicle() {
        DessertCourse dessertCourse = context.getBean(DessertCourse.class);
        Assert.assertTrue(dessertCourse.getSurpriseDessert() instanceof Popsicle);
    }
}
