package br.com.mercado_livre.desafio.adapters.http.v1.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import net.logstash.logback.util.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class HttpUtils {

    public static final List<MediaType> LOGGABLE_CONTENT_TYPES;
    private static final ObjectReader jsonReader = (new ObjectMapper()).readerFor(Map.class);

    public static ContentCachingRequestWrapper wrapRequest(HttpServletRequest request) {
        return request instanceof ContentCachingRequestWrapper ? (ContentCachingRequestWrapper)request : new ContentCachingRequestWrapper(request, 32000);
    }

    public static ContentCachingResponseWrapper wrapResponse(HttpServletResponse response) {
        return response instanceof ContentCachingResponseWrapper ? (ContentCachingResponseWrapper)response : new ContentCachingResponseWrapper(response);
    }

    public static boolean isLoggableContent(String contentType) {
        if (StringUtils.isBlank(contentType)) {
            return false;
        } else {
            MediaType mediaType = MediaType.valueOf(contentType);
            return LOGGABLE_CONTENT_TYPES.stream().anyMatch((visibleType) -> {
                return visibleType.includes(mediaType);
            });
        }
    }

    static {
        LOGGABLE_CONTENT_TYPES = Arrays.asList(MediaType.valueOf("text/*"), MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.valueOf("application/*+json"), MediaType.valueOf("application/*+xml"), MediaType.MULTIPART_FORM_DATA);
    }

    public static Object getContent(byte[] content, String contentEncoding) {
        try {
            try {
                return jsonReader.readValue(content);
            } catch (Exception var4) {
                return new String(content, contentEncoding);
            }
        } catch (UnsupportedEncodingException var5) {
            return content.length > 0 ? "[" + content.length + " bytes content]" : "[empty]";
        }
    }

}
