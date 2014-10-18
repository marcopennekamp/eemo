package me.pennekamp.eemo.compiler;

import me.pennekamp.eemo.compiler.node.Discussion;
import me.pennekamp.eemo.interpreter.operation.Operation;
import me.pennekamp.eemo.parser.EemoParser;

import java.util.List;

public class Compiler {

    public List<Operation> compile (EemoParser.DiscussionContext ctx) {
        CompilationContext cc = new CompilationContext ();

        List<Operation> operations = new Discussion (ctx).compile (cc);

        /* Resolve labels. */
        for (int i = 0; i < operations.size (); ++i) {
            Operation operation = operations.get (i);
            if (operation.hasLabel ()) {
                operation.getLabel ().setPc (i);
            }
        }

        return operations;
    }

}
