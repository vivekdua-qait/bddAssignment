/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.vivek.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;


@SuppressWarnings("unchecked")
public class YamlReader {

    public static String yamlFilePath = "src/test/resources/testData/data.yml";

    public static String setYamlFilePath() {
        return yamlFilePath;
    }
    public static String getYamlValue(String token) {
        try {
            return getValue(token);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    private static String getValue(String token) throws FileNotFoundException {
        Reader doc = new FileReader(yamlFilePath);
        Yaml yaml = new Yaml();
        Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
        return getMapValue(object, token);
    }

    public static String getMapValue(Map<String, Object> object, String token) {

        String[] st = token.split("\\.");
        return parseMap(object, token).get(st[st.length - 1]).toString();
    }

    private static Map<String, Object> parseMap(Map<String, Object> object,
                                                String token) {
        if (token.contains(".")) {
            String[] st = token.split("\\.");
            object = parseMap((Map<String, Object>) object.get(st[0]),
                    token.replace(st[0] + ".", ""));
        }
        return object;
    }

}
