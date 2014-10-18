package me.pennekamp.eemo.interpreter.operation;

import me.pennekamp.eemo.interpreter.ExecutionContext;

public class Double extends Operation {

    @Override
    public void execute (ExecutionContext ec) {
        ec.setRegister (ec.getRegister () * 2);
    }

}
