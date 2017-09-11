package com.uaem.classes;

import java.util.Vector;

public class StatementList {
    
    private Vector statementList;
    
    public StatementList() {
        this.statementList = new Vector();
    }
    
    public void addElement(Statement statement) {
        this.statementList.add(0, statement);
    }
    
    public Statement elementAt(int index) {
        return (Statement) this.statementList.elementAt(index);
    }

    /**
     * @return the statementList
     */
    public Vector getStatementList() {
        return statementList;
    }

    /**
     * @param statementList the statementList to set
     */
    public void setStatementList(Vector statementList) {
        this.statementList = statementList;
    }
}
