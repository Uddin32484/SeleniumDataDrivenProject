package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class JsonUtils {


    public static List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath),
                new TypeReference<List<HashMap<String, String>>>() {});
    }
}
