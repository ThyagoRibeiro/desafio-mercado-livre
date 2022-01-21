package br.com.mercado_livre.desafio.unittests.adapters.http.rest.v1.interceptors;

import br.com.mercado_livre.desafio.adapters.http.v1.interceptors.RestControllerLoggingInterceptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
public class RestControllerLoggingInterceptorTest {

    @MockBean
    private ContentCachingRequestWrapper contentCachingRequestWrapper;

    @MockBean
    private ContentCachingResponseWrapper contentCachingResponseWrapper;

    @Test
    public void after_completion() throws Exception {

        String object = "{\"Chave\":\"Valor\"}";

        when(contentCachingRequestWrapper.getContentAsByteArray()).thenReturn(object.getBytes(StandardCharsets.UTF_8));
        when(contentCachingResponseWrapper.getContentAsByteArray()).thenReturn(object.getBytes(StandardCharsets.UTF_8));
        when(contentCachingResponseWrapper.getStatus()).thenReturn(HttpStatus.OK.value());

        RestControllerLoggingInterceptor restControllerLoggingInterceptor = new RestControllerLoggingInterceptor();
        restControllerLoggingInterceptor.afterCompletion(contentCachingRequestWrapper, contentCachingResponseWrapper, null, null);

    }


}
