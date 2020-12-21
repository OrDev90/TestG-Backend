package tests_generators.combination_generator.definitions;

import org.cornutum.tcases.FunctionInputDef;
import org.cornutum.tcases.SystemInputDef;

import java.util.Iterator;

public class SystemDefinition {

    final private SystemInputDef systemInputDef;

    public SystemDefinition() {
        this.systemInputDef = new SystemInputDef();
    }

    public SystemDefinition(String name) {
        this.systemInputDef = new SystemInputDef(name);
    }

    public SystemInputDef getSystemInputDef() {
        return this.systemInputDef;
    }

    public void setName(String name) {
        this.systemInputDef.setName(name);
    }

    public String getName() {
        return this.systemInputDef.getName();
    }

    public void addFunctionInputDefinition(FunctionDefinition functionDefinition) {
        this.systemInputDef.addFunctionInputDef(functionDefinition.getFunctionInputDef());
    }

    public void removeFunctionInputDefinition(String name) {
        this.systemInputDef.removeFunctionInputDef(name);
    }

    public FunctionInputDef getFunctionInputDefinition(String name) {
        return this.systemInputDef.getFunctionInputDef(name);
    }

    public Iterator<FunctionInputDef> getFunctionInputDefinitions() {
        return this.systemInputDef.getFunctionInputDefs();
    }
}
