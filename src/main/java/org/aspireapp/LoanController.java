package org.aspireapp;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoanController {

    private final LoanService loanService = new LoanService(new LoanRepository());
    private final CustomerService customerService = new CustomerService( new CustomerRepository());

    @GetMapping("/loans/{customerId}")
    public List<Loan> getAllLoans(@PathVariable("customerId") int customerId) {
        System.out.println("HEY");
        return loanService.getLoansByCustomer(customerId);
    }

    @GetMapping("/loans/{loanId}/{customerId}")
    public Loan getLoanById(@PathVariable("loanId") int loanId, @PathVariable("customerId") int customerId) {
       return loanService.getLoanById(loanId, customerId);

    }

    @PostMapping("/loans")
    public void createLoan(@RequestBody LoanApplication loanApplication) {
         loanService.createLoan(loanApplication);

    }

    @PutMapping("/loans/{loanId}")
    public void updateLoan(@PathVariable("loanId") int loanId, Loan loan) {
        loanService.updateLoan(loan);
    }

    @PostMapping("/loans/{loanId}/repayments/{amount}/{customerId}")
    public Repayment createRepayment(@PathVariable("loanId") int loanId, @PathVariable("amount") double amount,
                                    @PathVariable("customerId") int customerId) {
        return loanService.addRepayment(loanId, amount, customerId);

    }
}
