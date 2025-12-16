package moi.gda.data.backend_gda_data.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import moi.gda.data.backend_gda_data.utils.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<String>> handle(Exception e) {
    return ResponseEntity.badRequest()
      .body(ApiResponse.ok(e.getMessage()));
  }
}

