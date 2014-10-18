package me.pennekamp.eemo.interpreter.operation;

import me.pennekamp.eemo.interpreter.ExecutionContext;

public class MoveToRight extends Operation {

    @Override
    public void execute (ExecutionContext ec) {
        ec.getRightStack ().push (ec.getLeftStack ().pop ());
    }

}
