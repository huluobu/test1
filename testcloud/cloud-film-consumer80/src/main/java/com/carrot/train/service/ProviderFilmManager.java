package com.carrot.train.service;

import com.carrot.testcloud.entities.CommonResult;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: carrot
 * @Date: 2020/10/25 9:12
 */
@Component
@FeignClient(value = "cloud-film-provider")
public interface ProviderFilmManager {

    @RequestMapping(value = "home")
    public CommonResult toHomepage();
}
