package net.sourceforge.desmaster.entity;

import java.awt.image.BufferedImage;

import net.sourceforge.desmaster.Skyrim.Skyrim;
import net.sourceforge.desmaster.image.ImageContainer;

public class Entity {
	
	protected ImageContainer imgContainer = Skyrim.imgContainer;
	public int x, y;
	public BufferedImage entitySprite;
	
	public Entity() {
		entitySprite = null;
	}
	
}
