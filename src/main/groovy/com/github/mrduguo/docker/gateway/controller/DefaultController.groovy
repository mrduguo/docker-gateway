package com.github.mrduguo.docker.gateway.controller

import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
@CompileStatic
public class DefaultController {

    @Value('${gateway.homepage.url:#{null}}')
    String homepageUrl

    @RequestMapping('/')
    String homepage(HttpServletResponse response) {
        if (homepageUrl) {
            response.setHeader('Cache-Control', 'no-store')
            new URL(homepageUrl).text
        } else {
            "From host: ${InetAddress.localHost.hostName}, <a href='./serviceability/env'>more info</a>"
        }
    }

    @RequestMapping('/serviceability/request-info')
    def requestInfo(HttpServletRequest request) {
        [
                request: [
                        schema     : request.getScheme(),
                        method     : request.getMethod(),
                        protocol   : request.getProtocol(),
                        uri        : request.getRequestURI(),
                        queryString: request.getQueryString(),
                ],
                remote : [
                        address: request.getRemoteAddr(),
                        user   : request.getRemoteUser(),
                        port   : request.getRemotePort(),
                ],
                local  : [
                        address: request.getLocalAddr(),
                        port   : request.getLocalPort(),
                ],
                headers: request.headerNames.toList().collectEntries { [(it): request.getHeader(it)] },
        ]
    }
}
