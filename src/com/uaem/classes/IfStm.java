package com.uaem.classes;

public class IfStm extends Statement{
    
    private Expression ex;
    private StatementList stm1;
    private StatementList stm2;
    private int line;
    private int column;

    public IfStm(Expression ex, StatementList stm1, StatementList stm2, int line, int column) {
        this.ex = ex;
        this.stm1 = stm1;
        this.stm2 = stm2;
        this.line = line;
        this.column = column;
    }
    
    @Override
    public void doAction() {
        
    }

    public Expression getEx() {
        return ex;
    }

    public void setEx(Expression ex) {
        this.ex = ex;
    }

    public StatementList getStm1() {
        return stm1;
    }

    public void setStm1(StatementList stm1) {
        this.stm1 = stm1;
    }

    public StatementList getStm2() {
        return stm2;
    }

    public void setStm2(StatementList stm2) {
        this.stm2 = stm2;
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