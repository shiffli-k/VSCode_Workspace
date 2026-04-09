package com.poc.rba.eng.rbaenginepoc.app;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TranRecord {
    private Long id;
    private String cardNumber;
    private BigDecimal purchaseAmount;
    private String merchantName;
    private String purchaseCurrency;
    private String ipAddress;
    private String browserAgent;
    private LocalDateTime transactionDatetime;
    private String status;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }
    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
    public String getMerchantName() {
        return merchantName;
    }
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
    public String getPurchaseCurrency() {
        return purchaseCurrency;
    }
    public void setPurchaseCurrency(String purchaseCurrency) {
        this.purchaseCurrency = purchaseCurrency;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public String getBrowserAgent() {
        return browserAgent;
    }
    public void setBrowserAgent(String browserAgent) {
        this.browserAgent = browserAgent;
    }
    public LocalDateTime getTransactionDatetime() {
        return transactionDatetime;
    }
    public void setTransactionDatetime(LocalDateTime transactionDatetime) {
        this.transactionDatetime = transactionDatetime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}

