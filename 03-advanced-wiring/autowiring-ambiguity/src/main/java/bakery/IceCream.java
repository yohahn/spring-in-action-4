package bakery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by yohahn on 2/21/16.
 */
@Component
@Qualifier("cold")
public class IceCream implements Dessert {
}
