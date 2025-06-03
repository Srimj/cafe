package com.cafe.listeners;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class AppStartupListener implements ApplicationListener<ApplicationReadyEvent> {

    @Value("${server.port}")
    private int port;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println("\n----------------------------------------------------------");
            System.out.println("Application is running! Access URLs:");
            System.out.println("Local:      http://localhost:" + port + contextPath);
            System.out.println("External:   http://" + hostAddress + ":" + port + contextPath);
            System.out.println("----------------------------------------------------------\n");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
