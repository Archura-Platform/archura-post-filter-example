package io.archura.platform;

import io.archura.platform.function.Configurable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.Date;
import java.util.Map;
import java.util.function.BiConsumer;

@Component
public class SimplePostFilter implements BiConsumer<ServerRequest, ServerResponse>, Configurable {

    @Override
    public void accept(ServerRequest serverRequest, ServerResponse serverResponse) {
        log("serverRequest = " + serverRequest + " serverResponse = " + serverResponse);
        final HttpHeaders headers = serverResponse.headers();
        headers.entrySet().forEach(stringListEntry -> log("stringListEntry = " + stringListEntry));
    }

    @Override
    public void setConfiguration(Map<String, Object> configuration) {
        log("configuration = " + configuration);
    }

    private void log(final String log) {
        String message = String.format("[%s] [%s-%s] [%s]: %s",
                new Date(),
                Thread.currentThread().getId(),
                Thread.currentThread().getName(),
                this.getClass().getSimpleName(),
                log);
        System.out.println(message);
    }
}
