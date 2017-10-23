package com.uaem.classes;

import com.uaem.util.Util;

public class OutputStm extends Statement{
    
    private Identifier id;
    private int line;
    private int column;

    public OutputStm(Identifier id, int line, int column) {
        this.id = id;
        this.line = line;
        this.column = column;
    }

    @Override
    public void doAction() throws Exception {
        Util.print(id.getIdentifier());
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