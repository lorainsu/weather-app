package com.example.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public abstract class PropertiesUtils {
    private static final Logger LOG = LoggerFactory.getLogger(PropertiesUtils.class);

    private static Properties properties = null;

    static {
        properties = loadProperty();
    }

    private static Properties loadProperty() {
        Properties p = new Properties();
        loadProp("weatherdata.properties", p);
        return p;
    }

    private static void loadProp(String conf, Properties p) {
        InputStream is = null;
        try {
            is = getInputStream(conf);
            if (null != is) {
                p.load(is);
            }
        } catch (IOException e) {
            LOG.error("Exception happened in loadProp() :" + e.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOG.error("Exception happened in loadProperty() :" + e.getMessage());
                }
            }
        }
    }

    public static String getValue(String key) {
        String value = properties.getProperty(key);
        return value != null ? value : "";
    }

    private static InputStream getInputStream(String path) throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(path + " cannot be opened because it does not exist");
        } else {
            return is;
        }
    }

}

