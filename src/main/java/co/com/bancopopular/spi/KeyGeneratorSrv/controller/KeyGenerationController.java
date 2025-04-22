package co.com.bancopopular.spi.KeyGeneratorSrv.controller;

import co.com.bancopopular.spi.KeyGeneratorSrv.api.IKeySpiControllerApi;
import co.com.bancopopular.spi.KeyGeneratorSrv.dto.*;
import co.com.bancopopular.spi.KeyGeneratorSrv.service.KeyGenerationService;
import co.com.bancopopular.spi.KeyGeneratorSrv.service.KeyMDMService;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.BusinessException;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/keys")
public class KeyGenerationController implements IKeySpiControllerApi {

    @Autowired
    private final KeyGenerationService keyService;
    private final KeyMDMService MDMService;

    public KeyGenerationController(KeyGenerationService keyService, KeyMDMService mdmService) {
        this.keyService = keyService;
        MDMService = mdmService;
    }

    @Override
    public ResponseEntity<KeyGenerationResponse> generateKey(@RequestBody KeyGenerationRequest request, @RequestHeader(value = "X-Request-ID", required = true)  String requestId) {
        if (request == null ) {
            throw new IllegalArgumentException("Request cannot be empty");
        } else if (request.getNumeroIdentificacion().isEmpty()) {
            throw new Exception("El numero de identificacion es obligatorio");
        }
        KeyGenerationResponse response = (KeyGenerationResponse) keyService.generateKey(request,requestId);
        return ResponseEntity.ok(response);
    }
    @Override
    public ResponseEntity<?> storeGeneratedKey(@RequestBody keySaveRequest keyRequest,@RequestHeader(value = "X-Request-ID", required = true)  String requestId) {
        if (keyRequest == null ) {
            throw new IllegalArgumentException("Request cannot be empty");
        } else if (keyRequest.getNumeroIdentificacion().isEmpty()) {
            throw new Exception("El numero de identificacion es obligatorio");
        }
        keySaveResponse response = (keySaveResponse) keyService.storeKey(keyRequest,requestId);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<KeyCancelResponse> cancelKey(@RequestBody KeyCancelRequest request, String requestId){
        if (request == null ) {
            throw new IllegalArgumentException("Request cannot be empty");
        } else if (request.getNumeroIdentificacion().isEmpty() || request.getNumeroIdentificacion() == null) {
            throw new Exception("El numero de identificacion es obligatorio");
        }
        KeyCancelResponse keyCancelResponse = (KeyCancelResponse) keyService.cancelKey(request);
        if ("100".equals(keyCancelResponse.getCodigo())) {
            throw new BusinessException(206,keyCancelResponse.getMessage());
        }
        return ResponseEntity.ok(keyCancelResponse);
    }

    @Override
    public ResponseEntity<MDMResponseFormat> processMDM(MDMRequest request, String requestId) {
        MDMResponseFormat response = MDMService.processMDMData(request, requestId);
        return ResponseEntity.ok(response);

    }
}