package test;


import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ImageTest {
	@Test
	void test() {
		try {
			BufferedImage bi = ImageIO.read(new File("E:\\婚纱照\\已选原片\\018A5172.jpg"));
			assertNotNull(bi);
			BufferedImage bi2=ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("image/018A5172.jpg"));
			assertNotNull(bi2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
