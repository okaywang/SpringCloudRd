package com.example.apply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/7/17.
 */
@RestController
public class ApplyController {
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "interview", method = RequestMethod.GET)
    public String sendInterview() {


        ApplyRequestDto dto = new ApplyRequestDto();
        dto.setJobId(100);
        String url = "http://JOB-SERVICE/job?jobId=" + dto.getJobId();
        String response = restTemplate.getForEntity(url, String.class).getBody();
        String jobName = response;

        testLoadbalance();
        return jobName;
    }

    private void testLoadbalance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("JOB-SERVICE");
        StringBuilder sb = new StringBuilder();
        sb.append("host: ").append(serviceInstance.getHost()).append(", ");
        sb.append("port: ").append(serviceInstance.getPort()).append(", ");
        sb.append("uri: ").append(serviceInstance.getUri());
        logger.info(sb.toString());
    }
}

