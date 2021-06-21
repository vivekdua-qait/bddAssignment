package com.test.vivek.automation;

import com.test.vivek.utils.config_reader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class reads the PageObjectRepository text files. Uses buffer reader.
 */
public class ObjectFileReader {

	static String filepath = "src/test/resources/pageObjectRepository/";

	public static String[] getElementFromFile(String pageName,
			String elementName) {
		try {
			FileReader specFile = new FileReader(filepath + pageName + ".gspec");
			return getElement(specFile, elementName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getSpecFilePath(String pageName){
		return filepath + pageName + ".gspec";
	}

	public static String getPageTitleFromFile(String pageName) {
		BufferedReader br = null;
		String returnElement = "";
		try {
			br = new BufferedReader(new FileReader(filepath + pageName
					+ ".gspec"));
			String line = br.readLine();

			while (line != null && !line.startsWith("========")) {
				String titleId = line.split(":", 3)[0];
				if (titleId.equalsIgnoreCase("#pagetitle")
						|| titleId.equalsIgnoreCase("#title")
						|| titleId.equalsIgnoreCase("#page title")) {
					returnElement = line;
					break;
				}
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return returnElement.split(":", 2)[1].trim();
	}

	private static String[] getElement(FileReader specFile, String elementName)
			throws Exception {

		ArrayList<String> elementLines = getSpecSection(specFile);
		for (String elementLine : elementLines) {

			if (elementLine.startsWith(elementName)) {
				return elementLine.split(" ", 3);
			}
		}
		throw new Exception();
	}

	private static ArrayList<String> getSpecSection(FileReader specfile) {
		String readBuff = null;
		ArrayList<String> elementLines = new ArrayList<>();

		try {
			BufferedReader buff = new BufferedReader(specfile);
			try {
				boolean flag = false;
				readBuff = buff.readLine();
				while ((readBuff = buff.readLine()) != null) {
					if (readBuff.startsWith("========")) {
						flag = !flag;
					}
					if (flag) {
						elementLines.add(readBuff.trim().replaceAll("[ \t]+",
								" "));
					}
					if (!elementLines.isEmpty() && !flag) {
						break;
					}
				}
			} finally {
				buff.close();
				if (elementLines.get(0).startsWith("========")) {
					elementLines.remove(0);
				}
			}
		} catch (FileNotFoundException e) {
			System.out
					.println("Spec File not found at location :- " + filepath);
		} catch (IOException e) {
			System.out.println("exceptional case");
		}
		return elementLines;
	}
}
