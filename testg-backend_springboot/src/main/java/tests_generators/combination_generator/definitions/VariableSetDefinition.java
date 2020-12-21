package tests_generators.combination_generator.definitions;

import org.cornutum.tcases.IVarDef;
import org.cornutum.tcases.VarSet;
import org.cornutum.tcases.VarValueDef;
import org.cornutum.tcases.conditions.ICondition;

import java.util.Iterator;

public class VariableSetDefinition {

    final private VarSet varSet;

    public VariableSetDefinition() {
        this.varSet = new VarSet();
    }

    public VariableSetDefinition(String name) {
        this.varSet = new VarSet(name);
    }

    public VariableSetDefinition(String name, String type) {
        this.varSet = new VarSet(name);
        this.setType(type);
    }

    public VarSet getVarSet() {
        return this.varSet;
    }

    public void setName(String name) {
        this.varSet.setName(name);
    }

    public String getName() {
        return this.varSet.getName();
    }

    public Iterator<IVarDef> getMembers() {
        return this.varSet.getMembers();
    }

    public Iterator<VarValueDef> getValues() {
        return this.varSet.getValues();
    }

    public void setParent(IVarDef parent) {
        this.varSet.setParent(parent);
    }

    public IVarDef getParent() {
        return this.varSet.getParent();
    }

    public void setCondition(ICondition condition){
        this.varSet.setCondition(condition);
    }

    public void addMember(VariableDefinition var) {
        this.varSet.addMember(var.getVarDef());
    }

    public void removeMember(String name) {
        this.varSet.removeMember(name);
    }

    public IVarDef getMember(String name) {
        return this.varSet.getMember(name);
    }

    public IVarDef getDescendant(String pathName) {
        return this.varSet.getDescendant(pathName);
    }

    public String getPathName() {
        return this.varSet.getPathName();
    }

    public void setType(String type) {
        this.varSet.setType(type);
    }

    public String getType() {
        return this.varSet.getType();
    }

    public ICondition getEffectiveCondition() {
        return this.varSet.getEffectiveCondition();
    }

    public IVarDef.Position getPosition() {
        return this.varSet.getPosition();
    }
}