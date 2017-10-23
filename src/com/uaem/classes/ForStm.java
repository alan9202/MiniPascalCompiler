package com.uaem.classes;

import com.uaem.util.ExpressionsTools;
import com.uaem.util.Heap;

public class ForStm extends Statement{

    private Identifier id;
    private Digit cons1;
    private Digit cons2;
    private StatementList stms;
    private int line;
    private int column;

    public ForStm(Identifier id, Digit cons1, Digit cons2, StatementList stms, int line, int column) {
        this.id = id;
        this.cons1 = cons1;
        this.cons2 = cons2;
        this.stms = stms;
        this.line = line;
        this.column = column;
    }
    
    @Override
    public void doAction() throws Exception {
        Heap.localHeap(id.getIdentifier(), cons1.getValue());
        
        ExpressionsTools tool = new ExpressionsTools();
        int idHeap = Heap.searchInHeap(id.getIdentifier());
        
        while(idHeap <= cons2.getValue()) {
            
            idHeap++;
            
            tool.executeStatementList(stms);
            
            Heap.localHeap(id.getIdentifier(), idHeap);

            idHeap = Heap.searchInHeap(id.getIdentifier());
        }
    }

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    public Digit getCons1() {
        return cons1;
    }

    public void setCons1(Digit cons1) {
        this.cons1 = cons1;
    }

    public Digit getCons2() {
        return cons2;
    }

    public void setCons2(Digit cons2) {
        this.cons2 = cons2;
    }

    public StatementList getStms() {
        return stms;
    }

    public void setStms(StatementList stms) {
        this.stms = stms;
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