package me.pennekamp.eemo.compiler.node;

import me.pennekamp.eemo.compiler.CompilationContext;
import me.pennekamp.eemo.interpreter.operation.*;
import me.pennekamp.eemo.interpreter.operation.Double;
import me.pennekamp.eemo.parser.EemoParser;

import java.util.ArrayList;
import java.util.List;

public class OperationNode extends Node {

    private EemoParser.StatementContext ctx;

    public OperationNode (EemoParser.StatementContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public List<Operation> compile (CompilationContext cc) {
        List<Operation> operations = new ArrayList<> ();

        Operation operation = null;

        // TODO: God this is messy.
        if (ctx.Add () != null) {
            operation = new Add ();
        } else if (ctx.CopyToLeftStack () != null) {
            operation = new CopyToLeftStack ();
        }else if (ctx.Decrement () != null) {
            operation = new Decrement ();
        }else if (ctx.Double () != null) {
            operation = new Double ();
        }else if (ctx.Halve () != null) {
            operation = new Halve ();
        }else if (ctx.Increment () != null) {
            operation = new Increment ();
        }else if (ctx.Input () != null) {
            operation = new Input ();
        }else if (ctx.MoveToLeft () != null) {
            operation = new MoveToLeft ();
        }else if (ctx.MoveToRegister () != null) {
            operation = new MoveToRegister ();
        }else if (ctx.MoveToRight () != null) {
            operation = new MoveToRight ();
        }else if (ctx.MoveToStack () != null) {
            operation = new MoveToStack ();
        }else if (ctx.Nop () != null) {
            operation = new Nop ();
        }else if (ctx.Output () != null) {
            operation = new Output ();
        }else if (ctx.Reset () != null) {
            operation = new Reset ();
        }else if (ctx.Sub () != null) {
            operation = new Sub ();
        }

        if (operation != null) {
            operation.setLine (ctx.getStart ().getLine ());
            operations.add (operation);
        }

        return operations;
    }

}
