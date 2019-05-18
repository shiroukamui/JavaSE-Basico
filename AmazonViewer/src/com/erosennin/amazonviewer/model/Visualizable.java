package com.erosennin.amazonviewer.model;

import java.util.Date;

public interface Visualizable {

    /**
     * Este método captura el tiempo de inicio de visualización.
     *
     * @param startDate {@code Date} Fecha en la que se inicia la visualización.
     */
    void startToSee(Date startDate);

    /**
     * Este método captura el tiempo de finalización de visualización.
     * @param endDate {@code Date} Fecha en la que se finaliza la visualización.
     */
    void stopToSee(Date endDate);
}
