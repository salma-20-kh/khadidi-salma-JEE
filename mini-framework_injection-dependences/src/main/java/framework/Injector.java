package framework;


import org.burningwave.core.assembler.ComponentContainer;
import org.burningwave.core.assembler.ComponentSupplier;
import org.burningwave.core.classes.ClassHunter;
import org.burningwave.core.classes.SearchConfig;


import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Injector{

    private Object object;

    public Injector(String packName) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        ComponentSupplier componentSupplier = ComponentContainer.getInstance();
        ClassHunter classHunter = componentSupplier.getClassHunter();

        ClassHunter.SearchResult result = classHunter.
                findBy(SearchConfig.forResources(packName));

        Method methode = null;
        Class classe = null;
        Constructor constructor = null;
        Field field = null;

        for (Class c : result.getClasses()) {
            for (Annotation a : c.getAnnotations()) {
                classe = c;
            }

            for (Method m : c.getMethods()) {
                for (Annotation a : m.getAnnotations()) {
                    methode = m;
                }
            }

            for (Constructor cons : c.getConstructors()) {
                for (Annotation a : cons.getAnnotations()) {
                    constructor = cons;
                }
            }

            for (Field fd : c.getFields()) {
                for (Annotation a : fd.getAnnotations()) {
                    field = fd;
                }
            }
        }

        Object obj = null;

        if(methode != null) {
            obj = methode.getDeclaringClass().newInstance();
            methode.invoke(obj,classe.newInstance());
        }

        if(constructor != null) {
            obj = constructor.newInstance(classe.newInstance());
        }
        if(field != null) {
            obj = field.getDeclaringClass().newInstance();
            field.set(obj,classe.newInstance());
        }

        this.object = obj;
    }

    public Object getObject() {
        return object;
    }
}