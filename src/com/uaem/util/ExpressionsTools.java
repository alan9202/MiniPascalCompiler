package com.uaem.util;

import com.uaem.classes.ArithmeticOperationExpression;
import com.uaem.classes.AssigmentStm;
import com.uaem.classes.DigitExp;
import com.uaem.classes.Expression;
import com.uaem.classes.ForStm;
import com.uaem.classes.IdentifierExp;
import com.uaem.classes.IfStm;
import com.uaem.classes.InputStm;
import com.uaem.classes.OutputStm;
import com.uaem.classes.StatementList;
import java.util.Vector;

public class ExpressionsTools {
    
    public int getExpressionValue(Expression exp) throws Exception{
        int kindExpression = (exp instanceof DigitExp) ? 0 : (exp instanceof IdentifierExp) ? 1 : (exp instanceof ArithmeticOperationExpression) ? 2 : 3;
        
        switch(kindExpression) {
            case 0:
                //DigitExpression
                DigitExp digitExp = (DigitExp) exp;
                
                return digitExp.getDigit().getValue();
            case 1:
                //IdentifierExpression
                IdentifierExp identifierExp = (IdentifierExp) exp;
                
                return Heap.searchInHeap(identifierExp.getId().getIdentifier());
            case 2:
                //ArithmeticExpression
                ArithmeticOperationExpression arithmeticExp = (ArithmeticOperationExpression) exp;
                
                return arithmeticExp.getOperationValue();
            default:
                throw new Exception("Tipo de instancia desconocida");
        }
    }
    
    public void executeStatementList(StatementList statementList) throws Exception {
        Vector stmVector = statementList.getStatementList();
        
        for(Object stm : stmVector) {
            if(stm instanceof AssigmentStm) {
                AssigmentStm assigmentStm = (AssigmentStm) stm;
                assigmentStm.doAction();
            }
            else if(stm instanceof InputStm) {
                InputStm inputStm = (InputStm) stm;
                inputStm.doAction();
            }
            else if(stm instanceof OutputStm) {
                OutputStm outputStm = (OutputStm) stm;
                outputStm.doAction();
            }
            else if(stm instanceof ForStm) {
                ForStm forStm = (ForStm) stm;
                forStm.doAction();
            }
            else if(stm instanceof IfStm) {
                IfStm ifStm = (IfStm) stm;
                ifStm.doAction();
            }
        }
    }
}
