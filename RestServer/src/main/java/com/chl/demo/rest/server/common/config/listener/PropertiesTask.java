package com.chl.demo.rest.server.common.config.listener;

import com.chl.demo.rest.server.common.config.ConfigUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.TimerTask;

/**
 * 配置更新任务
 * Created by caodongdong on 2017-03-30.
 */
public class PropertiesTask extends TimerTask
{
    private static final Logger LOG = LoggerFactory.getLogger(PropertiesTask.class);

    private ServletContext context = null;

    /**
     * 配置文件的最后更新时间
     */
    private long lastModified = 0;

    /**
     * 构造一个自动更新任务
     * 任务在整个 application 周期内只创建一次。
     *
     * @param context
     */
    public PropertiesTask(ServletContext context)
    {
        this.context = context;
    }

    /**
     * 监听配置文件是否被更新。
     */
    public void todoTestFileStatus()
    {
        System.out.println("Getting file status");
        System.out.println(this.isFileUpdated("WEB-INF/platforms/test.properties"));
    }

    /**
     * 监听配置文件是否被更新，自动更新文件中的配置项存储到 application 变量中。
     */
    public void todo()
    {
        String filename = "WEB-INF/platforms/test.properties";
        if (this.isFileUpdated(filename))
        {

            System.out.println("Getting properties");
            try
            {
                this.loadProperties("test", filename);
            }
            catch (IOException ioe)
            {
                System.err.println(ioe.getMessage());
            }
        }
        System.out.println("Test value is: " + this.getTestProperty("name"));
    }

    @Override
    public void run()
    {
//        String val = ConfigUtil.getVal("jdbc.driverClassName");

        ConfigUtil.loadProperties();
//        LOG.info("todo: reload the properties! val = {}", val);
//        String aaaa = ConfigUtil.getVal("A");

//        ConfigUtil.loadProperties();
//        LOG.info("todo: reload the properties! aaaa = {}", aaaa);
    }

    /**
     * 判断物理文件是否已被更新
     *
     * @param filename 物理文件名
     * @return 是 true 否 false
     */
    private boolean isFileUpdated(String filename)
    {
        File file = new File(context.getRealPath(filename));
        if (file.isFile())
        {
            long lastUpdateTime = file.lastModified();
            if (lastUpdateTime > this.lastModified)
            {
                System.out.println("The properties file was modified.");
                this.lastModified = lastUpdateTime;
                return true;
            }
            else
            {
                System.out.println("The properties file was not modified.");
                return false;
            }
        }
        else
        {
            System.out.println("The path does not point to a file.");
            return false;
        }
    }

    /**
     * 获取配置文件
     *
     * @param key
     * @param filename
     * @return
     */
    public void loadProperties(String key, String filename) throws IOException
    {
        Properties prop = new Properties();
        InputStream stream = context.getResourceAsStream(filename);
        prop.load(stream);
        if (stream != null)
        {
            stream.close();
        }
        context.setAttribute(key, prop);
    }

    /**
     * 从 application 取配置项的值
     *
     * @param key 配置项的键名
     * @return 配置项的值
     */
    public String getTestProperty(String key)
    {
        Properties prop = (Properties) context.getAttribute("test");
        if (prop == null)
        {
            return null;
        }
        else
        {
            return (String) prop.get(key);
        }
    }

}
