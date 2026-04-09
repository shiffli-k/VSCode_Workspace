package com.poc.rba.eng.rbaenginepoc.app;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class RbaRequestHandler {

    @Autowired
    private DatabaseService dbs;

    @Autowired
    private RiskEngine riskEngine;

    @GetMapping("/")
    public String healthScheck() {
        return new String("Up and Running");
    }
    

    @GetMapping("/fetchScore")
    public List<TranRecord> fetScoreHandler(@RequestParam(value = "card") String cardToFetch) {
        return dbs.getAllTransactionsForCard(cardToFetch);
    }

    @PostMapping("/generateRiskForTran")
    public String generateRiskScoreForTranDetails(@RequestBody TranRecord currentTranRecord) {
        String cardNumber = currentTranRecord.getCardNumber();
        
        List<TranRecord> historicRecordForCard = dbs.getAllTransactionsForCard(cardNumber);

        String riskScore = riskEngine.calculateRisk(currentTranRecord, historicRecordForCard);
        
        return "Engine Returned Score of: " + riskScore;
    }
    


    
}
