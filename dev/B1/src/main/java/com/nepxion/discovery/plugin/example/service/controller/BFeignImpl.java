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
import com.nepxion.discovery.plugin.example.service.api.CFeign;
import com.nepxion.discovery.plugin.example.service.consts.ServiceConsts;
import com.nepxion.discovery.plugin.example.service.api.AbstractFeignImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnProperty(name = DiscoveryConstant.SPRING_APPLICATION_NAME, havingValue = ServiceConsts.discovery_springcloud_example_b)
public class BFeignImpl extends AbstractFeignImpl implements BFeign {
    private static final Logger LOG = LoggerFactory.getLogger(BFeignImpl.class);

    @Autowired
    private CFeign cFeign;

    @Override
    public String invoke(@RequestBody String value) {
        value = doInvoke(value);
        value = cFeign.invoke(value);

        LOG.info("调用路径：{}", value);

        return value;
    }

    @Override
    public String get() {
        String value = "get=ggggggggggggggg";

        LOG.info("调用路径：{}", value);
        LOG.info("调用路径：{}", value);
        LOG.info("===================", value);
        LOG.info("===================", value);
        LOG.info("===================", value);
        LOG.info("===================", value);
        LOG.info("===================", value);
        LOG.info("===================", value);

        return value;
    }

    @Override
    public String post(@RequestBody String value) {
        value = doInvoke(value);

        LOG.info("post：{}", value);
        LOG.info("post：{}", value);
        LOG.info("post：{}", value);
        LOG.info("post：{}", value);
        LOG.info("post：{}", value);
        LOG.info("post：{}", value);

        return value;
    }
}