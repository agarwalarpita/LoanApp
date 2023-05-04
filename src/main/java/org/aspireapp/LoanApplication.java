package org.aspireapp;

import java.time.LocalDate;

public class LoanApplication {
    private Customer customer;
    private int loanId;
    private double amount;
    private int termInMonths;
    private LocalDate startDate;

    public LoanApplication(Customer customer, int loanId, double amount, int termInMonths, LocalDate startDate) {
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
