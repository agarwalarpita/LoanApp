package org.aspireapp.Services;
import org.aspireapp.Pojos.Loan;
import org.aspireapp.Pojos.LoanApplication;
import org.aspireapp.Pojos.Repayment;
import org.aspireapp.Db.LoanRepository;
import org.aspireapp.Util.LoanStatus;
import org.aspireapp.Util.RepaymentStatus;

import java.util.List;
import java.util.Optional;

public class LoanService {
    private LoanRepository loanRepository ;

    public LoanService(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }
    public Loan createLoan(LoanApplication loanApplication) {

        Loan loan = new Loan(loanApplication);
        loanRepository.saveLoan(loan);
        return loan;
    }

    public void updateLoan(Loan loan) {
        loanRepository.updateLoan(loan);
    }

    public List<Loan> getLoansByCustomer(int customerId) {
        return loanRepository.getLoanByCustomerId(customerId);
    }

    public Loan getLoanById(int loanId, int customerId) {
        Loan loan =  loanRepository.getLoanById(loanId);
        if(loan.getCustomer().getId() == customerId)
        {
            return loan;
        }
        return null;
    }

    public Repayment addRepayment(int loanId, double amount, int customerId) {
        Loan loan = getLoanById(loanId, customerId);
        if (loan != null && loan.getStatus().equals(LoanStatus.PENDING)) {
            Optional<Repayment> repayment = loan.getRepayments().stream()
                    .filter(repayment1 -> repayment1.getStatus().equals(RepaymentStatus.PENDING)).findFirst();
            if(repayment.isPresent() && repayment.get().getAmount()==amount) {
                repayment.get().setAmount(amount);
                repayment.get().setStatus(RepaymentStatus.PAID);
                boolean isLoanFullyRepaid = true;
                for (Repayment r : loan.getRepayments()) {
                    if (r.getStatus() != RepaymentStatus.PAID) {
                        isLoanFullyRepaid = false;
                        break;
                    }
                }
                if (isLoanFullyRepaid) {
                    loan.setStatus(LoanStatus.PAID);
                    loanRepository.updateLoan(loan);
                }

                return repayment.get();
            }


        }
        return null;
    }

}

