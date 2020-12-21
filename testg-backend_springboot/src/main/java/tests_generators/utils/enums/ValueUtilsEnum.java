package tests_generators.utils.enums;

import org.cornutum.tcases.VarValueDef;

public class ValueUtilsEnum {

    public enum Type {
        VALID, FAILURE, ONCE
    }

    public static VarValueDef.Type getValueType(Type type) {
        switch (type) {
            case FAILURE -> {
                return VarValueDef.Type.FAILURE;
            }
            case ONCE ->  {
                return VarValueDef.Type.ONCE;
            }
            default -> {
                return VarValueDef.Type.VALID;
            }
        }
    }
}
