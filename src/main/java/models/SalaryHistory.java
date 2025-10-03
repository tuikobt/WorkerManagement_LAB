package models;

import constants.SalaryStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SalaryHistory {
    private int salary;
    private LocalDateTime date;
    private SalaryStatus status;

    public SalaryHistory() {
    }

    public SalaryHistory(int salary, LocalDateTime date, SalaryStatus status) {
        this.salary = salary;
        this.date = date;
        this.status = status;
    }

    public long getSalary() {
        return salary;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public SalaryStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("%10d %10s %10s", getSalary(), getStatus(), getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
