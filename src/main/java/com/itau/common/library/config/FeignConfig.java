package com.itau.common.library.config;

import feign.Client;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

@Configuration
public class FeignConfig {

    @Bean("feignClient")
    public Client createFeignClient() throws NoSuchAlgorithmException {
        SSLContext sslContext = SSLContext.getDefault();

        return new Client.Default(sslContext.getSocketFactory(), new NoopHostnameVerifier());
    }
}
