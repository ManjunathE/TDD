package com.ducont.junit.JunitExamples;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

public class TestMainTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before");
	}

	@Test
	public void testCountLevelOfUrls() throws URLException {
		List<String> urls1 = Arrays.asList("http://www.fancysite.com", "http://www.fancysite.com/xyz/xyz.html",
				"http://www.fancysite.com/abc/xyz/pqr.html");

		assertEquals(3, TestMain.countLevelOfUrls(urls1).length);
		
	}

	@Test(expected = URLException.class)
	public final void whenEmptyStringIsUsedThenReturnValueIs0() throws URLException {
		List<String> urls2 = Arrays.asList(" ");
		assertEquals(0, TestMain.countLevelOfUrls(urls2));
	}

	@Test
	public final void whenNullThrowsThenRuntimeExceptionIsThrown() {
		try {
			TestMain.countLevelOfUrls(null);
			Assert.fail();
		} catch (URLException e) {
			Assert.assertEquals("Null Value passed", e.getMessage());
		}
	}

	@Test
	public final void checkRunTimeError() {
		List<String> urls1 = Arrays.asList("http://    dasdas www.fancysite.com");
		try {
			TestMain.countLevelOfUrls(urls1);
		} catch (URLException e) {
			Assert.assertEquals("Run time Error", e.getMessage());
		}
	}

	@Test
	public final void checkGarbageValidation() {
		List<String> urls1 = Arrays.asList("-1");
		try {
			TestMain.countLevelOfUrls(urls1);
		} catch (URLException e) {
			Assert.assertEquals("Invalid URL", e.getMessage());
		}
	}
	
	@Test
	public final void verifyEmptyArray() {
		List<String> urls1 = Arrays.asList("-1");
		try {
			TestMain.countLevelOfUrls(new ArrayList<String>());
		} catch (URLException e) {
			Assert.assertEquals("No Url passed", e.getMessage());
		}
	}


}