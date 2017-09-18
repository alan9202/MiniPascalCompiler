package com.uaem.classes;

public class NullStm extends Statement{
    private int line;
    private int column;

    public NullStm(int line, int column) {
        this.line = line;
        this.column = column;
    }
    
    @Override
    public void doAction() {
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}