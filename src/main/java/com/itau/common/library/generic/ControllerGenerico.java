package com.itau.common.library.generic;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public interface ControllerGenerico {

    default URI gerarHeaderLocation(Long id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
