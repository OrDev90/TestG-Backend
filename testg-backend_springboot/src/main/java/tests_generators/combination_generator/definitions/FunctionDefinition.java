package tests_generators.combination_generator.definitions;

import org.cornutum.tcases.FunctionInputDef;
import org.cornutum.tcases.IVarDef;

import java.util.Iterator;

public class FunctionDefinition {

    final private FunctionInputDef functionInputDef;

    public FunctionDefinition() {
        this.functionInputDef = new FunctionInputDef();
    }

    public FunctionDefinition(String name) {
        this.functionInputDef = new FunctionInputDef(name);
    }

    public FunctionInputDef getFunctionInputDef() {
        return this.functionInputDef;
    }

    public void setName(String name) {
        this.functionInputDef.setName(name);
    }

    public String getName() {
        return this.functionInputDef.getName();
    }

    public void addVarDefinition(VariableDefinition variableDefinition) {
        this.functionInputDef.addVarDef(variableDefinition.getVarDef());
    }

    public void addVarSetDefinition(VariableSetDefinition variableSetDefinition) {
        this.functionInputDef.addVarDef(variableSetDefinition.getVarSet());
    }

    public void removeVarDefinition(String name) {
        this.functionInputDef.removeVarDef(name);
    }

    public IVarDef getVarDefinition(String name) {
        return this.functionInputDef.getVarDef(name);
    }

    public Iterator<IVarDef> getVarDefinitions() {
        return this.functionInputDef.getVarDefs();
    }

    public String[] getVarTypes() {
        return this.functionInputDef.getVarTypes();
    }
}
