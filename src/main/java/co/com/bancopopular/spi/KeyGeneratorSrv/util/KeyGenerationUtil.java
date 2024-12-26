package co.com.bancopopular.spi.KeyGeneratorSrv.util;

import co.com.bancopopular.spi.KeyGeneratorSrv.dto.KeyGenerationRequest;

public class KeyGenerationUtil {
    public static String generateBaseKey(KeyGenerationRequest request) {
        String initials = request.getPrimerNombre().substring(0, 1).toUpperCase() +
                request.getPrimerApellido().substring(0, 1).toUpperCase() +
                (request.getSegundoApellido() != null ? request.getSegundoApellido().substring(0, 1).toUpperCase() : request.getPrimerApellido().substring(0, 2).toUpperCase());

        String lastDigits = request.getNumeroIdentificacion().substring(request.getNumeroIdentificacion().length() - 3);
        return "@" + "BP" + initials + lastDigits;
    }
}
