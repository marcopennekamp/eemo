package me.pennekamp.eemo.interpreter.operation;

import me.pennekamp.eemo.interpreter.ExecutionContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input extends Operation {

    @Override
    public void execute (ExecutionContext ec) {
        try {
            BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
            ec.setRegister (Long.parseLong (br.readLine ()));
        } catch (IOException e) {
            System.out.println ("Reading input failed!");
            e.printStackTrace ();
        }
    }

}
