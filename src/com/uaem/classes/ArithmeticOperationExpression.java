package com.uaem.classes;

import com.uaem.util.ExpressionsTools;
import com.uaem.util.OperationType;
import com.uaem.util.Heap;

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
        ExpressionsTools tool = new ExpressionsTools();
        String value_1;
        String value_2;
        
        value_1 = String.valueOf(tool.getExpressionValue(exp1));
        value_2 = String.valueOf(tool.getExpressionValue(exp2));
                
        return Heap.operation(value_1, value_2, this.operationType);
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
