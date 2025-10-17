package models;

import constants.SalaryStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Workers {
    private String id;
    private String name;
    private int age;
    private int salary;
    private String location;
    private List<SalaryHistory> salaryHistories;

    public Workers() {
    }

    public Workers(String id, String name, int age, int salary, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.location = location;
        this.salaryHistories = new ArrayList<>();
        this.salaryHistories.add(new SalaryHistory(salary, LocalDateTime.now(), SalaryStatus.NOTCHANGE));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getLocation() {
        return location;
    }

    public List<SalaryHistory> getSalaryHistories() {
        return salaryHistories;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addSalaryHistory(SalaryHistory history) {
        salaryHistories.add(history);
    }

    public String toString() {
        String result = "";
        for (SalaryHistory history : getSalaryHistories()) {
            result = result.concat(String.format("%s %-10s %-5d %-30s\n", getId(), getName(), getAge(), history.toString()));
        }
        return result;
    }
}
