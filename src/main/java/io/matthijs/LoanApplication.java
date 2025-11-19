package io.matthijs;

import io.matthijs.models.Applicant;

public class LoanApplication {
    private String id;
    private Applicant applicant;
    private int amount;
    private int deposit;
    private boolean approved = false;

    public LoanApplication(String id, Applicant applicant, int amount, int deposit) {
        this.id = id;
        this.applicant = applicant;
        this.amount = amount;
        this.deposit = deposit;
    }
}