package service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeadServiceImpl implements HeaderService{
    @Override
    public void setAccept(HttpHeaders headers) {
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
    }

    @Override
    public void setContentType(HttpHeaders headers) {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Override
    public void set(HttpHeaders headers, HttpHeaders headersResp) {
        List<String> cookie = headersResp.get("set-cookie");
        headers.set("Cookie",cookie.stream().collect(Collectors.joining(";")));
    }
}
