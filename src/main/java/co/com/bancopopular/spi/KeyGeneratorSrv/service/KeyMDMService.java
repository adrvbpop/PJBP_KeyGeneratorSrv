package co.com.bancopopular.spi.KeyGeneratorSrv.service;

import co.com.bancopopular.spi.KeyGeneratorSrv.dto.MDMRequest;
import co.com.bancopopular.spi.KeyGeneratorSrv.dto.MDMResponseFormat;

public interface KeyMDMService {
    MDMResponseFormat processMDMData(MDMRequest request, String requestId);
}
