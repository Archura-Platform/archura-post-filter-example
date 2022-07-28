package io.archura.platform.imperativeshell.post.filter;

import io.archura.platform.api.context.Context;
import io.archura.platform.api.logger.Logger;
import io.archura.platform.api.type.Configurable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.Map;
import java.util.function.BiFunction;

@Component
public class SimplePostFilter implements BiFunction<ServerRequest, ServerResponse, ServerResponse>, Configurable {

    private Map<String, Object> configuration;

    @Override
    public ServerResponse apply(ServerRequest request, ServerResponse response) {
        final Context context = (Context) request.attributes().get(Context.class.getSimpleName());
        final Logger logger = context.getLogger();

        logger.info("request = " + request + " response = " + response + " configuration = " + configuration);
        final HttpHeaders headers = response.headers();
        headers.entrySet().forEach(stringListEntry -> logger.info("stringListEntry = " + stringListEntry));
        return response;
    }

    @Override
    public void setConfiguration(Map<String, Object> configuration) {
        this.configuration = configuration;
    }
}
