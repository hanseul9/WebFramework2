package kr.ac.hansung.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private String errorCode;
    private String errorMsg;
    private String requestURI;
}
