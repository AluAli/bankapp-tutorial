package com.masu.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class Transaction {
    String id;
    float amount;
    Date date;
    String nameOfReceiverOrSender;
}
