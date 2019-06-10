package com.ducont.junit.JunitExamples;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

public class TestMain {

	public static void main(String[] args) throws URLException {
		// List<String> urls = Arrays.asList("http://www.fancysite.com",
		// "http://www.fancysite.com/xyz/xyz.html",
		// "http://www.fancysite.com/abc/xyz/pqr.html");

		List<String> urls = Arrays.asList("");
		// TestMain t = new TestMain();
		TestMain.countLevelOfUrls(urls);
	}

	public static int[] countLevelOfUrls(List<String> urls) throws URLException {

		if(urls == null) {
			throw new URLException("Null Value passed");
		}
		if (urls.isEmpty()) {
			throw new URLException("No Url passed");
		} else {
			int urlLength[] = new int[urls.size()];
			int index = 0;
			for (String url : urls) {
				try {
					new URL(url).toURI();
						
					URI uri = new URI(url);
					String path = uri.getPath();
					int length = (path.split("/")).length;
					urlLength[index++] = length;
					System.out.println(uri + " is at level " + (length - 1));
					System.out.println(urlLength.length);
				} catch (MalformedURLException e) {
					throw new URLException("Invalid URL");
				}catch (URISyntaxException e) {
					throw new URLException("Run time Error");
					// e.printStackTrace();
				}
			}
			return urlLength;
		}

	}

	
}

class URLException extends Exception {

	public URLException(String errDesc) {

		super(errDesc);
	}

}