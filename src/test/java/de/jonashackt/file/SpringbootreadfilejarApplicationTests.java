package de.jonashackt.file;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootreadfilejarApplication.class)
public class SpringbootreadfilejarApplicationTests {

	@Autowired
	private FileReader fileReader;
	
	@Test
	public void loadFile() {
		fileReader.readFiles();
		assertTrue("File reading successfull", true);
	}
	
	@Test
	public void loadFileWithSpring() {
		fileReader.readFilesWithSpringResource();
		assertTrue("File reading successfull", true);
	}
}
