package jp.co.axa.apidemo.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ResultBody {

    @ApiModelProperty(value = "succeedFlag")
    private Boolean success;

    @ApiModelProperty(value = "return code")
    private Integer code;

    @ApiModelProperty(value = "message")
    private String message;

    @ApiModelProperty(value = "message list")
    private List<String> messageList;

    @ApiModelProperty(value = "data")
    private Map<String, Object> data = new HashMap<String, Object>();

    private ResultBody() {}

    public static ResultBody ok() {
        ResultBody resultBody = new ResultBody();
        resultBody.setSuccess(true);
        resultBody.setCode(MsgEnum.SUCCESS.getCode());
        resultBody.setMessage(MsgEnum.SUCCESS.getMsg());
        return resultBody;
    }

    public static ResultBody error() {
        ResultBody resultBody = new ResultBody();
        resultBody.setSuccess(false);
        resultBody.setCode(MsgEnum.ERROR.getCode());
        resultBody.setMessage(MsgEnum.ERROR.getMsg());
        return resultBody;
    }

    public ResultBody success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public ResultBody message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultBody messageList(List<String> messageList){
        this.setMessageList(messageList);
        return this;
    }

    public ResultBody code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultBody data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ResultBody data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
