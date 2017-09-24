package com.uaem.classes;

public class AssigmentStm extends Statement{
    
    private Identifier id;
    private Expression exp;
    private int line;
    private int column;

    public AssigmentStm(Identifier id, Expression exp, int line, int column) {
        this.id = id;
        this.exp = exp;
        this.line = line;
        this.column = column;
    }
    
    @Override
    public void doAction() {
    }

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
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
