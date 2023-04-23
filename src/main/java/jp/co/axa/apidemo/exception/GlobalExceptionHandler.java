package jp.co.axa.apidemo.exception;

import jp.co.axa.apidemo.common.MsgEnum;
import jp.co.axa.apidemo.common.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBody error(Exception e) {
        log.error("UNKNOWN EXCEPTION!Reason:",e);
        return ResultBody.error().message(MsgEnum.SYSTEM_ERROR.getMsg());
    }

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public ResultBody error(ApiException e) {
        log.error(e.getMessage());
        return ResultBody.error().code(e.getCode()).message(e.getMsg());
    }

}
