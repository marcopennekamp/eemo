package me.pennekamp.eemo.interpreter.operation;

import me.pennekamp.eemo.interpreter.ExecutionContext;

public class CopyToLeftStack extends Operation {

    @Override
    public void execute (ExecutionContext ec) {
        ec.getLeftStack ().push (ec.getRegister ());
    }

}
