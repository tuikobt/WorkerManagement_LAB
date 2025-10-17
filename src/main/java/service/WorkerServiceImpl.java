package service;

import constants.SalaryStatus;
import exception.SystemException;
import models.SalaryHistory;
import models.Workers;

import java.time.LocalDateTime;


public class WorkerServiceImpl implements IWorkerService{
    private Workers worker;

    @Override
    public void setWorker(Workers worker) {
        this.worker = worker;
    }

    @Override
    public void increaseSalary(int amount) throws SystemException {
        int newSalary = worker.getSalary() + amount;
        worker.setSalary(newSalary);
        worker.addSalaryHistory(new SalaryHistory(newSalary, LocalDateTime.now(), SalaryStatus.UP));
    }

    @Override
    public void decreaseSalary(int amount) throws SystemException {
        int newSalary = worker.getSalary() - amount;
        if (newSalary <= 0) {
            throw new SystemException("Salary must be > 0");
        }
        worker.setSalary(newSalary);
        worker.addSalaryHistory(new SalaryHistory(newSalary, LocalDateTime.now(), SalaryStatus.DOWN));
    }
}
