package dk.ufst.bat.fuldmagtsStub.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Virksomhed {
    private String virkesomhedCVRNummer;
    private String virksomhedNavnFirmaNavn;
}
