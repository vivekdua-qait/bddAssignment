package com.test.vivek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class spec_reader {
	static String str;
	static String[] words;
	static WebElement element;

	public static WebElement locate(WebDriver driver, String str, String replacement)  {

		try {
			File file = new File("src/test/resources/pages.gspec");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;

			outer:
			while ((line = br.readLine()) != null) {

				if (line.contains(str)) {

					words = line.split("~");
					if (!replacement.isEmpty())
						words[2] = words[2].replaceAll("\\$\\{.+?\\}", replacement);
					String str1 = "id";
					String str2 = "xpath";
					String str3 = "css";

					if (words[1].trim().equals(str1)) {

						element = driver.findElement(By.id(words[2].trim()));

						break outer;
					}
					if (words[1].trim().equals(str2)) {

						element = driver.findElement(By.xpath(words[2].trim()));

						break outer;

					}
					if (words[1].trim().equals(str3)) {
						element = driver.findElement(By.cssSelector(words[2].trim()));

						break outer;
					}
				}
			}
		}
	 catch (IOException ioe) {
		ioe.printStackTrace();
	}
		return element;

	}
	public static WebElement locate(WebDriver driver, String str, String replacement, String replacement2)  {

		try {
			File file = new File("src/test/resources/pages.gspec");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;

			outer:
			while ((line = br.readLine()) != null) {

				if (line.contains(str)) {

					words = line.split("~");
					if (!replacement.isEmpty())
						words[2] = words[2].replaceFirst("\\$\\{.+?\\}", replacement);
					if(!replacement2.isEmpty())
						words[2] = words[2].replaceAll("\\$\\{.?\\}}", replacement2);
					String str1 = "id";
					String str2 = "xpath";
					String str3 = "css";

					if (words[1].trim().equals(str1)) {

						element = driver.findElement(By.id(words[2].trim()));

						break outer;
					}
					if (words[1].trim().equals(str2)) {

						element = driver.findElement(By.xpath(words[2].trim()));

						break outer;

					}
					if (words[1].trim().equals(str3)) {
						element = driver.findElement(By.cssSelector(words[2].trim()));

						break outer;
					}
				}
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return element;

	}
	public static List<WebElement> locate1(WebDriver driver, String str, String replacement)  {
	List<WebElement> elements = null;
		try {
			File file = new File("src/test/resources/pages.gspec");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;

			outer:
			while ((line = br.readLine()) != null) {

				if (line.contains(str)) {

					words = line.split("~");
					if (!replacement.isEmpty())
						words[2] = words[2].replaceAll("\\$\\{.+?\\}", replacement);
					String str1 = "id";
					String str2 = "xpath";
					String str3 = "css";

					if (words[1].trim().equals(str1)) {

						elements = driver.findElements(By.id(words[2].trim()));

						break outer;
					}
					if (words[1].trim().equals(str2)) {

						elements = driver.findElements(By.xpath(words[2].trim()));

						break outer;

					}
					if (words[1].trim().equals(str3)) {
						elements = driver.findElements(By.cssSelector(words[2].trim()));

						break outer;
					}
				}
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return elements;

	}
}
