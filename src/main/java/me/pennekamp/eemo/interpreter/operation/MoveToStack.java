package me.pennekamp.eemo.interpreter.operation;

import me.pennekamp.eemo.interpreter.ExecutionContext;

public class MoveToStack extends Operation {

    @Override
    public void execute (ExecutionContext ec) {
        ec.getLeftStack ().push (ec.getRegister ());
        ec.setRegister (0L); /* Also reset. */
    }

}
