package de.neumaennl.springboot.plugin.demo.error;

import org.springframework.stereotype.Component;

import de.neumaennl.springboot.plugin.demo.api.Context;
import de.neumaennl.springboot.plugin.demo.api.Plugin;
import de.neumaennl.springboot.plugin.demo.api.PluginInitializationException;

/**
 * An implementation of the {@link Plugin} interface which throws an exception when trying to initialize it.
 *
 * @author Martin Neumann - <a href="http://www.brain-child.de">brainchild
 *         GmbH</a>
 */
@Component
public class ErrorPlugin implements Plugin {

    private final String initErrorMessage = "ErrorPlugin throws an exception when trying to initialize it.";
    private final String doSomethingErrorMessage = "ErrorPlugin throws an exception when doSomething() is called.";

    @Override
    public String getName() {

        return "ErrorPlugin";
    }

    @Override
    public void initialize(Context context) throws PluginInitializationException {

        throw new PluginInitializationException(initErrorMessage);
    }

    @Override
    public boolean doSomething() {

        throw new UnsupportedOperationException(doSomethingErrorMessage);
    }

}
