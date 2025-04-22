package co.com.bancopopular.spi.KeyGeneratorSrv.service;

import co.com.bancopopular.spi.KeyGeneratorSrv.dto.*;

public interface KeyGenerationService {


    Object generateKey(KeyGenerationRequest request , String requestId);
    Object storeKey(keySaveRequest keyRequest, String requestId);
    KeyCancelResponse cancelKey(KeyCancelRequest request) ;
}