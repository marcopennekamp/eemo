package me.pennekamp.eemo.interpreter.operation;

import me.pennekamp.eemo.interpreter.ExecutionContext;

public class Reset extends Operation {

    @Override
    public void execute (ExecutionContext ec) {
        ec.setRegister (0L);
    }

}
