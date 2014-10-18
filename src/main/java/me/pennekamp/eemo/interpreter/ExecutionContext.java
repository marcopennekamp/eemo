package me.pennekamp.eemo.interpreter;

import java.util.Stack;

public class ExecutionContext {

    private Stack<Long> leftStack = new Stack<> ();
    private Stack<Long> rightStack = new Stack<> ();
    private long register = 0L;
    private int pc = 0;
    private boolean jumped = false;

    public Stack<Long> getLeftStack () {
        return leftStack;
    }

    public Stack<Long> getRightStack () {
        return rightStack;
    }

    public long getRegister () {
        return register;
    }

    public void setRegister (long register) {
        this.register = register;
    }

    public int getPc () {
        return pc;
    }

    public void setPc (int pc) {
        this.pc = pc;
    }

    public boolean hasJumped () {
        return jumped;
    }

    public void setJumped (boolean jumped) {
        this.jumped = jumped;
    }

}
