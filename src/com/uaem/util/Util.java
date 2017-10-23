package com.uaem.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Util {
    
    private static final Map<String, Integer> HEAP = new HashMap<>();
    private static final String NUMBER_REGEX = "(?<=\\s|^)\\d+(?=\\s|$)";
    
    public static void localHeap(String identifier, String value) throws Exception
    {
        Heap(identifier, getValueFromExpression(value));
    }
    
    private static void Heap(String identifier, Integer value) throws Exception
    {
        if(HEAP.isEmpty())
        {
            HEAP.put(identifier, value);
        }
        else
        {
            if(HEAP.containsKey(identifier))
            {
                HEAP.replace(identifier, value);
            }
            else
            {
                HEAP.put(identifier, value);
            }
        }
    }
    
    public static Integer operation(String firstValue, String secondValue, OperationType operationType) throws Exception
    {
        Integer value_1 = getValueFromExpression(firstValue);
        Integer value_2 = getValueFromExpression(secondValue);
        
        switch (operationType) {
            case ADD:
                return value_1 + value_2;
            case SUB:
                return value_1 - value_2;
            case MULT:
                return value_1 * value_2;
            case DIV:
                return value_1 / value_2;
            default:
                throw new Exception("Operación no valida.");
        }
    }
    
    private static Integer valueToInteger(String value)
    {
        return Integer.valueOf(value);
    }
    
    private static Integer getValueFromExpression(String expression)
    {
        if(Pattern.matches(NUMBER_REGEX, expression))
        {
            return valueToInteger(expression);
        }
        else
        {
            return searchInHeap(expression);
        }
    }
    
    public static Integer searchInHeap(String identifier)
    {
        Integer value;
        
        if(HEAP.isEmpty())
        {
            HEAP.put(identifier, 0);
            value = 0;
        }
        else
        {
            if(HEAP.containsKey(identifier))
            {
                value = HEAP.get(identifier);
            }
            else
            {
                HEAP.put(identifier, 0);
                value = 0;
            }
        }
        
        return value;
    }
    
    public static void print(String identifier) throws Exception
    {
        if(HEAP.isEmpty())
        {
            throw new Exception("La variable " + identifier + " aun no ha sido declarada.");
        }
        else
        {
            if(HEAP.containsKey(identifier))
            {
                System.out.println(HEAP.get(identifier));
            }
            else
            {
                throw new Exception("La variable " + identifier + " aun no ha sido declarada.");
            }
        }
    }
    
    public static void read(String identifier) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        String read = scanner.next();
        Integer intValue;
        
        if(Pattern.matches(NUMBER_REGEX, read))
        {
            intValue = valueToInteger(read);
        }
        else
        {
            throw new Exception("Debe introducir un valor de tipo Integer.");
        }
        
        Heap(identifier, intValue);
    }
}
