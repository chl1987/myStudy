package com.chl.demo.rest.server.common.config.listener;

import com.chl.demo.rest.server.common.GC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 配置监听器
 * Created by caodongdong on 2017-03-30.
 */
public class PropertiesListener implements ServletContextListener {

    private static final Logger LOG = LoggerFactory.getLogger(PropertiesListener.class);

    /**
     * 自动监听时钟
     */
    private PropertiesTimer rt = null;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        LOG.info("PropertiesListener, start.");
        rt = new PropertiesTimer(GC.PROPERTIES_REFRESH_TIME_MINUTE * 60, event.getServletContext());
        rt.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        LOG.info("PropertiesListener, stop.");

        if (rt != null) {
            rt.stop();
        }
    }
}
