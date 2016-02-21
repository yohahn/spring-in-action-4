package soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by yohahn on 2/21/16.
 */
@Configuration
@Import(CDPlayerConfig.class)
public class SoundSystemConfig {
}
