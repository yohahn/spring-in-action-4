package bakery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by yohahn on 2/21/16.
 */
@Component
public class DessertCourse {

    private Dessert primaryDessert;
    private Dessert coldDessert;
    private Dessert surpriseDessert;

    public Dessert getPrimaryDessert() {
        return primaryDessert;
    }

    @Autowired
    public void setPrimaryDessert(Dessert dessert) {
        this.primaryDessert = dessert;
    }

    public Dessert getColdDessert() {
        return this.coldDessert;
    }

    @Autowired
    @Qualifier("cold")
    public void setColdDessert(Dessert dessert) {
        this.coldDessert = dessert;
    }

    public Dessert getSurpriseDessert() {
        return this.surpriseDessert;
    }

    @Autowired
    @Cold
    @Fruity
    public void setSurpriseDessert(Dessert dessert) {
        this.surpriseDessert = dessert;
    }
}
