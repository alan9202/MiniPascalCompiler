package com.uaem.classes;

public class DigitExp extends Expression{
    
    private Digit digit;
    private int line;
    private int column;

    public DigitExp(Digit digit, int line, int column) {
        this.digit = digit;
        this.line = line;
        this.column = column;
    }
    
    @Override
    public void doAction() {
        
    }

    public Digit getDigit() {
        return digit;
    }

    public void setDigit(Digit digit) {
        this.digit = digit;
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