package test.src;

import org.aspireapp.Db.LoanRepository;
import org.aspireapp.Pojos.Customer;
import org.aspireapp.Pojos.Loan;
import org.aspireapp.Pojos.LoanApplication;
import org.aspireapp.Pojos.Repayment;
import org.aspireapp.Services.LoanService;
import org.aspireapp.Util.RepaymentStatus;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoanServiceTest {

    LoanService loanService = new LoanService(new LoanRepository());
    @Before
    public void setup(){
        LocalDate startDate = LocalDate.of(2023, Month.APRIL, 30);
        Customer customer = new Customer(1, "Arpita Agarwal");
        LoanApplication loanApplication= new LoanApplication(customer,1,1000, 4,startDate);
        loanService.createLoan(loanApplication);
    }
    @Test
    public void createLoan() {

        Loan loan = loanService.getLoanById(1,1);
        Customer customer = new Customer(1, "Arpita Agarwal");
        List<Repayment> repaymentList = new ArrayList<>();
        Repayment repayment1 = new Repayment(250.0, LocalDate.of(2023, Month.MAY, 7));
        Repayment repayment2 = new Repayment(250.0, LocalDate.of(2023, Month.MAY, 14));
        Repayment repayment3 = new Repayment(250.0, LocalDate.of(2023, Month.MAY, 21));
        Repayment repayment4 = new Repayment(250.0, LocalDate.of(2023, Month.MAY, 28));
        repaymentList.add(repayment1);
        repaymentList.add(repayment2);
        repaymentList.add(repayment3);
        repaymentList.add(repayment4);
        assertEquals(loan.getAmount(), 1000.0, 1);
        assertEquals(loan.getId(), 1);
        assertEquals(loan.getCustomer(), customer);
        assertEquals(loan.getRepayments(), repaymentList);

    }

    @Test
    public void getLoansByCustomer() {
        List<Loan> loansByCustomer = loanService.getLoansByCustomer(1);
        assertEquals(loansByCustomer.size(), 1);
    }

    @Test
    public void getLoanById() {
        Loan loanById = loanService.getLoanById(1, 1);
        assertEquals(loanById.getId(), 1);
    }

    @Test
    public void addRepayment() {
        Repayment repayment = loanService.addRepayment(1, 250, 1);
        Repayment repayment1 = new Repayment(250.0, LocalDate.of(2023, Month.MAY, 7));
        repayment1.setStatus(RepaymentStatus.PAID);
        assertEquals(repayment, repayment1);

    }
}