package Utils.DataUtil;

import Utils.LogUtil.LogClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

public class ReadPropertiesFiles {

    public static String propertyFilePath = "src/main/resources/";

    public static Properties loadPropertyFiles() {
        try {
            Properties properties = new Properties();
            Collection<File> collection;
            collection = FileUtils.listFiles(new File(propertyFilePath), new String[]{"properties"}, true);
            collection.forEach(
                    file -> {
                        try {
                            properties.load(new FileInputStream(file));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        properties.putAll(System.getProperties());
                        System.getProperties().putAll(properties);
                    });
            LogClass.info("property file loaded");
            return properties;
        } catch (Exception e) {
            LogClass.error("fail to read property file" + e.getMessage());
            return null;
        }


    }


    public static String getProperty(String key) {
        try {
            return System.getProperty(key);
        } catch (Exception e) {
            LogClass.error("fail to read property file" + e.getMessage());
            return "0";
        }
    }

}
