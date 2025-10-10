package service;

import exception.SystemException;
import models.Workers;

import java.util.List;

public interface IWorkerService {
    void setWorker(Workers worker);
    void increaseSalary(int amount) throws SystemException;
    void decreaseSalary(int amount) throws SystemException;
}
