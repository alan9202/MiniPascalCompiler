package com.uaem.classes;

import com.uaem.util.ExpressionsTools;

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
        ExpressionsTools tool = new ExpressionsTools();
        tool.executeStatementList(statementList);
    }
}
