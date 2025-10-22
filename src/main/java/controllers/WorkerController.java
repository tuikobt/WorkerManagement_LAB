package controllers;

import constants.Messages;
import dto.WorkerDTO;
import exception.SystemException;
import models.SalaryHistory;
import models.Workers;
import service.IWorkerService;
import service.WorkerServiceImpl;
import views.WorkerView;

import java.util.ArrayList;
import java.util.List;

public class WorkerController {
    private final IWorkerService service = new WorkerServiceImpl();
    private final WorkerView view = new WorkerView();

    private final List<Workers> workers = new ArrayList<>();

    private Workers findWorker(String id) {
        for (Workers w : workers) {
            if (w.getId().equals(id)) return w;
        }
        return null;
    }

    public void addWorker(WorkerDTO dto) throws SystemException {
        if (findWorker(dto.getId()) != null) {
            throw new SystemException("Worker ID already exists!");
        }
        Workers worker = new Workers(dto.getId(), dto.getName(), dto.getAge(), dto.getSalary(), dto.getLocaton());
        workers.add(worker);
    }

    public void increaseSalary(WorkerDTO dto) throws SystemException {
        if (findWorker(dto.getId()) == null) {
            throw new SystemException("Worker not found!");
        }
        Workers worker = findWorker(dto.getId());
        service.setWorker(worker);
        service.increaseSalary(dto.getAmount());
    }

    public void decreaseSalary(WorkerDTO dto) throws SystemException {
        if (findWorker(dto.getId()) == null) {
            throw new SystemException("Worker not found!");
        }
        Workers worker = findWorker(dto.getId());
        service.setWorker(worker);
        service.decreaseSalary(dto.getAmount());
    }

    public void displayInformation() throws SystemException {
        StringBuilder body = new StringBuilder();

        for (Workers worker : workers) {
            body.append(worker.toString());
        }
        view.setHeader(Messages.DISPLAY_HEADER);
        view.setBody(body.toString());
        view.display();
    }
}
