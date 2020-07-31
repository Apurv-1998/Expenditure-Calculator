package com.internship.ssm_task.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DateHandler extends StdDeserializer<Date> {
	
	
	private static final long serialVersionUID = -6960689906109612802L;

	public DateHandler() {
		this(null);
	}
	
	public DateHandler(Class<?> superClass) {
		super(superClass);
	}
	
	@Override
	public Date deserialize(JsonParser jsonParser,DeserializationContext context) throws IOException {
		
		String date = jsonParser.getText();
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(date);
		}catch(Exception e) {
			return null;
		}
		
	}

}
