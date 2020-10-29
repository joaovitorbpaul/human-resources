package com.jpaul.hrpayroll.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.Reader;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String method, Response response) {
        try (Reader reader = response.body().asReader()) {
            String message = IOUtils.toString(reader);
            log.error("Method: {}, Status Code: {}, Message: {}", method, response.status(), message);
            return new ResponseStatusException(HttpStatus.valueOf(response.status()), message);
        } catch (IOException e) {
            log.error("Method: {}, Status Code: {}", method, response.status(), e.fillInStackTrace());
        }
        return new ResponseStatusException(HttpStatus.valueOf(response.status()));
    }
}
