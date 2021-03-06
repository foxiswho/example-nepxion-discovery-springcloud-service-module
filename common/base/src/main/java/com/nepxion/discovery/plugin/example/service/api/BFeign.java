package com.nepxion.discovery.plugin.example.service.api;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

import com.nepxion.discovery.plugin.example.service.consts.ServiceConsts;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = ServiceConsts.discovery_springcloud_example_b)
// Context-patch一旦被设置，在Feign也要带上context-path，外部Postman调用网关或者服务路径也要带context-path
// @FeignClient(value = "discovery-springcloud-example-b/nepxion")
public interface BFeign {
    @RequestMapping(path = "/invoke", method = RequestMethod.POST)
    String invoke(@RequestBody String value);

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    String get();

    @RequestMapping(path = "/post", method = RequestMethod.POST)
    String post(@RequestBody String value);
}