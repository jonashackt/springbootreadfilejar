package de.jonashackt.file;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileReader {

	@RequestMapping(path="/files")
	public String readFiles() {
		 
        try (InputStream inputStream = FileUtils.readFileInClasspath2InputStream("files/", "homepage-feature-projects.png")) {
			// Do somethin with your stream, but at this point, everything should be fine :)
		} catch (BusinessException | IOException exception) {
			exception.printStackTrace();
		}
        return "File reading successfull";
	}
}
