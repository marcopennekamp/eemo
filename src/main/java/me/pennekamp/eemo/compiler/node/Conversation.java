package me.pennekamp.eemo.compiler.node;

import me.pennekamp.eemo.compiler.CompilationContext;
import me.pennekamp.eemo.interpreter.operation.Operation;
import me.pennekamp.eemo.parser.EemoParser;

import java.util.ArrayList;
import java.util.List;

public class Conversation extends Node {

    private String labelName;
    private List<Node> nodes = new ArrayList<> ();

    public Conversation (EemoParser.ConversationContext ctx, String labelName) {
        this.labelName = labelName;

        List<EemoParser.LabeledLineContext> lines = ctx.labeledLine ();
        for (EemoParser.LabeledLineContext line : lines) {
            EemoParser.LabelContext labelContext = line.label ();
            String lineLabelName = null;
            if (labelContext != null) {
                lineLabelName = labelContext.getText ();
            }

            if (line.conversation () != null) {
                nodes.add (new Conversation (line.conversation (), lineLabelName));
            }else if (line.statement () != null) {
                nodes.add (new Statement (line.statement (), lineLabelName));
            }
        }
    }

    @Override
    public List<Operation> compile (CompilationContext cc) {
        List<Operation> operations = new ArrayList<> ();

        for (Node node : nodes) {
            operations.addAll (node.compile (cc));
        }

        if (labelName != null && operations.size () >= 1) {
            operations.get (0).setLabel (cc.createOrGetLabel (labelName));
        }

        return operations;
    }

}
