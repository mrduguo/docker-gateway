package com.github.mrduguo.docker.gateway

import groovy.transform.CompileStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@CompileStatic
public class Application {


    static {
        populateSystemPropertiesBeforeSpringBootAppStart()
    }

    public static void populateSystemPropertiesBeforeSpringBootAppStart() {
        System.properties['info.app.startup.time'] = new Date(
                java.lang.management.ManagementFactory.getRuntimeMXBean().getStartTime()
        ).format('yyyy-MM-dd HH:mm:ss z')

        if (!isProfileAlreadySet()) {
            String classPath = System.properties['java.class.path']
            classPath=classPath.replaceAll('\\\\','/')
            System.properties['spring.profiles.active'] =
                    classPath.indexOf('build/classes/test') > 0 ? 'local,test' :
                            classPath.indexOf('classes') > 0 ? 'local' : 'prod'
        }
    }

    public static boolean isProfileAlreadySet() {
        if (System.getenv('SPRING_PROFILES_ACTIVE') || System.properties['spring.profiles.active']) {
            true
        } else {
            String fullCommand = System.properties['sun.java.command']
            fullCommand.indexOf('--spring.profiles.active') > 0
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }

}
