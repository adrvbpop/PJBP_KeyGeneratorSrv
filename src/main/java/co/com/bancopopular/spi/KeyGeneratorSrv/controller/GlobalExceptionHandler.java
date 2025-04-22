//Clase utilizada en el controller para el manejo de excepciones
package co.com.bancopopular.spi.KeyGeneratorSrv.controller;

import co.com.bancopopular.spi.KeyGeneratorSrv.dto.ErrorResponseDTO;
import co.com.bancopopular.spi.KeyGeneratorSrv.dto.KeyGenerationRequest;
import co.com.bancopopular.spi.KeyGeneratorSrv.dto.MsgHdrResponse;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.BusinessException;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.InternalServerException;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(NotFoundException ex, HttpServletRequest request) {
        String requestId = request.getHeader("X-Request-ID");
        ErrorResponseDTO error = buildError(HttpStatus.NOT_FOUND.value(), ex.getMessage(),requestId);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDTO> handleBusinessException(BusinessException ex, HttpServletRequest request) {
        String requestId = request.getHeader("X-Request-ID");
        ErrorResponseDTO error = buildError(206, ex.getMessage(),requestId);
        return new ResponseEntity<>(error, HttpStatus.PARTIAL_CONTENT);
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ErrorResponseDTO> handleInternalServerException(InternalServerException ex, HttpServletRequest request) {
        String requestId = request.getHeader("X-Request-ID");
        ErrorResponseDTO error = buildError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                requestId);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericException(Exception ex, HttpServletRequest request) {
        String requestId = request.getHeader("X-Request-ID");
        ErrorResponseDTO error = buildError(HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                requestId);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private ErrorResponseDTO buildError(int code, String message, String requestId) {
        KeyGenerationRequest request = new KeyGenerationRequest();
        MsgHdrResponse header = new MsgHdrResponse();
        header.setRequestId(requestId);
        header.setCodigoRespuesta(code);
        header.setMensajeRespuesta(message);

        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setCode(code);
        error.setMessage(message);
        error.setMsgHdrResp(header);
        return error;
    }

}

