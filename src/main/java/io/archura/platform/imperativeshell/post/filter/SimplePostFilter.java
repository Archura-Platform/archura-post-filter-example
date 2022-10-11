package io.archura.platform.imperativeshell.post.filter;

import io.archura.platform.api.context.Context;
import io.archura.platform.api.http.HttpServerRequest;
import io.archura.platform.api.http.HttpServerResponse;
import io.archura.platform.api.logger.Logger;
import io.archura.platform.api.type.Configurable;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;


public class SimplePostFilter implements BiFunction<HttpServerRequest, HttpServerResponse, HttpServerResponse>, Configurable {

    private Map<String, Object> configuration;

    @Override
    public HttpServerResponse apply(HttpServerRequest request, HttpServerResponse response) {
        final Context context = (Context) request.getAttributes().get(Context.class.getSimpleName());
        final Logger logger = context.getLogger();

        logger.info("request = " + request + " response = " + response + " configuration = " + configuration);
        Map<String, List<String>> headers = response.getHeaders();
        headers.entrySet().forEach(stringListEntry -> logger.info("stringListEntry = " + stringListEntry));
        return response;
    }

    @Override
    public void setConfiguration(Map<String, Object> configuration) {
        this.configuration = configuration;
    }
}
