package tests_generators.combination_generator.definitions;

import lombok.Getter;
import org.cornutum.tcases.PropertySet;
import org.cornutum.tcases.conditions.ConditionSet;
import org.cornutum.tcases.conditions.ICondition;
import org.cornutum.tcases.conditions.IConditionVisitor;

import java.util.Iterator;

@Getter
public class ConditionSetDefinition extends ConditionSet implements ICondition {

    public void addCondition(ICondition conditions) {
        super.add(conditions);
    }

    public void removeCondition(ICondition conditions) {
        super.remove(conditions);
    }

    public Iterator<ICondition> getConditions() {
        return super.getConditions();
    }

    @Override
    public boolean satisfied(PropertySet propertySet) {
        return false;
    }

    @Override
    public boolean compatible(PropertySet propertySet) {
        return false;
    }

    @Override
    public void accept(IConditionVisitor iConditionVisitor) {

    }
}
