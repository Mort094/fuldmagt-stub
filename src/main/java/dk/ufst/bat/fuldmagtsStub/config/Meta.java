package dk.ufst.bat.fuldmagtsStub.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Meta {
    private String operationId;
    private String tidspunkt;
    private String klassifikation;
}
