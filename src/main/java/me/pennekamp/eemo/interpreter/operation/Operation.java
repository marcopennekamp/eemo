package me.pennekamp.eemo.interpreter.operation;

import me.pennekamp.eemo.interpreter.ExecutionContext;
import me.pennekamp.eemo.interpreter.Label;

public abstract class Operation {

    protected int line;
    protected Label label = null;

    public abstract void execute (ExecutionContext ec);

    public boolean hasLabel () {
        return label != null;
    }

    public Label getLabel () {
        return label;
    }

    public void setLabel (Label label) {
        this.label = label;
    }

    public int getLine () {
        return line;
    }

    public void setLine (int line) {
        this.line = line;
    }

}
