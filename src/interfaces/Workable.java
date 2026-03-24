package interfaces;

import company.Project;

public interface Workable {

    void startWork();

    void stopWork();

    void submitTask(Project project);

}
