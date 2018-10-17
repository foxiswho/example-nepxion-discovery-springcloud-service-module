package com.nepxion.discovery.plugin.example.service.controller;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 *
 * @author Haojun Ren
 * @version 1.0
 */

import com.nepxion.discovery.common.constant.DiscoveryConstant;
import com.nepxion.discovery.plugin.example.service.api.BFeign;
import com.nepxion.discovery.plugin.example.service.consts.ServiceConsts;
import com.nepxion.discovery.plugin.example.service.api.AFeign;
import com.nepxion.discovery.plugin.example.service.api.AbstractFeignImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnProperty(name = DiscoveryConstant.SPRING_APPLICATION_NAME, havingValue = ServiceConsts.discovery_springcloud_example_a)
public class AFeignImpl extends AbstractFeignImpl implements AFeign {
    private static final Logger LOG = LoggerFactory.getLogger(AFeignImpl.class);

    @Autowired
    private BFeign bFeign;

    @Override
    public String invoke(@RequestBody String value) {
        value = doInvoke(value);
        value = bFeign.invoke(value);

        LOG.info("调用路径：{}", value);

        return value;
    }

    @Override
    public String get() {
        String value = bFeign.get();

        LOG.info("===========：value ", value);
        LOG.info("===========：value ", value);
        LOG.info("===========：value ", value);
        LOG.info("===========：value ", value);

        return value;
    }

    @Override
    public String post(@RequestBody String value) {
        value = doInvoke(value);
        value = bFeign.post(value);
        LOG.info("AAAAAAAAAAAAA：value ", value);
        return value;
    }

    @Override
    public String post2() {
        String value = "sssssssssss";
        LOG.info("AAAAAAAAAAAAA：value ", value);
        return value;
    }
}