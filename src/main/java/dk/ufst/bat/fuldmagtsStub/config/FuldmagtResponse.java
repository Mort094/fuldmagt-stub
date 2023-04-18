package dk.ufst.bat.fuldmagtsStub.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuldmagtResponse {
    private List<Object> data;
    private Meta meta;
    private Links links;
}
