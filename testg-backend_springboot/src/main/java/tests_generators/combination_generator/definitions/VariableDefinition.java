package tests_generators.combination_generator.definitions;

import org.cornutum.tcases.IVarDef;
import org.cornutum.tcases.VarDef;
import org.cornutum.tcases.VarValueDef;
import org.cornutum.tcases.conditions.ICondition;

import java.util.Iterator;

public class VariableDefinition {

    final private VarDef varDef;

    public VariableDefinition() {
        this.varDef = new VarDef();
    }

    public VariableDefinition(String name) {
        this.varDef = new VarDef(name);
    }

    public VariableDefinition(String name, String type) {
        this.varDef = new VarDef(name);
        this.setType(type);
    }

    public VarDef getVarDef() {
        return this.varDef;
    }

    public void setName(String name) {
        this.varDef.setName(name);
    }

    public String getName() {
        return this.varDef.getName();
    }

    public String getPathName() {
        return this.varDef.getPathName();
    }

    public void setType(String type) {
        this.varDef.setType(type);
    }

    public Iterator<IVarDef> getMembers() {
        return this.varDef.getMembers();
    }

    public Iterator<VarValueDef> getValues() {
        return this.varDef.getValues();
    }

    public Iterator<VarValueDef> getValidValues() {
        return this.varDef.getValidValues();
    }

    public Iterator<VarValueDef> getFailureValues() {
        return this.varDef.getFailureValues();
    }

    public void addValue(ValueDefinition valueDefinition){
        this.varDef.addValue(valueDefinition.getVarDef());
    }

    public void removeValue(Object name) {
        this.varDef.removeValue(name);
    }

    public VarValueDef getValue(Object name) {
        return this.varDef.getValue(name);
    }

    public boolean isApplicable(ValueDefinition valueDefinition) {
        return this.varDef.isApplicable(valueDefinition.getVarDef());
    }

    public String getType() {
        return this.varDef.getType();
    }

    public void setParent(IVarDef parent) {
        this.varDef.setParent(parent);
    }

    public ICondition getEffectiveCondition() {
        return this.varDef.getEffectiveCondition();
    }

    public IVarDef getParent() {
        return this.varDef.getParent();
    }

    public void setCondition(ICondition condition){
        this.varDef.setCondition(condition);
    }

    public IVarDef.Position getPosition() {
        return this.varDef.getPosition();
    }
}
