package dk.ufst.bat.fuldmagtsStub.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FuldmagtData {

    private String type;
    private String id;
    private FuldmagtSvar attributes;
}
