package me.pennekamp.eemo.interpreter.operation;

import me.pennekamp.eemo.interpreter.ExecutionContext;
import me.pennekamp.eemo.interpreter.Label;

public class Jump extends Operation {

    private Label target;

    public Jump (Label target) {
        this.target = target;
    }

    @Override
    public void execute (ExecutionContext ec) {
        ec.setPc (target.getPc ());
        ec.setJumped (true);
    }

}
