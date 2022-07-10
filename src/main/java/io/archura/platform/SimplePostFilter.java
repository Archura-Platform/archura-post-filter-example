package io.archura.platform;

import io.archura.platform.function.Configurable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.Map;
import java.util.function.BiConsumer;

@Component
public class SimplePostFilter implements BiConsumer<ServerRequest, ServerResponse>, Configurable {

    @Override
    public void accept(ServerRequest serverRequest, ServerResponse serverResponse) {
        System.out.println("SimplePostFilter serverRequest = " + serverRequest + " serverResponse = " + serverResponse);
        final HttpHeaders headers = serverResponse.headers();
        headers.entrySet().forEach(stringListEntry -> System.out.println("stringListEntry = " + stringListEntry));
    }

    @Override
    public void setConfiguration(Map<String, Object> configuration) {
        System.out.println("SimplePostFilter configuration = " + configuration);
    }
}
