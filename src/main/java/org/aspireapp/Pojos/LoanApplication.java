package org.aspireapp.Pojos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanApplication {
    @JsonProperty("customer")
    private Customer customer;
    @JsonProperty("loanId")
    private int loanId;

    @JsonProperty("amount")
    private double amount;
    @JsonProperty("termInMonths")
    private int termInMonths;

    @JsonProperty("startDate")
    private LocalDate startDate;

    public LoanApplication( @JsonProperty("customer")Customer customer,
                            @JsonProperty("loanId")int loanId, @JsonProperty("amount")double amount,
                            @JsonProperty("termInMonths")int termInMonths, @JsonProperty("startDate")LocalDate startDate) {
        this.customer = customer;
        this.loanId = loanId;
        this.amount = amount;
        this.termInMonths = termInMonths;
        this.startDate = startDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTermInMonths() {
        return termInMonths;
    }

    public void setTermInMonths(int termInMonths) {
        this.termInMonths = termInMonths;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public boolean isValid() {
        return customer != null && amount > 0 && termInMonths > 0 && startDate != null;
    }
}
