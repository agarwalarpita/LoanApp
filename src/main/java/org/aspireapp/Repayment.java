package org.aspireapp;
import java.time.LocalDate;

public class Repayment {
    private Double amount;
    private LocalDate dueDate;
    private Loan loan;
    private RepaymentStatus status;

    public Repayment(Double amount, LocalDate dueDate, Loan loan) {
        this.amount = amount;
        this.dueDate = dueDate;
        this.loan = loan;
        this.status = RepaymentStatus.PENDING;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Loan getLoan() {
        return loan;
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

