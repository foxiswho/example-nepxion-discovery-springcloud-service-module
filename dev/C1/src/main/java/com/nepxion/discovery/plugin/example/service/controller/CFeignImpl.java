package com.nepxion.discovery.plugin.example.service.controller;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

import com.nepxion.discovery.common.constant.DiscoveryConstant;
import com.nepxion.discovery.plugin.example.service.api.AbstractFeignImpl;
import com.nepxion.discovery.plugin.example.service.api.CFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnProperty(name = DiscoveryConstant.SPRING_APPLICATION_NAME, havingValue = "discovery-springcloud-example-c")
public class CFeignImpl extends AbstractFeignImpl implements CFeign {
    private static final Logger LOG = LoggerFactory.getLogger(CFeignImpl.class);

    @Override
    public String invoke(@RequestBody String value) {
        value = doInvoke(value);

        LOG.info("调用路径：{}", value);

        return value;
    }
}