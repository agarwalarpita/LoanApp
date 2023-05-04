package org.aspireapp;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Repayment {
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("dueDate")
    private LocalDate dueDate;
    @JsonProperty("status")
    private RepaymentStatus status;

    @JsonCreator
    public Repayment(@JsonProperty("amount")Double amount, @JsonProperty("dueDate")LocalDate dueDate) {
        this.amount = amount;
        this.dueDate = dueDate;
        this.status = RepaymentStatus.PENDING;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public RepaymentStatus getStatus() {
        return status;
    }

    public void setStatus(RepaymentStatus status) {
        this.status = status;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

