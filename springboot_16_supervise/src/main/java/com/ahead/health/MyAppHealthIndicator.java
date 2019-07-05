package com.ahead.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/8
 */
@Component
public class MyAppHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        long currentTime = System.currentTimeMillis();
        if (currentTime % 2 == 0) {
           return Health.up().withDetail("success", "健康").build();
        } else {
            return Health.down().withDetail("Error Msg", "You'll never start it, hahaha!").build();
        }
    }
}
