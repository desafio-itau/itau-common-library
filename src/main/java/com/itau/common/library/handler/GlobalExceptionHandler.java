package com.itau.common.library.handler;

import com.itau.common.library.constants.Constants;
import com.itau.common.library.exception.ConflitoException;
import com.itau.common.library.exception.NegocioException;
import com.itau.common.library.exception.RecursoNaoEncontradoException;
import com.itau.common.library.exception.ServicoIndisponivelException;
import com.itau.common.library.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            RecursoNaoEncontradoException ex,
            HttpServletRequest request) {

        log.warn("Recurso não encontrado: {}", ex.getMessage());

        Constants constant = Constants.findConstantByCode(ex.getMessage());

        ErrorResponse error = ErrorResponse.builder()
                .erro(constant.getMensagem())
                .codigo(constant.getCodigo())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(
            NegocioException ex,
            HttpServletRequest request) {

        log.warn("Erro de negócio: {}", ex.getMessage());

        Constants constant = Constants.findConstantByCode(ex.getMessage());

        ErrorResponse error = ErrorResponse.builder()
                .erro(constant.getMensagem())
                .codigo(constant.getCodigo())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ConflitoException.class)
    public ResponseEntity<ErrorResponse> handleConflictException(
            ConflitoException ex,
            HttpServletRequest request) {

        log.warn("Erro de conflito: {}", ex.getMessage());

        Constants constant = Constants.findConstantByCode(ex.getMessage());

        ErrorResponse error = ErrorResponse.builder()
                .erro(constant.getMensagem())
                .codigo(constant.getCodigo())
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(ServicoIndisponivelException.class)
    public ResponseEntity<ErrorResponse> handleServiceUnavailableException(
            ServicoIndisponivelException ex,
            HttpServletRequest request) {

        log.error("Serviço indisponível: {}", ex.getMessage());

        Constants constant = Constants.findConstantByCode(ex.getMessage());

        ErrorResponse error = ErrorResponse.builder()
                .erro(constant.getMensagem())
                .codigo(constant.getCodigo())
                .build();

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request) {

        log.error("Erro interno do servidor: {}", ex.getMessage());

        Constants constant = Constants.findConstantByCode(ex.getMessage());

        ErrorResponse error = ErrorResponse.builder()
                .erro(constant.getMensagem())
                .codigo(constant.getCodigo())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}

