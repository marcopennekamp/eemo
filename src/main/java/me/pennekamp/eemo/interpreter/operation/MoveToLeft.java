package me.pennekamp.eemo.interpreter.operation;

import me.pennekamp.eemo.interpreter.ExecutionContext;

public class MoveToLeft extends Operation {

    @Override
    public void execute (ExecutionContext ec) {
        ec.getLeftStack ().push (ec.getRightStack ().pop ());
    }

}
