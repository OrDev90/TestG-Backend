package tests_generators.main;

import application.entities.InputField;
import tests_generators.combination_generator.generator.CombinationGenerator;
import tests_generators.condition_generator.generator.ConditionGenerator;
import tests_generators.output.objects.OutputField;
import tests_generators.pattern_generator.generator.PatternGenerator;
import tests_generators.utils.JSON.JSON_Handler;
import tests_generators.utils.UnifiedReportGenerator;

public class Main {

    public static String generateTests(InputField generatedInputField) {
        try {
            /*
             * Add String and boolean to PatternGenerator.
             * Treat duplicates, against conditions, think of a logic to filter irrelevant/redundant results
             *  (A - 1, B - TRUE // A - 2, B - TRUE) - all in the CombinationGenerator only!
             * */
//---------------------------------------------------------------------------------------------------------------------------------//

            JSON_Handler json_handler = JSON_Handler.getInstance();

//---------------------------------------------------------------------------------------------------------------------------------//

//            InputField inputField = json_handler.convertJSONToObject(
//                    json_handler.get("http://localhost:8080/input_field/last").body());

//---------------------------------------------------------------------------------------------------------------------------------//

            PatternGenerator patternGenerator = new PatternGenerator();

            CombinationGenerator combinationGenerator = new CombinationGenerator();

            ConditionGenerator conditionGenerator = new ConditionGenerator();

//---------------------------------------------------------------------------------------------------------------------------------//

            UnifiedReportGenerator.getInstance().setProjectID(generatedInputField.getProjectId());


//---------------------------------------------------------------------------------------------------------------------------------//

            UnifiedReportGenerator.getInstance().setProjectName(generatedInputField.getProjectName());


//---------------------------------------------------------------------------------------------------------------------------------//

            patternGenerator.setInputField(generatedInputField).initTests();

//---------------------------------------------------------------------------------------------------------------------------------//

            combinationGenerator.setInputField(generatedInputField).initTests();

//---------------------------------------------------------------------------------------------------------------------------------//

            conditionGenerator.setInputField(generatedInputField).initTests();

//---------------------------------------------------------------------------------------------------------------------------------//

//            UnifiedReportGenerator.getInstance().printAll();

//---------------------------------------------------------------------------------------------------------------------------------//

            OutputField outputField = UnifiedReportGenerator.getInstance().getOutputField();

//---------------------------------------------------------------------------------------------------------------------------------//

            String json = json_handler.convertObjectToJSON(outputField);

//---------------------------------------------------------------------------------------------------------------------------------//

            json_handler.post("http://localhost:8080/output_field", json);

//---------------------------------------------------------------------------------------------------------------------------------//

            int testsAmount = outputField.getTests().size();
            int projectId = outputField.getTests().get(0).getProjectId();
            json_handler.put("http://localhost:8080/projects/" + projectId + "/" + testsAmount);

//---------------------------------------------------------------------------------------------------------------------------------//

            UnifiedReportGenerator.resetUnifiedReportGenerator();

            return json;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

/*
==================================================================================== LEGEND ====================================================================================
property - inline alias for the value's name

failure - inline true/false, sets the type of the test for this value

whenNot - inline condition, this value can occur only when X is not occurring

when - inline condition, this value can occur only when X is occurring

NA - inline true/false, sets whether this value would be ignored or not

Property - tag for value's name alias

When - tag for condition

AllOf - a logical "AND" expression

Not - a logical negation expression

AnyOf - a logical "OR" expression

LessThan - Satisfied when the given property occurs less than the given max times

NotLessThan - Satisfied when the given property occurs greater than or equal to the given min times

MoreThan - Satisfied when the given property occurs more than the given min times.

NotMoreThan - Satisfied when the given property occurs less than or equal to the given max times.

Between - Satisfied when occurrences of the given property are both greater than or equal to the given min and less than or equal to the given max
If you want to specify a strictly greater/less than relationship, specify an exclusiveMin or exclusiveMax attribute instead.

Equals - Satisfied when the given property occurs exactly the given count times.
================================================================================================================================================================================
 */