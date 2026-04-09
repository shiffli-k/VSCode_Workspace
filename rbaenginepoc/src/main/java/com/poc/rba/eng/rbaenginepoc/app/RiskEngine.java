package com.poc.rba.eng.rbaenginepoc.app;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class RiskEngine {

    public String calculateRisk(TranRecord current, List<TranRecord> history) {
        double amountScore = calculateAmountScore(current, history);
        double locationScore = calculateLocationScore(current, history);
        double velocityScore = calculateVelocityScore(current, history);
        double deviceScore = calculateDeviceScore(current, history);
        double merchantScore = calculateMerchantScore(current, history);

        double finalScore = 
                (amountScore * 0.30) +
                (locationScore * 0.25) +
                (velocityScore * 0.20) +
                (deviceScore * 0.15) +
                (merchantScore * 0.10);

        // System.out.println("Score is: " + finalScore);
        return String.valueOf(finalScore);
    }

    // The Amount Risk Score ((currentAmt-Average)/StandatdDeviation)
    private double calculateAmountScore(TranRecord current, List<TranRecord> history) {
        if (history.isEmpty())
            return 0;

        double avg = history.stream()
                .map(TranRecord::getPurchaseAmount)
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .orElse(0);

        double variance = history.stream()
                .map(TranRecord::getPurchaseAmount)
                .mapToDouble(a -> Math.pow(a.doubleValue() - avg, 2))
                .average()
                .orElse(0);

        double stdDev = Math.sqrt(variance);

        if (stdDev == 0)
            return 0;

        double z = (current.getPurchaseAmount().doubleValue() - avg) / stdDev;

        double score = Math.min(Math.abs(z) * 20, 100);
        return score;
    }

    private int calculateLocationScore(TranRecord current, List<TranRecord> history) {
        Set<String> knownIps = history.stream()
                .map(TranRecord::getIpAddress)
                .collect(Collectors.toSet());

        return knownIps.contains(current.getIpAddress()) ? 0 : 100;
    }

    private long calculateVelocityScore(TranRecord current, List<TranRecord> history) {
        LocalDateTime now = current.getTransactionDatetime();

        long count = history.stream()
                .filter(t -> t.getTransactionDatetime().isAfter(now.minusMinutes(5)))
                .count();

        return Math.min(count * 20, 100);
    }

    private int calculateDeviceScore(TranRecord current, List<TranRecord> history) {
        Set<String> knownDevices = history.stream()
                .map(TranRecord::getBrowserAgent)
                .collect(Collectors.toSet());

        return knownDevices.contains(current.getBrowserAgent()) ? 0 : 100;
    }

    private int calculateMerchantScore(TranRecord current, List<TranRecord> history) {
        Set<String> knownMerchants = history.stream()
                .map(TranRecord::getMerchantName)
                .collect(Collectors.toSet());

        return knownMerchants.contains(current.getMerchantName()) ? 0 : 100;
    }

    public static void main(String[] args) {

        TranRecord currentData = new TranRecord();
        currentData.setId(1L);
        currentData.setCardNumber("4111111111111111");
        currentData.setPurchaseAmount(BigDecimal.valueOf(9250.00));
        currentData.setMerchantName("AliExpress");
        currentData.setIpAddress("109.37.12.101");
        currentData.setBrowserAgent("Tor-Agent");
        currentData.setTransactionDatetime(LocalDateTime.now());
        // currentData.setPurchaseCurrency("INR");



        List<TranRecord> histData = new DatabaseService().getAllTransactionsForCard("4111111111111111");


        new RiskEngine().calculateRisk(currentData, histData);
    
    }
}
