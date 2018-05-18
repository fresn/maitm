package Utility;

import com.jayway.jsonpath.JsonPath;

import java.io.File;

public class Json {
    public String fetch(String filePath, String jsonPath) {
        try {
            String result = JsonPath.read(new File(filePath), jsonPath).toString();
            result = result.substring(2, result.length() - 2);
            result = result.replace("\\", "");
            return result;
        } catch (Exception e) {
            return "Could not find any information using the information provided.";
        }
    }
}
