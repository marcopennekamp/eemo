package me.pennekamp.eemo.compiler.node;

import me.pennekamp.eemo.compiler.CompilationContext;
import me.pennekamp.eemo.interpreter.Label;
import me.pennekamp.eemo.interpreter.operation.Operation;

import java.util.List;

public abstract class Node {

    public abstract List<Operation> compile (CompilationContext cc);

}
