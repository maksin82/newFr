//package utils;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//public class ConfigManager {
//    private Properties properties = new Properties();
//
//    public ConfigManager(String fileName) {
//        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
//            if (input == null) {
//                throw new IOException("Endpoint отсутствует " + fileName);
//            }
//            properties.load(input);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String getProperty(String key) {
//        return properties.getProperty(key);
//    }
//}