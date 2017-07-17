package com.example.apply;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/7/17.
 */
@Configuration
public class RibbonConfiguration {

    @Autowired
    private SpringClientFactory springClientFactory;

    @Bean
    public IRule ribbonRule() {
        //return new RoundRobinRule();
        return new BestAvailableRule();
    }

}