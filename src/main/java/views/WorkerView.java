package views;

public class WorkerView {
    private String header;
    private String body;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void display() {
        System.out.println(header);
        System.out.println(body);
    }
}
