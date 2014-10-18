package me.pennekamp.eemo.interpreter;

import me.pennekamp.eemo.interpreter.operation.Operation;

import java.util.List;

public class Interpreter {

    public void execute (List<Operation> program) {
        if (program.size () <= 0) {
            System.out.println ("The program is empty!");
        }

        ExecutionContext ec = new ExecutionContext ();

        try {
            final int programSize = program.size ();
            for (int pc = ec.getPc (); pc < programSize; pc = ec.getPc ()) {
                program.get (pc).execute (ec);
                if (ec.hasJumped ()) {
                /* Do not increment the program counter here. */
                    ec.setJumped (false);
                } else {
                    ec.setPc (pc + 1);
                }
            }
        }catch (Exception e) {
            System.out.println ("Exception on line " + program.get (ec.getPc ()).getLine () + ": ");
            e.printStackTrace ();
        }
    }

}
