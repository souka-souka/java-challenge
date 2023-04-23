package jp.co.axa.apidemo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiException extends RuntimeException {
    private Integer code;
    private String msg;
}
