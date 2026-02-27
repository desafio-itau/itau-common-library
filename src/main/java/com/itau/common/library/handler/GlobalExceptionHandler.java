package com.itau.common.library.handler;

import com.itau.common.library.exception.*;
import com.itau.common.library.response.ErrorResponse;
import com.itau.common.library.response.SimpleErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        log.warn("Erro de validação: {}", ex.getMessage());

        List<ErrorResponse.FieldError> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::mapFieldError)
                .toList();

        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Validation Error")
                .message("Erro de validação nos campos")
                .path(request.getRequestURI())
                .fieldErrors(fieldErrors)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<SimpleErrorResponse> handleBaseException(
            BaseException ex,
            HttpServletRequest request) {

        try {
            String tipoErro = ex.getClass().getSimpleName();

            log.info("Tratando BaseException: tipo={}, errorConstant={}",
                    tipoErro,
                    ex.getErrorConstant() != null ? ex.getErrorConstant().getCodigo() : "NULL");

            if (ex.getErrorConstant() == null) {
                log.error("ERRO: errorConstant é null na exception {}", tipoErro, ex);
                throw new IllegalStateException("ErrorConstant não pode ser null");
            }

            if (ex.getErrorConstant().getCodigoHTTP() >= 500) {
                log.error("{}: {} - {}", tipoErro, ex.getErrorConstant().getCodigo(), ex.getMessage(), ex);
            } else {
                log.warn("{}: {} - {}", tipoErro, ex.getErrorConstant().getCodigo(), ex.getMessage());
            }

            SimpleErrorResponse error = SimpleErrorResponse.builder()
                    .erro(ex.getErrorConstant().getMensagem())
                    .codigo(ex.getErrorConstant().getCodigo())
                    .build();

            return ResponseEntity
                    .status(ex.getErrorConstant().getCodigoHTTP())
                    .body(error);

        } catch (Exception e) {
            log.error("ERRO AO PROCESSAR BaseException", e);
            log.error("Exception original:", ex);
            throw e;
        }
    }

    private ErrorResponse.FieldError mapFieldError(FieldError fieldError) {
        return ErrorResponse.FieldError.builder()
                .field(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .rejectedValue(fieldError.getRejectedValue())
                .build();
    }
}

