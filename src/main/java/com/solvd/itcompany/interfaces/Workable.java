package com.solvd.itcompany.interfaces;

import com.solvd.itcompany.company.Project;

public interface Workable {

    void startWork();

    void stopWork();

    void submitTask(Project project);

}
