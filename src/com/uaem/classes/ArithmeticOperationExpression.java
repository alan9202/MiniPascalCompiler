package com.uaem.classes;

import com.uaem.util.OperationType;
import com.uaem.util.Util;

public class ArithmeticOperationExpression extends Expression{
    
    private Expression exp1;
    private Expression exp2;
    private OperationType operationType;
    private int line;
    private int column;
    private int result;

    public ArithmeticOperationExpression(Expression exp1, Expression exp2, OperationType operationType, int line, int column) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operationType = operationType;
        this.line = line;
        this.column = column;
    }
    
    @Override
    public void doAction() throws Exception {
        result = getOperationValue();
    }
    
    public int getOperationValue() throws Exception {
        int kindExpression_1 = (exp1 instanceof DigitExp) ? 0 : (exp1 instanceof IdentifierExp) ? 1 : (exp1 instanceof ArithmeticOperationExpression) ? 2 : 3;
        int kindExpression_2 = (exp2 instanceof DigitExp) ? 0 : (exp2 instanceof IdentifierExp) ? 1 : (exp2 instanceof ArithmeticOperationExpression) ? 2 : 3;
        
        String value_1 = null;
        String value_2 = null;
        
        switch(kindExpression_1) {
            case 0:
                //DigitExpression
                DigitExp digitExp = (DigitExp) exp1;
                
                value_1 = digitExp.getDigit().getValue().toString();
                
                break;
            case 1:
                //IdentifierExpression
                IdentifierExp identifierExp = (IdentifierExp) exp1;
                
                value_1 = Util.searchInHeap(identifierExp.getId().getIdentifier()).toString();
                
                break;
            case 2:
                //ArithmeticExpression
                ArithmeticOperationExpression arithmeticExp = (ArithmeticOperationExpression) exp1;
                
                value_1 = String.valueOf(arithmeticExp.getOperationValue());
                
                break;
            default:
                throw new Exception("Tipo de instancia desconocida. ArithmeticOperationExpression Line: " + this.getLine() + " Column: " + this.getColumn());
        }
        
        switch(kindExpression_2) {
            case 0:
                //DigitExpression
                DigitExp digitExp = (DigitExp) exp2;
                
                value_2 = digitExp.getDigit().getValue().toString();
                
                break;
            case 1:
                //IdentifierExpression
                IdentifierExp identifierExp = (IdentifierExp) exp2;
                
                value_2 = Util.searchInHeap(identifierExp.getId().getIdentifier()).toString();
                
                break;
            case 2:
                //ArithmeticExpression
                ArithmeticOperationExpression arithmeticExp = (ArithmeticOperationExpression) exp2;
                
                value_2 = String.valueOf(arithmeticExp.getOperationValue());
                
                break;
            default:
                throw new Exception("Tipo de instancia desconocida. ArithmeticOperationExpression Line: " + this.getLine() + " Column: " + this.getColumn());
        }
        
        return Util.operation(value_1, value_2, this.operationType);
    }

    public Expression getExp1() {
        return exp1;
    }

    public void setExp1(Expression exp1) {
        this.exp1 = exp1;
    }

    public Expression getExp2() {
        return exp2;
    }

    public void setExp2(Expression exp2) {
        this.exp2 = exp2;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
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
    
    public int getResult(){
        return result;
    }
}
