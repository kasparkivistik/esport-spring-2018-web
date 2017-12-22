package ee.esport.spring2018.db;

import org.jooq.util.DefaultGeneratorStrategy;
import org.jooq.util.Definition;

public class EsportGenerationStrategy extends DefaultGeneratorStrategy {

    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
        return capitilize(definition.getOutputName() + "Record");
    }

    private String capitilize(String string) {
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }

    @Override
    public String getJavaIdentifier(Definition definition) {
        return definition.getOutputName().replaceAll("(.+)(\\p{javaUpperCase})", "$1_$2").toUpperCase();
    }

}
