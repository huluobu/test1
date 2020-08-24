package com.carrot.robin;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * create by: carrot
 * classname: MyRobinRule
 * description: use to 特殊轮询算法启动
 * create time: 2020/4/24 10:40
 */
@Slf4j
public class MyRobinRule extends AbstractLoadBalancerRule {

    public MyRobinRule() {
    }

    public MyRobinRule(ILoadBalancer lb) {
        this();
        this.setLoadBalancer(lb);
    }
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            log.warn("no load balancer");
            return null;
        } else {
            Server server = null;
            int count = 0;

            while(true) {
                if (server == null && count++ < 10) {
                    List<Server> reachableServers = lb.getReachableServers();
                    List<Server> allServers = lb.getAllServers();
                    int upCount = reachableServers.size();
                    int serverCount = allServers.size();
                    if (upCount != 0 ) {

                        for (Server server1:reachableServers){
                            log.info(server1.getId());
                            log.info("server is: "+server1+"--server port is"+server1.getHostPort());
                            if(server1.getPort()==8002){return server1;}
                            else {continue;}
                        }
                    }

                    log.warn("No up servers available from load balancer: " + lb);
                    return null;
                }

                if (count >= 10) {
                    log.warn("No available alive servers after 10 tries from load balancer: " + lb);
                }

                return server;
            }
        }
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }
}
