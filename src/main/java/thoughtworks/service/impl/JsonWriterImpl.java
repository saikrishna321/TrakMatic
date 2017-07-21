package thoughtworks.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import thoughtworks.service.JsonWriter;

@Component
public class JsonWriterImpl implements JsonWriter {
	FileWriter fw;
	BufferedWriter bw;
	
	@Override
	public void writeJson(String json, String fName) {
		System.out.println("start");
		File file = new File(fName); 
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Done");
	}

}
