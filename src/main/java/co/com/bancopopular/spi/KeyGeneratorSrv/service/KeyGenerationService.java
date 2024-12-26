package co.com.bancopopular.spi.KeyGeneratorSrv.service;

import co.com.bancopopular.spi.KeyGeneratorSrv.dto.KeyGenerationRequest;
import co.com.bancopopular.spi.KeyGeneratorSrv.dto.keySaveRequest;
import jakarta.servlet.http.HttpServletRequest;

public interface KeyGenerationService {


    Object generateKey(KeyGenerationRequest request);
    Object storeKey(keySaveRequest keyRequest, String requestId);

}