package com.lolo.utils.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	private JsonGenerator jsonGenerator = null;
	private ObjectMapper objectMapper = null;

	private void init() {
		this.objectMapper = new ObjectMapper();
		try {
			this.jsonGenerator = objectMapper.getJsonFactory()
					.createJsonGenerator(System.out, JsonEncoding.UTF8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void destory() {
        try {
            if (jsonGenerator != null) {
                jsonGenerator.flush();
            }
            if (!jsonGenerator.isClosed()) {
                jsonGenerator.close();
            }
            jsonGenerator = null;
            objectMapper = null;
            System.gc();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	
}
