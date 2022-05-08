package main.java.Operations;

import java.util.HashMap;
import java.util.Stack;

public class Context {
    private Stack<Double> stack = new Stack<>();
    private HashMap<String, Double> params = new HashMap<>();

    public void push(Double a) {
        stack.push(a);
    }

    public double pop() {
        return stack.pop();
    }

    public double peek() {
        return stack.peek();
    }

    public void define(String name, double x) {
        params.put(name, x);
    }

    public int size() {
        return stack.size();
    }

    public void pushDefinedToStack(String name) {
        push(params.get(name));
    }

}
