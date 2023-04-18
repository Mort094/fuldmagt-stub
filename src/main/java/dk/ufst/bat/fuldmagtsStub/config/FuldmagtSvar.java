package dk.ufst.bat.fuldmagtsStub.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FuldmagtSvar {

    private String transaktionIdentifikator;
    private Fuldmagt fuldmagt;
}
