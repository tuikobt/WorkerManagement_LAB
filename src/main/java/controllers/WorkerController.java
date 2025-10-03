package controllers;

import constants.Messages;
import dto.WorkerDTO;
import exception.SystemException;
import models.SalaryHistory;
import models.Workers;
import service.IWorkerService;
import service.WorkerServiceImpl;
import views.WorkerView;

import java.util.List;

public class WorkerController {
    private final IWorkerService service = new WorkerServiceImpl();
    private final WorkerView view = new WorkerView();

    public void addWorker(WorkerDTO dto) throws SystemException {
        Workers worker = new Workers(dto.getId(), dto.getName(), dto.getAge(), dto.getSalary(), dto.getLocaton());
        service.addWorker(worker);
    }

    public void increaseSalary(WorkerDTO dto) throws SystemException {
        service.increaseSalary(dto.getId(), dto.getAmount());
    }

    public void decreaseSalary(WorkerDTO dto) throws SystemException {
        service.decreaseSalary(dto.getId(), dto.getAmount());
    }

    public void displayInformation() throws SystemException {
        List<Workers> workers = service.getAllWorkers();
        StringBuilder body = new StringBuilder();
        boolean hasChange = false;

        for (Workers w : workers) {
            for (SalaryHistory h : w.getSalaryHistories()) {
                switch (h.getStatus()) {
                    case UP:
                    case DOWN:
                        body.append(w.toString(h));
                        hasChange = true;
                }
            }
        }

        if (!hasChange) throw new SystemException("No salary changes found.");

        view.setHeader(Messages.DISPLAY_HEADER);
        view.setBody(body.toString());
        view.display();
    }
}
