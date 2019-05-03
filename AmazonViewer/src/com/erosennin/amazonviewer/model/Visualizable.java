package com.erosennin.amazonviewer.model;

import java.util.Date;

public interface Visualizable {

    void startToSee(Date startDate);
    void stopToSee(Date endDate);
}
