package org.example.apisecurity.qps;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

@Component
public class QpsLimiter {
    // 设置QPS上限为10
    private RateLimiter rateLimiter = RateLimiter.create(10);

    // 尝试获取令牌，如果获取成功，则返回true，表示可以处理请求；否则返回false，表示QPS超过限制，需要丢弃请求
    public boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }
}
