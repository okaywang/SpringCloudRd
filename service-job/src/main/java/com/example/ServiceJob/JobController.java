package com.example.ServiceJob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by Administrator on 2017/7/17.
 */
@RestController
public class JobController {

    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "job")
    public JobDetailDto getJobDetail(long jobId) {
        JobDetailDto dto = getJobDetailDtoMock(jobId);


        ServiceInstance instance = client.getLocalServiceInstance();

        logger.info("service invoked: /job, host:[" + instance.getHost() + "], port:[" + instance.getPort() + "], service_id:" + instance.getServiceId());

        return dto;
    }

    private JobDetailDto getJobDetailDtoMock(long jobId) {
        JobDetailDto dto = new JobDetailDto();
        dto.setJobId(jobId);
        dto.setJobTitle("Java Developer " + jobId);
        dto.setDescription(UUID.randomUUID().toString());

        return dto;
    }
}
