package dk.ufst.bat.fuldmagtsStub.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FuldmagtError {
    private String type;
    private String kode;
    private String besked;
    private String data;
    private String status;
}
