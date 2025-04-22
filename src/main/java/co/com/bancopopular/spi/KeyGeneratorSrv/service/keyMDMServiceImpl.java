package co.com.bancopopular.spi.KeyGeneratorSrv.service;

import co.com.bancopopular.spi.KeyGeneratorSrv.dto.*;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.BusinessException;
import co.com.bancopopular.spi.KeyGeneratorSrv.util.InternalServerException;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class keyMDMServiceImpl implements KeyMDMService {

    static final Map<String, Integer> SOURCE_PRIORITY = Map.of(
            "1020001", 1, // CRM-PS
            "1020074", 2, // ADL-PB
            "1000002", 3  // CRM-Siebel
    );

    private static final Map<String, Integer> PHONE_PRIORITY = Map.of(
            "1100007", 1, // celular seguro
            "1100005", 2, // celular personal
            "1100009", 3, // celular contacto
            "1100006", 4  // celular corporativo
    );

    private static final Map<String, Integer> EMAIL_PRIORITY = Map.of(
            "1200003", 1, // Email seguro
            "1200002", 2, // Email personal2
            "1200001", 3, // Email personal1
            "1200009", 4, // Email notificación
            "1200008", 5  // Email contacto
    );

    @Override
    public MDMResponseFormat processMDMData(MDMRequest tramaMDM, String requestId) throws BusinessException, InternalServerException {
        try {
            String TramaMDM = tramaMDM.getTramaMDM().replace("\n", "").replace("\r", "").trim();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(TramaMDM.getBytes(StandardCharsets.UTF_8)));

            NodeList partyAssociations = doc.getElementsByTagName("XPartyAssociationBObj");

            List<MDMContacto> allCelulares = new ArrayList<>();
            List<MDMContacto> allCorreos = new ArrayList<>();

            for (int i = 0; i < partyAssociations.getLength(); i++) {
                Node partyNode = partyAssociations.item(i);
                try {
                    MDMContactInfo contactInfo = extractContactInformation(partyNode);
                    allCelulares.addAll(contactInfo.getCelulares());
                    allCorreos.addAll(contactInfo.getCorreos());
                } catch (BusinessException ex) {
                    // Ignorar nodos sin contactos válidos
                }
            }

            if (allCelulares.isEmpty() && allCorreos.isEmpty()) {
                throw new BusinessException(206, "No se encontró información de contacto en ningún nodo XPartyAssociationBObj.");
            }

            MsgHdrResponse header = new MsgHdrResponse();
            header.setRequestId(requestId);
            header.setMensajeRespuesta("Operación completada exitosamente");
            header.setCodigoRespuesta(200);

            MDMResponse body = new MDMResponse(allCelulares, allCorreos);
            return new MDMResponseFormat(header, body);

        } catch (Exception e) {
            throw new BusinessException(206, "Error interno procesando la trama MDM: " + e.getMessage());
        }
    }

    private MDMContactInfo extractContactInformation(Node party) throws BusinessException {
        NodeList contactMethods = ((Element) party).getElementsByTagName("TCRMPartyContactMethodBObj");
        List<MDMContacto> celularesList = new ArrayList<>();
        List<MDMContacto> correosList = new ArrayList<>();

        for (int i = 0; i < contactMethods.getLength(); i++) {
            Element contactMethod = (Element) contactMethods.item(i);
            String typeCode = getTagValue("ContactMethodUsageType", contactMethod);
            String typeValue = getTagValue("ContactMethodUsageValue", contactMethod);
            String value = getTagValue("ReferenceNumber", contactMethod);
            String endDate = getTagValue("EndDate", contactMethod);

            if (endDate != null && !endDate.isEmpty()) {
                continue;
            }

            if (PHONE_PRIORITY.containsKey(typeCode)) {
                celularesList.add(new MDMContacto(typeValue, value));
            }

            if (EMAIL_PRIORITY.containsKey(typeCode)) {
                correosList.add(new MDMContacto(typeValue, value));
            }
        }

        if (celularesList.isEmpty() && correosList.isEmpty()) {
            throw new BusinessException(206, "No se han encontrado registros de contacto válidos");
        }

        return new MDMContactInfo(celularesList, correosList);
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }
}
