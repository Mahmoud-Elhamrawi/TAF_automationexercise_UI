package Utils.DataUtil;

import Utils.LogUtil.LogClass;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFiles {
    static String jsonFile;
    static String jsonFilePath = "src/test/resources/testData/";
    static String jsonReader;


    public ReadJsonFiles(String jsonFile) {
        ReadJsonFiles.jsonFile = jsonFile;
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) new JSONParser().parse(new FileReader(jsonFilePath + jsonFile + ".json"));
            jsonReader = jsonObject.toJSONString();
            LogClass.info("convert json to String");

        } catch (Exception e) {
            LogClass.error("fail to read json file" + e.getMessage());
        }
    }


    public static String getJsonKey(String key) {
        String jsonData;
        try {
            jsonData = JsonPath.read(jsonReader, key);
        } catch (Exception e) {
            LogClass.error("fail to read json file" + e.getMessage());
            return "0";
        }
        return jsonData;


    }


}
