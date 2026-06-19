package com.backtobasics.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TemplateParser {

    private static Map<String, String> DLT_MAP = new HashMap<>();
    static {
        DLT_MAP.put(
                "You have reached the max ATM limit during the 24hr cooling period after 1st PIN set on card {#var#}. Post cooling period full limit will be enabled-Ujjivan SFB",
                "1707177185002963294");
        DLT_MAP.put(
                "Your Card No. ending {#var#} is locked due to Incorrect PIN attempts exceeded. Reset pin through App or Ujjivan ATM. Call 18002082121-Ujjivan SFB",
                "1707173081344800293");
        DLT_MAP.put(
                "Your Transaction on card {#var#} was declined due to Incorrect PIN. Last attempt remaining. Reset pin through App or Ujjivan ATM. Call 18002082121-Ujjivan SFB",
                "1707173081306414928");
        DLT_MAP.put(
                "Your Transaction on card {#var#} was declined due to Incorrect PIN. Only 2 attempts remaining. Reset pin through App or Ujjivan ATM. Call 18002082121-Ujjivan SFB",
                "1707173081206422137");
        DLT_MAP.put(
                "Your transaction on Card No.{#var#}is declined due to card limit. Kindly refer Manage card feature in Ujjivan SFB Mobile App or call 18002082121 - Ujjivan SFB",
                "1707160447216017660");
        DLT_MAP.put(
                "Your last transaction with Card No. ending {#var#} on {#var#} is declined due to Card Settings/Status. Kindly visit nearest branch or call 18002082121.Ujjivan SFB",
                "1707172042347553803");
        DLT_MAP.put(
                "Your request to Un-BLOCK the Card No.ending {#var#} on {#var#} is declined due to Card Settings/Status. Kindly visit nearest branch or call 18002082121.Ujjivan SFB",
                "1707172042342873739");
        DLT_MAP.put(
                "Your request to BLOCK the Card No. ending {#var#} on {#var#} is declined due to Card Settings/Status. Kindly visit nearest branch or call 18002082121.Ujjivan SFB",
                "1707172042337483963");
        DLT_MAP.put(
                "ATM transactions for your Card ending {#var#} is Blocked on {#var#} {#var#} . You can modify it any time or call 18002082121 - Ujjivan SFB",
                "1707173011978170533");
        DLT_MAP.put(
                "Online transactions for Card {#var#} is Un-blocked & limit set as Rs.{#var#} on {#var#} {#var#} .Manage the card any time or call 18002082121 - Ujjivan SFB",
                "1707160447232980348");
        DLT_MAP.put(
                "ATM transactions for Card {#var#} is Un-blocked & limit set as Rs.{#var#} on {#var#} {#var#}. You can modify it any time or call 18002082121-Ujjivan SFB",
                "1707160447242965507");
        DLT_MAP.put(
                "POS transactions for Card {#var#} is Un-blocked & limit set as Rs.{#var#} on {#var#} {#var#} . Manage the card any time or Call 18002082121- Ujjivan SFB",
                "1707160447238114368");
        DLT_MAP.put(
                "POS transactions for your Card ending {#var#} is Blocked on {#var#} . You can modify it any time or call 18002082121- Ujjivan SFB",
                "1707160447235630065");
        DLT_MAP.put(
                "Online transactions for your Card ending {#var#} is Blocked on {#var#} as per request. You can modify it any time or Call 18002082121-Ujjivan SFB",
                "1707160447225719616");
        DLT_MAP.put(
                "Dear Customer, Card no ending {#var#} is Blocked on {#var#} as per request. Use Mobile App to change the settings or Call 18002082121 - Ujjivan SFB",
                "1707160447196056245");
        DLT_MAP.put(
                "Dear Customer, Card no ending {#var#} is Unblocked on {#var#} as per request. Use Mobile App to change the settings or Call 18002082121 - Ujjivan SFB",
                "1707160447211840750");
        DLT_MAP.put(
                "Intl ATM transactions for Card {#var#} is Un-blocked & limit set as Rs.{#var#} on {#var#}. You can modify it any time or call 18002082121-Ujjivan SFB",
                "1707164648723906998");
        DLT_MAP.put(
                "Intl ATM transactions for your Card ending {#var#} is Blocked on {#var#} . You can modify it any time or call 18002082121 - Ujjivan SFB",
                "1707164648714331041");
        DLT_MAP.put(
                "Intl POS transactions for Card {#var#} is Un-blocked & limit set as Rs.{#var#} on {#var#} . Manage the card any time or Call 18002082121- Ujjivan SFB",
                "1707164648705198164");
        DLT_MAP.put(
                "Intl POS transactions for your Card ending {#var#} is Blocked on {#var#} . You can modify it any time or call 18002082121- Ujjivan SFB",
                "1707164648129864679");
        DLT_MAP.put(
                "Intl Online trxn for Card {#var#} is Un-blocked & limit set as Rs.{#var#} on {#var#} .Manage the card any time or call 18002082121 - Ujjivan SFB",
                "1707164647877202186");
        DLT_MAP.put(
                "Intl Online transactions for your Card ending {#var#} is Blocked on {#var#} as per request. You can modify it any time or Call 18002082121-Ujjivan SFB",
                "1707164647871174619");
        DLT_MAP.put(
                "Intl contactless trxn for Card {#var#} is Un-blocked & limit set as Rs.{#var#} on {#var#}. You can modify it any time or call 18002082121-Ujjivan SFB",
                "1707164647866665644");
        DLT_MAP.put(
                "Intl contactless transaction on card ending {#var#} is Blocked as per request. Use Mobile App to change the settings or Call 18002082121 - Ujjivan SFB",
                "1707164647862970072");
        DLT_MAP.put(
                "Contactless trxn for Card {#var#} is Un-blocked & limit set as Rs.{#var#} on {#var#}. You can modify it any time or call 18002082121-Ujjivan SFB",
                "1707164647839775969");
        DLT_MAP.put(
                "Contactless transaction on card ending {#var#} is Blocked as per request. Use Mobile App to change the settings or Call 18002082121 - Ujjivan SFB",
                "1707164647827864640");
        DLT_MAP.put(
                "Trxn on card ending {#var#} is declined as contactless trxn is not enabled. Kindly refer Manage card feature in Mobile App or call 18002082121 - Ujjivan SFB",
                "1707164647805946852");
        DLT_MAP.put(
                "Trxn on card ending {#var#} is declined as Intl trxn is not enabled. Kindly refer Manage card feature in Mobile App or call 18002082121 - Ujjivan SFB",
                "1707164647800608148");
        DLT_MAP.put(
                "A/C {#var#} will be charged Rs {#var#} plus GST for the ATM transaction declined due to Insufficient fund. Pls call 18002082121 for any queries. Ujjivan SFB",
                "1707166264268646831");

    }

    public static void main(String[] args) {
        String original = "POS transactions for Card 1035 is Un-blocked & limit set as Rs.15000 on 04/06/2026 15:42 . Manage the card any time or call 18002082121- Ujjivan SFB";

        // for (String eachTemplate : DLT_MAP.keySet()) {
        //     if(Pattern.matches(eachTemplate.replace("{#var#}", ".*").toLowerCase(), original.toLowerCase())){
        //         System.out.println(
        //             "Template ID is " + 
        //             DLT_MAP.get(eachTemplate)
        //         );
        //     }
        // }


        System.out.println(
            Pattern.matches(
                "POS transactions for Card {#var#} is Un-blocked & limit set as Rs.{#var#} on {#var#} {#var#} . Manage the card any time or Call 18002082121- Ujjivan SFB"
                .toLowerCase()
                .replace("{#var#}", "\\S*").replace(".", "\\.")
                ,
                original.toLowerCase()
            )
        );

        System.out.println(
            "POS transactions for Card {#var#} is Un-blocked & limit set as Rs.{#var#} on {#var#} {#var#} . Manage the card any time or Call 18002082121- Ujjivan SFB"
                .toLowerCase()
                .replace("{#var#}", "\\S*").replace(".", "\\.")
            + "\n" +
            original.toLowerCase()
        );
    }
}
