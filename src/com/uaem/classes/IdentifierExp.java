package com.uaem.classes;

public class IdentifierExp extends Expression{
    
    private Identifier id;
    private int line;
    private int column;

    public IdentifierExp(Identifier id, int line, int column) {
        this.id = id;
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
