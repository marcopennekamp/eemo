package me.pennekamp.eemo.compiler.node;

import me.pennekamp.eemo.compiler.CompilationContext;
import me.pennekamp.eemo.interpreter.Label;
import me.pennekamp.eemo.interpreter.operation.IfPositive;
import me.pennekamp.eemo.interpreter.operation.Nop;
import me.pennekamp.eemo.interpreter.operation.Operation;
import me.pennekamp.eemo.parser.EemoParser;

import java.util.ArrayList;
import java.util.List;

public class IfPositiveNode extends Node {

    private Node conversation;
    private int line;

    public IfPositiveNode (EemoParser.IfPositiveContext ctx) {
        conversation = new Conversation (ctx.conversation (), null);
        line = ctx.getStart ().getLine ();
    }

    @Override
    public List<Operation> compile (CompilationContext cc) {
        List<Operation> operations = new ArrayList<> ();

        IfPositive ifOperation = new IfPositive ();
        ifOperation.setLine (line);
        Label endLabel = new Label ();
        ifOperation.setEndLabel (endLabel);
        operations.add (ifOperation);

        operations.addAll (conversation.compile (cc));

        // TODO: This NOP is such a cheat... :D
        Operation nop = new Nop ();
        nop.setLabel (endLabel);
        operations.add (nop);

        return operations;
    }

}
