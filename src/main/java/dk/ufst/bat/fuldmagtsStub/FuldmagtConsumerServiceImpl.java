package dk.ufst.bat.fuldmagtsStub;

import org.springframework.web.client.RestTemplate;

public class FuldmagtConsumerServiceImpl {
    private final RestTemplate restTemplate;

    public FuldmagtConsumerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
