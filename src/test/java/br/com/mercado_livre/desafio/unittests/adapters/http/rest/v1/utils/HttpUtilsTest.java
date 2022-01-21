package br.com.mercado_livre.desafio.unittests.adapters.http.rest.v1.utils;

import br.com.mercado_livre.desafio.adapters.http.v1.utils.HttpUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
public class HttpUtilsTest {

    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private ContentCachingRequestWrapper contentCachingRequestWrapper;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @MockBean
    private ContentCachingResponseWrapper contentCachingResponseWrapper;

    @Test
    public void wrap_request() {
        HttpUtils.wrapRequest(httpServletRequest);
    }

    @Test
    public void wrap_request_content_caching() {
        HttpUtils.wrapRequest(contentCachingRequestWrapper);
    }

    @Test
    public void wrap_response() {
        HttpUtils.wrapResponse(httpServletResponse);
    }

    @Test
    public void wrap_response_content_caching() {
        HttpUtils.wrapResponse(contentCachingResponseWrapper);
    }

    @Test
    public void is_loggable_content_blank() {
        assertEquals(false, HttpUtils.isLoggableContent(""));
    }

    @Test
    public void is_loggable_content_not_blank() {
        assertEquals(true, HttpUtils.isLoggableContent("application/json"));
    }

    @Test
    public void get_content() {
        String object = "{\"Chave\":\"Valor\"}";
        assertEquals("Valor", ((LinkedHashMap) HttpUtils.getContent(object.getBytes(StandardCharsets.UTF_8), "utf-8")).get("Chave"));
    }


    @Test
    public void get_content_json_parse_exception() {
        String object = "Teste";
        assertEquals(object, HttpUtils.getContent(object.getBytes(StandardCharsets.UTF_8), "utf-8"));
    }

    @Test
    public void get_content_unsupported_encoding_exception() {
        String object = "Teste";
        assertEquals("[5 bytes content]", HttpUtils.getContent(object.getBytes(StandardCharsets.UTF_8), ""));
    }

}
