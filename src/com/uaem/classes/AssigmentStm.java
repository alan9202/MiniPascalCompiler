package com.uaem.classes;

import com.uaem.util.Heap;

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
    public void doAction() throws Exception {
        int kindInstance = (exp instanceof DigitExp) ? 0 : (exp instanceof IdentifierExp) ? 1 : (exp instanceof ArithmeticOperationExpression) ? 2 : 3;
        
        switch(kindInstance) {
            case 0:
                //DigitExpression
                DigitExp digitExp = (DigitExp) exp;
                
                Heap.localHeap(id.getIdentifier(), digitExp.getDigit().getValue());
                
                break;
            case 1:
                //IdentifierExpression
                IdentifierExp identifierExp = (IdentifierExp) exp;
                
                Heap.localHeap(id.getIdentifier(), identifierExp.getId().getIdentifier());
                
                break;
            case 2:
                //ArithmeticOperationExpression
                ArithmeticOperationExpression arithmeticExp = (ArithmeticOperationExpression) exp;
                
                arithmeticExp.doAction();
                Heap.localHeap(id.getIdentifier(), String.valueOf(arithmeticExp.getResult()));
                
                break;
            default:
                throw new Exception("Tipo de instancia a asignar no conocida. AssigmentStms Line: " + this.getLine() + " Column: " + this.getColumn());
        }
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
