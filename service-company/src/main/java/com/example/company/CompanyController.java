package com.example.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/17.
 */
@RestController
public class CompanyController {
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "company")
    public CompanyDetailDto getCompanyDetail(long companyId) {
        CompanyDetailDto dto = getCompanyDetailDtoMock(companyId);

        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("service invoked: /job, host:[" + instance.getHost() + "], port:[" + instance.getPort() + "], service_id:" + instance.getServiceId());

        return dto;
    }

    private CompanyDetailDto getCompanyDetailDtoMock(long companyId) {
        CompanyDetailDto dto = new CompanyDetailDto();
        dto.setCompanyId(companyId);
        dto.setCompanyName("乐视科技有限公司" + companyId);
        dto.setEnableFeedback(true);
        return dto;
    }
}
