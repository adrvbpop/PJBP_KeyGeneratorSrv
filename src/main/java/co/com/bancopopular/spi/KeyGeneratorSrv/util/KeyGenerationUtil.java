package co.com.bancopopular.spi.KeyGeneratorSrv.util;

import co.com.bancopopular.spi.KeyGeneratorSrv.dto.KeyGenerationRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class KeyGenerationUtil {
    public static String generateBaseKey(KeyGenerationRequest request) {
        String primerNombre = request.getPrimerNombre() != null ? request.getPrimerNombre() : "";
        String segundoNombre = request.getSegundoNombre();
        String primerApellido = request.getPrimerApellido() != null ? request.getPrimerApellido() : "";
        String segundoApellido = request.getSegundoApellido();
        String numeroIdentificacion = request.getNumeroIdentificacion() != null ? request.getNumeroIdentificacion() : "";

        // Iniciales nombre
        String inicialNombre = "";
        if (segundoNombre != null) {
            inicialNombre = primerNombre.substring(0, 1).toUpperCase();
        }else {
            inicialNombre = (primerNombre + "X").substring(0, 2).toUpperCase();
        }

        // Iniciales apellido
        String inicialApellido = "";
        if (segundoApellido != null && segundoApellido.length() >= 1) {
            inicialApellido = primerApellido.substring(0, 1).toUpperCase() + segundoApellido.substring(0, 1).toUpperCase();
        } else if (primerApellido.length() >= 2) {
            inicialApellido = primerApellido.substring(0, 2).toUpperCase();
        } else {
            inicialApellido = (primerApellido + "X").substring(0, 2).toUpperCase(); // fallback
        }

        // Últimos 3 dígitos de identificación
        String lastDigits = numeroIdentificacion.length() >= 3
                ? numeroIdentificacion.substring(numeroIdentificacion.length() - 3)
                : String.format("%03d", 0);

        return "@BP" + inicialNombre + inicialApellido + lastDigits;
    }

    public static String formatFecha(String fechaStr) {
        if (fechaStr == null || fechaStr.isEmpty()) {
            return null; // Retornar null si la fecha es nula o vacía
        }
        try { // Remover la "Z" si existe al final (para compatibilidad con ISO 8601)
            if (fechaStr.endsWith("Z")) { fechaStr = fechaStr.substring(0, fechaStr.length() - 1);
            }
            // Reemplazar "T" por un espacio (ejemplo: "2024-12-22T18:07:58.489" → "2024-12-22 18:07:58.489")
            fechaStr = fechaStr.replace("T", " ");
            if (fechaStr.length() > 23) {
                fechaStr = fechaStr.substring(0, 23);
            }

            // Intentar parsear la fecha con milisegundos
            DateTimeFormatter formatterConMillis = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime fecha = LocalDateTime.parse(fechaStr, formatterConMillis);
            return fecha.format(formatterConMillis);
        } catch (DateTimeParseException e1) {
            try {
                // Si falla, intentar parsear sin milisegundos
                DateTimeFormatter formatterSinMillis = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime fecha = LocalDateTime.parse(fechaStr, formatterSinMillis);
                return fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")); // Agrega ".000"
            } catch (DateTimeParseException e2) {
                // Si el formato no es compatible, devolver la fecha tal como viene
                return fechaStr;
            }
        }
    }
}
