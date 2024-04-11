package com.javarush.island.panteleev207.Location;

import com.javarush.island.panteleev207.Location.Cage;

public class Locate {
    private int rows;
    private int column;
    private Cage[][] cages;

    public Locate(int rows, int column) {
        this.rows = rows;
        this.column = column;
        cages = new Cage[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0;j<column;j++){
                cages[i][j] = new Cage();
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Cage[][] getCages() {
        return cages;
    }

    public void setCages(Cage[][] cages) {
        this.cages = cages;
    }
}