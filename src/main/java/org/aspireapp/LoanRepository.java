package org.aspireapp;

import java.util.ArrayList;
import java.util.List;

public class LoanRepository {
    private static LoanRepository instance;
    private List<Loan> loans = new ArrayList<>();

    public LoanRepository() {}

    public static LoanRepository getInstance() {
        if (instance == null) {
            instance = new LoanRepository();
        }
        return instance;
    }

    public void saveLoan(Loan loan) {
        loans.add(loan);
    }

    public Loan getLoanById(int id) {
        for (Loan loan : loans) {
            if (loan.getId() == id) {
                return loan;
            }
        }
        return null;
    }

    public List<Loan> getLoanByCustomerId(int id) {
        List<Loan> loans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getCustomer().getId() == id) {
                loans.add(loan);
            }
        }
        return loans;
    }

    public List<Loan> getAllLoans() {
        return loans;
    }

    public void updateLoan(Loan loan) {
        for (int i = 0; i < loans.size(); i++) {
            if (loans.get(i).getId() == loan.getId()) {
                loans.set(i, loan);
                return;
            }
        }
    }

    public void deleteLoanById(int id) {
        for (int i = 0; i < loans.size(); i++) {
            if (loans.get(i).getId() == id) {
                loans.remove(i);
                return;
            }
        }
    }
}

