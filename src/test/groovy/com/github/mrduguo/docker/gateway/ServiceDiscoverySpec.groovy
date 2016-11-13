package com.github.mrduguo.docker.gateway

import org.springframework.http.HttpStatus

class ServiceDiscoverySpec extends AbstractSpec {

    void "should contain consul service"() {
        when:
        def entity = getForEntity('/consul/v1/catalog/service/consul', List.class)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body[0].Address == '127.0.0.1'
        entity.body[0].ServicePort == 8300
    }

}