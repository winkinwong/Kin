package com.kin.maven.springboot.filter;

import com.alibaba.fastjson.JSON;
import com.kin.maven.springboot.global.ThreadLocalHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Component
public class LogFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /*
        * 实例化日志对象
        * */
        RequestLog requestLog = new RequestLog();
        requestLog.setUrl(request.getRequestURI());
        requestLog.setMethod(request.getMethod());
        requestLog.setParameterMap(request.getParameterMap());
        System.out.println(getRequestLogKey());
        request.setAttribute(getRequestLogKey(),requestLog);
        logger.info("请求 : {}", JSON.toJSONString(requestLog));
        /**
         * 记录当前线程绑定的requestId
         */

        ThreadLocalHelper.setRequestId(requestLog.requestId);

        /**
         * 调用下一个过滤器
         */
        filterChain.doFilter(request, response);

        /**
         * 业务逻辑执行完成
         */
        ResponseLog responseLog = new ResponseLog(requestLog.requestId);
        responseLog.setResponseStatus(response.getStatus());
        logger.info("响应 : {}",JSON.toJSONString(responseLog));
        /**
         * 删除当前线程绑定的requestId
         */
        ThreadLocalHelper.removeRequestId();
    }

    public static class ResponseLog{
        private int responseStatus;
        private final String requestId;
        public ResponseLog(String requestId){
            this.requestId=requestId;
        }
        public int getResponseStatus() {
            return responseStatus;
        }

        public void setResponseStatus(int responseStatus) {
            this.responseStatus = responseStatus;
        }

        public String getRequestId() {
            return requestId;
        }
    }
    public static String getRequestLogKey() {
        return LogFilter.class.getName() + ".requestLog";
    }
    public static class RequestLog{
        private final String requestId;
        private String url;
        private String method;
        private Map<String,String[]>parameterMap;

        public RequestLog(){
            this.requestId= UUID.randomUUID().toString();
        }
        public String getRequestId() {
            return requestId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public Map<String, String[]> getParameterMap() {
            return parameterMap;
        }

        public void setParameterMap(Map<String, String[]> parameterMap) {
            this.parameterMap = parameterMap;
        }
    }
}
