package org.aspireapp.Pojos;

import org.aspireapp.Util.LoanStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Loan {
    private int id;
    private Double amount;
    private Integer term;
    private LocalDate requestDate;
    private List<Repayment> repayments;
    private LoanStatus status;
    private Customer customer;

    public Loan(LoanApplication loanApplication){
        this(loanApplication.getLoanId(), loanApplication.getAmount(), loanApplication.getTermInMonths(),
                    loanApplication.getStartDate(), loanApplication.getCustomer());

    }
    public Loan(int id,Double amount, Integer term, LocalDate requestDate, Customer customer) {
        this.id=id;
        this.amount = amount;
        this.term = term;
        this.requestDate = requestDate;
        this.status = LoanStatus.PENDING;
        this.repayments = new ArrayList<>();
        this.customer = customer;

        LocalDate dueDate = requestDate.plusWeeks(1);
        Double weeklyPayment = amount / term;
        for (int i = 1; i <= term; i++) {
            if (i == term) {
                repayments.add(new Repayment(amount - (weeklyPayment * (term - 1)), dueDate));
            } else {
                repayments.add(new Repayment(weeklyPayment, dueDate));
            }
            dueDate = dueDate.plusWeeks(1);
        }
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getTerm() {
        return term;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public List<Repayment> getRepayments() {
        return repayments;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }
}

