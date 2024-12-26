package co.com.bancopopular.spi.KeyGeneratorSrv.service;

import co.com.bancopopular.spi.KeyGeneratorSrv.dto.*;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.BusinessException;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.Exception;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.InternalServerException;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.KeyGenerationUtil;
import co.com.bancopopular.spi.KeyGeneratorSrv.entity.LlaveSpi;
import co.com.bancopopular.spi.KeyGeneratorSrv.repository.LlaveSpiRepository;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class KeyGenerationServiceImpl implements KeyGenerationService {

    private final LlaveSpiRepository repository;

    public KeyGenerationServiceImpl(LlaveSpiRepository repository) {
        this.repository = repository;
    }

    @Override
        public KeyGenerationResponse generateKey(KeyGenerationRequest request) {

        if (request == null || request.getNumeroIdentificacion() == null) {
            throw new NotFoundException("Número de identificación no proporcionado");
        }
            String baseKey = KeyGenerationUtil.generateBaseKey(request);
            String finalKey = baseKey;

            int consecutive = 0;

            while (repository.existsByNumeroLlave(finalKey)) {
                consecutive++;
                finalKey = baseKey + String.format("%02d", consecutive);

            }

        MsgHdrResponse header = new MsgHdrResponse();
        BodyResponse body = new BodyResponse();
        KeyGenerationResponse response = new KeyGenerationResponse();
        ErrorResponseDTO error = new ErrorResponseDTO();

        //LlaveSpi llave = getLlaveSpi(request, finalKey);
        //repository.save(llave);

        Optional<LlaveSpi> llaveOpt = repository.findByNumeroIdentificacion(request.getNumeroIdentificacion());
        if (llaveOpt.isEmpty()) {
            throw new NotFoundException("No se encontró la llave con el número de identificación proporcionado");
        }

        if (llaveOpt.isPresent()){
            LlaveSpi llave = llaveOpt.get();
            if (llave.getEstadoDeLlave().equals("INACTIVA")) {
                throw new BusinessException("La llave se encuentra inactiva");
            }

            header.setRequestId(request.getRequestId());
            header.setMensajeRespuesta("Operación completada exitosamente");
            header.setCodigoRespuesta(200);

            body.setLlaveGenerada(finalKey);
            body.setAccion(llave.getAccion());
            body.setNombreDeArchivo(llave.getNombreDeArchivo());
            body.setNumeroLineaDeRegistro(llave.getNumeroLineaDeRegistro());
            body.setEstadoLlaveBanco(llave.getEstadoDeLlave());
            body.setTipoLlave(llave.getTipoLlave());
            body.setNumeroLlave(llave.getNumeroLlave());
            body.setTipoIdentificacion(llave.getTipoIdentificacion());
            body.setNumeroIdentificacion(llave.getNumeroIdentificacion());
            body.setNombrePersonaJuridica(llave.getNombrePersonaJuridica());
            body.setPrimerNombre(llave.getPrimerNombrePn());
            body.setSegundoNombre(llave.getSegundoNombrePn());
            body.setPrimerApellido(llave.getPrimerApellidoPn());
            body.setSegundoApellido(llave.getSegundoApellidoPn());
            body.setNitEntidadEmisora(llave.getNitEntidadEmisora());
            body.setTipoMedioDePago(llave.getTipoMedioDePago());
            body.setNumeroMedioDePago(llave.getNumeroMedioDePago());
            body.setFechaCreacion(LocalDateTime.now());
            body.setFechaModificacion(llave.getFechaModificacion());
            body.setEstadoLlave(llave.getEstadoDeLlave());
            body.setCodigoBancoAval(llave.getCodigoBancoAval());
            body.setLlaveFavorita(llave.getLlaveFavorita());
        }
        response.setMsgHdrResponse(header);
        response.setBody(body);
        return response;
        }

    public keySaveResponse storeKey(keySaveRequest request, String requestId) {

        Optional<LlaveSpi> llaveOpt = repository.findByNumeroIdentificacion(request.getNumeroIdentificacion());
        if (llaveOpt.isEmpty()) {
            throw new NotFoundException("No se encontró la llave con el número de identificación proporcionado");
        }

        MsgHdrResponse header = new MsgHdrResponse();
        header.setRequestId(requestId);
        header.setMensajeRespuesta("Operación completada exitosamente");
        header.setCodigoRespuesta(200);

        keySaveResponse response = new keySaveResponse();
        response.setMsgHdrResponse(header);

        if (request.getNumeroLlave() == null) {
            throw new BusinessException("No se puede almacenar una llave vacía");
        } else if (request.getNumeroIdentificacion() == null) {
            throw new Exception("Numero de identificacion no proporcionado");
        }
        repository.updateNumeroLlaveByNumeroIdentificacion(request.getNumeroLlave(),request.getNumeroIdentificacion());
        return response;
    }

}