package me.pennekamp.eemo.interpreter.operation;

import me.pennekamp.eemo.interpreter.ExecutionContext;

public class Output extends Operation {

    @Override
    public void execute (ExecutionContext ec) {
        System.out.print ((char) ec.getRegister ());
    }

}
