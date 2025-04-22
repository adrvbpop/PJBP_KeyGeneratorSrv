package co.com.bancopopular.spi.KeyGeneratorSrv.service;

import co.com.bancopopular.spi.KeyGeneratorSrv.dto.*;
import co.com.bancopopular.spi.KeyGeneratorSrv.entity.LlaveSpi;
import co.com.bancopopular.spi.KeyGeneratorSrv.repository.LlaveSpiRepository;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.*;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.BusinessException;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.Exception;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.KeyGenerationUtil;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Optional;

import static co.com.bancopopular.spi.KeyGeneratorSrv.util.KeyGenerationUtil.formatFecha;
import static co.com.bancopopular.spi.KeyGeneratorSrv.util.KeyGenerationUtil.generateBaseKey;

@Service
public class KeyGenerationServiceImpl implements KeyGenerationService {

    private final LlaveSpiRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(KeyGenerationServiceImpl.class);
    public KeyGenerationServiceImpl(LlaveSpiRepository repository) {
        this.repository = repository;
    }

    private String generateUniqueKey(KeyGenerationRequest request) {
        String baseKey = KeyGenerationUtil.generateBaseKey(request);
        String finalKey = baseKey;
        int consecutive = 0;

        while (repository.existsByNumeroLlave(finalKey)) {
            consecutive++;
            finalKey = baseKey + String.format("%02d", consecutive); // ejemplo: @BPABC12301
        }

        return finalKey;
    }

    @Override
    public KeyGenerationResponse generateKey(KeyGenerationRequest request, String requestId) {

        if (request == null || request.getNumeroIdentificacion() == null) {
            throw new NotFoundException("Número de identificación no proporcionado");
        } else if (request.getPrimerNombre() == null) {
            throw new NotFoundException("Primer nombre no proporcionado");
        } else if (request.getPrimerApellido() == null) {
            throw new NotFoundException("Primer apellido no proporcionado");
        } else if (request.getNumeroMediodePago() == null) {
            throw new NotFoundException("Numero de cuenta no proporcionado");
        }

        String finalKey = generateUniqueKey(request);

        MsgHdrResponse header = new MsgHdrResponse();
        BodyResponse body = new BodyResponse();
        KeyGenerationResponse response = new KeyGenerationResponse();

        header.setRequestId(requestId);
        header.setMensajeRespuesta("Operación completada exitosamente");
        header.setCodigoRespuesta(200);
        body.setLlaveGenerada(finalKey);

        response.setMsgHdrResponse(header);
        response.setBody(body);
        return response;
    }

    public keySaveResponse storeKey(keySaveRequest request, String requestId) {

        if (request.getNumeroLlave() == null) {
            throw new BusinessException(206, "No se puede almacenar una llave vacía");
        } else if (request.getNumeroIdentificacion() == null) {
            throw new BusinessException(206, "Número de identificación no proporcionado");
        }

        // Validar si la llave ya existe en la base de datos
        if (repository.existsByNumeroLlave(request.getNumeroLlave())) {
            throw new BusinessException(206, "La llave ya se encuentra asociada a una cuenta");
        }

        // Si no existe, continuar con el guardado
        LlaveSpi repSave = new LlaveSpi();
        repSave.setTipoLlave(request.getTipoLlave());
        repSave.setNumeroLlave(request.getNumeroLlave());
        repSave.setTipoIdentificacion(request.getTipoIdentificacion());
        repSave.setNumeroIdentificacion(request.getNumeroIdentificacion());
        repSave.setTipoDePersona(request.getTipoDePersona());
        repSave.setPrimerNombrePn(request.getPrimerNombre());
        repSave.setSegundoNombrePn(request.getSegundoNombre());
        repSave.setPrimerApellidoPn(request.getPrimerApellido());
        repSave.setSegundoApellidoPn(request.getSegundoApellido());
        repSave.setNitEntidadEmisora(request.getNitEntidadEmisora());
        repSave.setTipoMedioDePago(request.getTipoMedioDePago());
        repSave.setNumeroMedioDePago(request.getNumeroMedioDePago());
        repSave.setFechaCreacion(formatFecha(request.getFechaCreacion()));
        repSave.setFechaModificacion(formatFecha(request.getFechaModificacion()));
        repSave.setEstadoDeLlave(request.getEstadoLlave());
        repSave.setCodigoBancoAval(request.getCodigoBancoAval());
        repSave.setLlaveFavorita(request.getLlaveFavorita());
        repSave.setAccion(request.getAccion());

        repository.save(repSave);

        MsgHdrResponse header = new MsgHdrResponse();
        header.setRequestId(requestId);
        header.setMensajeRespuesta("Operación completada exitosamente");
        header.setCodigoRespuesta(200);

        keySaveResponse response = new keySaveResponse();
        response.setMsgHdrResponse(header);

        return response;
    }


    @Transactional
    public KeyCancelResponse cancelKey(KeyCancelRequest request) {
        logger.info("cancelación llave TagAval");
        KeyCancelResponse response = new KeyCancelResponse();
        try {
            Optional<LlaveSpi> keyAval = repository.findBynumeroIdentificacionAndTipoIdentificacionAndNumeroMedioDePago(
                    request.getNumeroIdentificacion(),
                    request.getTipoIdentificacion(),
                    request.getNumeroCuenta());
            response.setCodigo("200");
            if(!keyAval.isEmpty()) {
                if (keyAval.get().getNumeroLlave().equals(request.getLlaveTagAval())) {
                    repository.deleteByNumeroLlave(keyAval.get().getNumeroLlave());
                    response.setMessage("Se elimina llave actual - Operación completada exitosamente");
                }else {
                    if(!repository.existsByNumeroLlave(request.getLlaveTagAval())) {
                        LlaveSpi modelTagSpi = new LlaveSpi();
                        modelTagSpi = keyAval.get();
                        modelTagSpi.setNumeroLlave(request.getLlaveTagAval());
                        modelTagSpi.setFechaModificacion(new Date().toString());
                        this.repository.save(modelTagSpi);
                        response.setMessage("Se actualiza registro actual - Operación completada exitosamente");
                    }else {
                        response.setCodigo("100");
                        response.setMessage("No se actualiza registro actual,  llave ya existe - Operación cancelada");
                    }
                }
            }else {
                response.setCodigo("100");
                response.setMessage("No existen datos relacionados con llave informada- Operación cancelada");
            }
        }catch (Exception e) {
            logger.info("JAVA exception : {}", e);
            response.setCodigo("500");
            response.setMessage("Ha ocurrido una excepción JAVA :" + e);
            return response;
        }
        return response;
    }
}