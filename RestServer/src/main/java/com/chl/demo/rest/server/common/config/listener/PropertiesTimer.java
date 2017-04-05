package com.chl.demo.rest.server.common.config.listener;

import javax.servlet.ServletContext;
import java.util.Timer;

/**
 * 配置加载执行器
 * Created by caodongdong on 2017-03-30.
 */
public class PropertiesTimer {
    private final Timer timer = new Timer();

    private final int sec;

    private ServletContext context = null;

    public PropertiesTimer(int seconds, ServletContext context) {
        sec = seconds;
        this.context = context;
    }

    /**
     * 启动自动监听任务
     * {@code sec}秒之后启动，此后每{@code sec}执行一次
     */
    public void start() {
        timer.schedule(new PropertiesTask(this.context), sec * 1000, sec * 1000);
    }

    /**
     * 停止自动监听任务
     */
    public void stop() {
        timer.cancel();
    }
}
