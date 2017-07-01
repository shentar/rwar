package com.service.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpecialListener implements ServletContextListener
{
    private static Logger logger = LoggerFactory.getLogger(SpecialListener.class);

    static
    {
        DOMConfigurator.configureAndWatch("log4j.xml", 6000);
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0)
    {
        logger.warn("began to stop the web service.");
        logger.warn("stopped the web service");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0)
    {
        logger.warn("start!");
        startBackGroundTask();
    }

    private void startBackGroundTask()
    {

    }
}
