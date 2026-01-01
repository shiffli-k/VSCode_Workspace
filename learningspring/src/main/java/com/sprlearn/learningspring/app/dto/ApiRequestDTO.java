package com.sprlearn.learningspring.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// import jakarta.val

public class ApiRequestDTO {

    @NotEmpty(message = "Bruh, why is RequestID null!")
    @Size(max = 1, message = "Too Large Mate!")
    private String requestId;

    @Size(max = 3, message = "Invalid Data Length")
    private String requestData;


    public String getRequestId() {
        return requestId;
    }
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    public String getRequestData() {
        return requestData;
    }
    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }
    
}
