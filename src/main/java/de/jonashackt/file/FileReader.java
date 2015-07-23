package de.jonashackt.file;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileReader {

	@Value("classpath:files/homepage-feature-projects.png")
	private Resource file;
	
	@RequestMapping(path="/files")
	public String readFiles() {
		 
        try (InputStream inputStream = FileUtils.readFileInClasspath2InputStream("files/", "homepage-feature-projects.png")) {
			// Do somethin with your stream, but at this point, everything should be fine :)
		} catch (BusinessException | IOException exception) {
			exception.printStackTrace();
		}
        return "File reading successfull";
	}
	
	@RequestMapping(path="/springfiles")
	public String readFilesWithSpringResource() {
		 
		try (InputStream inputStream = file.getInputStream()) {
			// Do somethin with your stream, but at this point, everything should be fine :)
		} catch (IOException exception) {
			exception.printStackTrace();
		}
        return "File reading successfull";
	}
}
