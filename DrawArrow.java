//Draws the arrow for which the country is to the direction of

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class DrawArrow extends JFrame{

	public void paintComponent(Graphics g, double degree, double scaling) {
		BufferedImage Arrow = LoadImage("src/Arrow.png"); //Idk import an image lol

		AffineTransform at = AffineTransform.getTranslateInstance(200, 200); // change the position if needed
		at.rotate(Math.toRadians(degree), Arrow.getWidth() / 2, Arrow.getHeight() / 2);
		at.scale(scaling, scaling);

		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(Arrow, at, null);
		repaint();
	}

	BufferedImage LoadImage(String FileName) {
		BufferedImage img = null;

		try {
			img = ImageIO.read(new File(FileName));
		} catch (IOException e) {

		}

		return img;
	}
}