package me.pennekamp.eemo.interpreter.operation;

import me.pennekamp.eemo.interpreter.ExecutionContext;
import me.pennekamp.eemo.interpreter.Label;

public class IfPositive extends Operation {

    private Label endLabel;

    @Override
    public void execute (ExecutionContext ec) {
        if (ec.getRegister () <= 0) {
            ec.setPc (endLabel.getPc ());
            ec.setJumped (true);
        }
    }

    public Label getEndLabel () {
        return endLabel;
    }

    public void setEndLabel (Label endLabel) {
        this.endLabel = endLabel;
    }

}
