package service;

import constants.SalaryStatus;
import exception.SystemException;
import models.SalaryHistory;
import models.Workers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WorkerServiceImpl implements IWorkerService{
    private final List<Workers> workers = new ArrayList<>();

    @Override
    public void addWorker(Workers worker) throws SystemException {
       workers.add(worker);
    }

    @Override
    public void increaseSalary(String id, int amount) throws SystemException {
        Workers w = findWorker(id);
        int newSalary = w.getSalary() + amount;
        w.setSalary(newSalary);
        w.addSalaryHistory(new SalaryHistory(newSalary, LocalDateTime.now(), SalaryStatus.UP));
    }

    @Override
    public void decreaseSalary(String id, int amount) throws SystemException {
        Workers w = findWorker(id);
        int newSalary = w.getSalary() - amount;
        if (newSalary <= 0) {
            throw new SystemException("Salary must be > 0");
        }
        w.setSalary(newSalary);
        w.addSalaryHistory(new SalaryHistory(newSalary, LocalDateTime.now(), SalaryStatus.DOWN));
    }

    @Override
    public List<Workers> getAllWorkers() {
        return workers;
    }

    private Workers findWorker(String id) throws SystemException {
        for (Workers w : workers) {
            if (w.getId().equals(id)) return w;
        }
        throw new SystemException("Worker not found");
    }
}
