package com.github.mrduguo.docker.gateway

import org.springframework.http.HttpStatus

class HealthSpec extends AbstractSpec {

    void "web app should be health"() {
        when:
        def entity = getForEntity('/serviceability/health', Map.class)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body.status == 'UP'
        entity.body.diskSpace.status == 'UP'
    }

}