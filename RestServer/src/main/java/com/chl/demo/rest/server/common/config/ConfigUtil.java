package com.chl.demo.rest.server.common.config;

import com.chl.demo.rest.server.common.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置读写工具
 * Created by caodongdong on 2017-03-30.
 */
public abstract class ConfigUtil {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigUtil.class);

    private static final String CONFIG_HOME = ConfigUtil.class.getClassLoader().getResource("").getPath();

    private static final String DB_CONFIG = CONFIG_HOME + "db.properties";

    private static long lastModifiedOfDbConfig = 0;

    private static Properties jdbcProps = new Properties();

    static {
        ConfigUtil.loadProperties();
    }

    public static String getVal(String name) {
        return getVal(name, "");
    }

    public static String getVal(String name, String defaultValue) {
        String val = jdbcProps.getProperty(name);
        if (StringUtils.isEmpty(val)) {
            return defaultValue;
        }
        return val;
    }

    public static void loadProperties() {
        loadProperties(DB_CONFIG);
        loadProperties(CONFIG_HOME + "sysconfig.properties");
    }

    public static void loadProperties(String fileName) {
        InputStream is = null;
        try {
            if (!isFileUpdated(fileName)) {
                return;
            }

            is = new FileInputStream(fileName);
            if (is.available() > 0) {
                jdbcProps.load(is);

                LOG.info("load Properties succ, filePath: {}", fileName);
            }
        } catch (IOException e) {
            LOG.error("load Properties fail : filePath is " + fileName + ", exception is ", e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                LOG.error("inputStream close fail : filePath is" + fileName + ", exception is ", e);
            }
        }
    }

    private static boolean isFileUpdated(String filename) {
        File file = new File(filename);
        if (file.isFile()) {
            long lastUpdateTime = file.lastModified();
            if (lastUpdateTime > lastModifiedOfDbConfig) {
                LOG.info("File {} was modified.", filename);
                lastModifiedOfDbConfig = lastUpdateTime;
                return true;
            } else {
                return false;
            }
        } else {
            LOG.error("Path {} does not point to a file.", filename);
            return false;
        }
    }

}

