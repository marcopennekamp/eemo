package me.pennekamp.eemo.compiler.node;

import me.pennekamp.eemo.compiler.CompilationContext;
import me.pennekamp.eemo.interpreter.operation.Operation;
import me.pennekamp.eemo.parser.EemoParser;

import java.util.List;

public class Discussion extends Node {

    private Conversation conversation;

    public Discussion (EemoParser.DiscussionContext ctx) {
        conversation = new Conversation (ctx.conversation (), null);
    }

    @Override
    public List<Operation> compile (CompilationContext cc) {
        return conversation.compile (cc);
    }

}
