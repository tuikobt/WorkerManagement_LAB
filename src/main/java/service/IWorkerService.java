package service;

import exception.SystemException;
import models.Workers;

import java.util.List;

public interface IWorkerService {
    void addWorker(Workers worker) throws SystemException;
    void increaseSalary(String id, int amount) throws SystemException;
    void decreaseSalary(String id, int amount) throws SystemException;
    List<Workers> getAllWorkers();
}
