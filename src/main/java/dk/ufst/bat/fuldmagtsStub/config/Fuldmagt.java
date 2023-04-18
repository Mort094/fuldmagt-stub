package dk.ufst.bat.fuldmagtsStub.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fuldmagt {

    private String type;

    private String status;

    private String gyldigFra;

    private String gyldigTil;
}
