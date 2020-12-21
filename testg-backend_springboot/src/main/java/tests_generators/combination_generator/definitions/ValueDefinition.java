package tests_generators.combination_generator.definitions;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.cornutum.tcases.VarValueDef;
import org.cornutum.tcases.conditions.Conditions;
import org.cornutum.tcases.conditions.ICondition;
import tests_generators.utils.enums.ConditionsEnum;
import tests_generators.utils.enums.ValueUtilsEnum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ValueDefinition {

    final private VarValueDef varValueDef;
    private ConditionSetDefinition conditionSetDefinition;

    public ValueDefinition() {
        this.varValueDef = new VarValueDef();
    }

    public ValueDefinition(String name) {
        this.varValueDef = new VarValueDef(name);
    }

    public ValueDefinition(String name, ValueUtilsEnum.Type type) {
        this.varValueDef = new VarValueDef(name, ValueUtilsEnum.getValueType(type));
    }

    public ValueDefinition(String name, ValueUtilsEnum.Type type, Collection<String> properties) {
        this.varValueDef = new VarValueDef(name, ValueUtilsEnum.getValueType(type));
        this.setProperties(properties);
    }

    public ValueDefinition(String name, ValueUtilsEnum.Type type, Collection<String> properties, Collection<ImmutablePair<ConditionsEnum,
            List<ImmutablePair<ConditionsEnum, List<String>>>>> conditions) {
        this.varValueDef = new VarValueDef(name, ValueUtilsEnum.getValueType(type));
        this.setProperties(properties);
        this.setConditions(conditions);
    }

    public boolean hasConditions() {
        return this.conditionSetDefinition != null;
    }

    public void setConditions(Collection<ImmutablePair<ConditionsEnum, List<ImmutablePair<ConditionsEnum, List<String>>>>> conditions) {
        this.conditionSetDefinition = new ConditionSetDefinition();
        for (ImmutablePair<ConditionsEnum, List<ImmutablePair<ConditionsEnum, List<String>>>> condition : conditions) {
            ICondition finalCondition = this.generateCondition(condition);
            this.conditionSetDefinition.addCondition(finalCondition);
            this.setCondition(finalCondition);
        }
    }

    private ICondition generateCondition(ImmutablePair<ConditionsEnum, List<ImmutablePair<ConditionsEnum, List<String>>>> condition) {
        List<ICondition> iConditions = new ArrayList<>();
        for (ImmutablePair<ConditionsEnum, List<String>> subCondition : condition.getValue()) {
            for (String property : subCondition.getValue()) {
                iConditions.add(this.generateConditionParameter(subCondition.getKey(), property));
            }
        }
        switch (condition.getKey()) {
            case NOT -> {
                return Conditions.not(iConditions.toArray(new ICondition[]{}));
            }
            case ALL_OF -> {
                return Conditions.allOf(iConditions.toArray(new ICondition[]{}));
            }
            case ANY_OF -> {
                return Conditions.anyOf(iConditions.toArray(new ICondition[]{}));
            }
        }
        return null;
    }

    private ICondition generateConditionParameter(ConditionsEnum subCondition, String property) {
        switch (subCondition) {
            case NOT -> {
                return Conditions.not(property);
            }
            case ALL_OF -> {
                return Conditions.allOf(property);
            }
            case ANY_OF -> {
                return Conditions.anyOf(property);
            }
            case CONTAINS_ANY -> {
                return Conditions.hasAny(property);
            }
            case CONTAINS_ALL ->  {
                return Conditions.has(property);
            }
            default -> {
                return null;
            }
        }
    }

    public Iterator<ICondition> getConditions() {
        return this.conditionSetDefinition.getConditions();
    }

    public VarValueDef getVarDef() {
        return this.varValueDef;
    }

    public void setName(String name) {
        this.varValueDef.setName(name);
    }

    public String getName() {
        return this.varValueDef.getName().toString();
    }

    public Object getExternalName() {
        return this.varValueDef.getExternalName();
    }

    public void setType(VarValueDef.Type type) {
        this.varValueDef.setType(type);
    }

    public VarValueDef.Type getType() {
        return this.varValueDef.getType();
    }

    public boolean isValid() {
        return this.varValueDef.isValid();
    }

    public boolean hasProperty(String property) {
        return this.varValueDef.hasProperty(property);
    }

    public boolean hasProperties() {
        return this.varValueDef.hasProperties();
    }

    public void setProperties(Collection<String> properties) {
        this.varValueDef.setProperties(properties);
    }

    public Iterable<String> getProperties() {
        return this.varValueDef.getProperties();
    }

    public VarValueDef addProperties(Collection<String> properties) {
        return this.varValueDef.addProperties(properties);
    }

    public VarValueDef addProperties(String... properties) {
        return this.varValueDef.addProperties(properties);
    }

    public VarValueDef removeProperties(Collection<String> properties) {
        return this.varValueDef.removeProperties(properties);
    }

    public VarValueDef removeProperties(String... properties) {
        return this.varValueDef.removeProperties(properties);
    }

    public void setCondition(ICondition condition) {
        this.varValueDef.setCondition(condition);
    }
}
