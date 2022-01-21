package br.com.mercado_livre.desafio.adapters.http.v1.interceptors;

import br.com.mercado_livre.desafio.adapters.http.v1.utils.HttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Slf4j
public class RestControllerLoggingInterceptor extends InterceptorRegistry implements HandlerInterceptor {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectReader jsonReader = (new ObjectMapper()).readerFor(Map.class);

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception ex) throws Exception {

        Object request = null;
        Object response = null;

        if(httpServletRequest instanceof ContentCachingRequestWrapper)
            request = HttpUtils.getContent(((ContentCachingRequestWrapper) httpServletRequest).getContentAsByteArray(), httpServletRequest.getCharacterEncoding());

        if(httpServletResponse instanceof ContentCachingResponseWrapper)
            response = HttpUtils.getContent(((ContentCachingResponseWrapper) httpServletResponse).getContentAsByteArray(), httpServletResponse.getCharacterEncoding());

        if(HttpStatus.resolve(httpServletResponse.getStatus()).is2xxSuccessful())

            log.info("{}", objectMapper.writeValueAsString(
                    new RestControllerLogging(
                            httpServletResponse.getStatus(),
                            httpServletRequest.getMethod(),
                            httpServletRequest.getRequestURI(),
                            request,
                            response
                    ))
            );

        else

            log.error("{}", objectMapper.writeValueAsString(
                    new RestControllerLogging(
                            httpServletResponse.getStatus(),
                            httpServletRequest.getMethod(),
                            httpServletRequest.getRequestURI(),
                            request,
                            response
                    ))
            );

    }

    @Getter
    @AllArgsConstructor
    private class RestControllerLogging {

        private Integer statusCode;
        private String method;
        private String route;
        private Object request;
        private Object response;

    }
}
