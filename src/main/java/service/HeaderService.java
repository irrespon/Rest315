package service;

import org.springframework.http.HttpHeaders;

public interface HeaderService {
    void setAccept(HttpHeaders headers);
    void setContentType(HttpHeaders headers);
    void set(HttpHeaders headers, HttpHeaders headersResp);
}
