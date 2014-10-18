package me.pennekamp.eemo.compiler.node;

import me.pennekamp.eemo.compiler.CompilationContext;
import me.pennekamp.eemo.interpreter.operation.Operation;
import me.pennekamp.eemo.parser.EemoParser;

import java.util.List;

public class Statement extends Node {

    private String labelName;
    private Node node;

    public Statement (EemoParser.StatementContext ctx, String labelName) {
        this.labelName = labelName;

        if (ctx.ifPositive () != null) {
            node = new IfPositiveNode (ctx.ifPositive ());
        }else if (ctx.jump () != null) {
            node = new JumpNode (ctx.jump ());
        }else {
            node = new OperationNode (ctx);
        }
    }

    @Override
    public List<Operation> compile (CompilationContext cc) {
        List<Operation> operations = node.compile (cc);

        if (labelName != null && operations.size () >= 1) {
            operations.get (0).setLabel (cc.createOrGetLabel (labelName));
        }

        return operations;
    }

}
