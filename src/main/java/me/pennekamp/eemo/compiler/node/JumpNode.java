package me.pennekamp.eemo.compiler.node;

import me.pennekamp.eemo.compiler.CompilationContext;
import me.pennekamp.eemo.interpreter.operation.Jump;
import me.pennekamp.eemo.interpreter.operation.Operation;
import me.pennekamp.eemo.parser.EemoParser;

import java.util.ArrayList;
import java.util.List;

public class JumpNode extends Node {

    private String jumpTo;
    private int line;

    public JumpNode (EemoParser.JumpContext ctx) {
        jumpTo = ctx.Id ().getText ();
        line = ctx.getStart ().getLine ();
    }

    @Override
    public List<Operation> compile (CompilationContext cc) {
        List<Operation> operations = new ArrayList<> ();

        Operation operation = new Jump (cc.createOrGetLabel (jumpTo));
        operation.setLine (line);
        operations.add (operation);

        return operations;
    }

}
