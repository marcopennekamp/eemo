package me.pennekamp.eemo.interpreter.operation;

import me.pennekamp.eemo.interpreter.ExecutionContext;

public class MoveToRegister extends Operation {

    @Override
    public void execute (ExecutionContext ec) {
        ec.setRegister (ec.getLeftStack ().pop ());
    }

}
