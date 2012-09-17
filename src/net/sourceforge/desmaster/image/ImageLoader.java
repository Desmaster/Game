package net.sourceforge.desmaster.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public BufferedImage image;
	
	public ImageLoader() {
		
	}
	
	public BufferedImage loadImage(String path) {
		URL url = this.getClass().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public BufferedImage grabSprite(int x, int y, int w, int h) {
		BufferedImage img = image.getSubimage(x, y, w, h);
		return img;
	}
	
}
