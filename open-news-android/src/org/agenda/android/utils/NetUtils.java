package org.agenda.android.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetUtils {
	
	public static Object fetch(String address) throws MalformedURLException,IOException {
		URL url = new URL(address);
		Object content = url.getContent();
		return content;
	}
	
	
	public static String isToString(InputStream inputStream) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		StringBuilder builder = new StringBuilder();
		while ((line = reader.readLine()) != null)
		{
			builder.append(line).append("\n");
		}
		reader.close();
		return builder.toString();
			
		
	}

}
