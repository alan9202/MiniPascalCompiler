package com.uaem.classes;

import java.util.Vector;

public class Block {
    private StatementList statementList;

    public Block(StatementList statementList) {
        this.statementList = statementList;
    }
    
    /**
     * @return the statementList
     */
    public StatementList getStatementList() {
        return statementList;
    }

    /**
     * @param statementList the statementList to set
     */
    public void setStatementList(StatementList statementList) {
        this.statementList = statementList;
    }
    
    public void doAction() throws Exception {
        Vector stmVector = this.statementList.getStatementList();
        
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
