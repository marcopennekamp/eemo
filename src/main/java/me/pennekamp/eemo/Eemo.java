package me.pennekamp.eemo;

import me.pennekamp.eemo.interpreter.Interpreter;
import me.pennekamp.eemo.interpreter.operation.Operation;
import me.pennekamp.eemo.parser.EemoLexer;
import me.pennekamp.eemo.parser.EemoParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Eemo {

    public static void main (String[] args) {
        if (args.length < 1) {
            System.out.println ("Please specify a file to be interpreted.");
            return;
        }

        InputStream stream = null;
        try {
            stream = new ByteArrayInputStream (Files.readAllBytes (Paths.get (args[0])));
        } catch (IOException e) {
            e.printStackTrace ();
        }

        if (stream == null) {
            System.out.println ("Source could not be read!");
            return;
        }

        EemoParser.DiscussionContext discussionContext = null;
        EemoLexer lexer = null;
        try {
            lexer = new EemoLexer (new ANTLRInputStream (stream));
        } catch (IOException e) {
            e.printStackTrace ();
        }
        CommonTokenStream tokenStream = new CommonTokenStream (lexer);

        EemoParser parser = new EemoParser (tokenStream);
        discussionContext = parser.discussion ();

        if (discussionContext == null) {
            System.out.println ("Could not parse the source!");
            return;
        }

        List<Operation> program = new me.pennekamp.eemo.compiler.Compiler ().compile (discussionContext);
        new Interpreter ().execute (program);
    }

}
