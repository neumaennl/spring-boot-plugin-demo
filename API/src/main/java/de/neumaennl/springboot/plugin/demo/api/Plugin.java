package de.neumaennl.springboot.plugin.demo.api;

/**
 * The interface to be implemented by all plugins.
 *
 * @author Martin Neumann - <a href="http://www.brain-child.de">brainchild
 *         GmbH</a>
 */
public interface Plugin {

    /**
     * @return the name of the plugin.
     */
    String getName();

    /**
     * Initializes the plugin.
     *
     * @param context
     *            the context shared between the main application and the
     *            plugins.
     * @throws PluginInitializationException
     *             when the plugin can't be initialized.
     */
    void initialize(Context context) throws PluginInitializationException;

    /**
     * Tells the plugin to do something.
     *
     * @return {@code true} if something was done, {@code false} otherwise.
     */
    boolean doSomething();
}
