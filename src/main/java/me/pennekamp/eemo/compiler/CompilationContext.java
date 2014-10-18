package me.pennekamp.eemo.compiler;

import me.pennekamp.eemo.interpreter.Label;

import java.util.HashMap;
import java.util.Map;

public class CompilationContext {

    private Map<String, Label> labels = new HashMap<> ();

    public Label createOrGetLabel (String name) {
        Label label = labels.get (name);
        if (label == null) {
            label = new Label ();
            labels.put (name, label);
        }
        return label;
    }

}
