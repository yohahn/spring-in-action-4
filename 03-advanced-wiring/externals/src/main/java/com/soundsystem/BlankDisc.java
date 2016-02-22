package com.soundsystem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yohahn on 2/21/16.
 */
@Component
public class BlankDisc {

    @Value("${disc.title}")
    private String title;

    @Value("${disc.artist:}")
    private String artist;

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
