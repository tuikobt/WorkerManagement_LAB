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

    private Workers findWorker(String id) throws SystemException {
        for (Workers w : workers) {
            if (w.getId().equals(id)) return w;
        }
        throw new SystemException("Worker not found");
    }

    public void addWorker(WorkerDTO dto) throws SystemException {
        for (Workers existingWorker : workers) {
            if (existingWorker.getId().equals(dto.getId())) {
                throw new SystemException("Worker ID already exists: " + dto.getId());
            }
        }
        Workers worker = new Workers(dto.getId(), dto.getName(), dto.getAge(), dto.getSalary(), dto.getLocaton());
        workers.add(worker);
    }

    public void increaseSalary(WorkerDTO dto) throws SystemException {
        Workers worker = findWorker(dto.getId());
        service.setWorker(worker);
        service.increaseSalary(dto.getAmount());
    }

    public void decreaseSalary(WorkerDTO dto) throws SystemException {
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
