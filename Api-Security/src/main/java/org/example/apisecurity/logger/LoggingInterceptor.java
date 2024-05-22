package org.example.apisecurity.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String logId = UUID.randomUUID().toString();
        request.setAttribute("logId", logId);
        logger.info("LogID: {}, Request URL: {}, Method: {}, Parameters: {}", logId, request.getRequestURL(), request.getMethod(), request.getParameterMap());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String logId = (String) request.getAttribute("logId");
        logger.info("LogID: {}, Response Status: {}, Content-Type: {}", logId, response.getStatus(), response.getContentType());
    }

}

