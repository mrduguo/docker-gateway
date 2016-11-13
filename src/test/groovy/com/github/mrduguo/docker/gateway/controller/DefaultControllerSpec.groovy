package com.github.mrduguo.docker.gateway.controller

import com.github.mrduguo.docker.gateway.AbstractSpec
import org.springframework.http.HttpStatus

class DefaultControllerSpec extends AbstractSpec {

    void "should return host info"() {
        when:
        def entity = getForEntity('/', String.class)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body.startsWith 'From host:'
    }

    void "request info should return headers"() {
        when:
        def entity = getForEntity('/serviceability/request-info', Map.class)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body.headers.connection == 'Keep-Alive'
    }

}