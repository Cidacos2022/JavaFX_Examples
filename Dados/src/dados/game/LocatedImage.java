/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.game;

import javafx.scene.image.Image;

/**
 *
 * @author rafael
 */
public class LocatedImage extends Image {

    private final String url;

    public LocatedImage(String url) {
        super(url);
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
