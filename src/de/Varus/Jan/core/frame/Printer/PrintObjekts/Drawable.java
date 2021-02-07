package de.Varus.Jan.core.frame.Printer.PrintObjekts;

import java.awt.Graphics2D;
import java.awt.Image;

public interface Drawable {
	int x(); 
	int y(); 
	int width(); 
	int height(); 
	Image getImage();
	void draw(Graphics2D g);
}
