package de.neumaennl.springboot.plugin.demo.api;

import java.util.Collection;

/**
 * This interface serves as an example of an object that is shared between the
 * main application and all plugins.
 * 
 * @author Martin Neumann - <a href="http://www.brain-child.de">brainchild
 *         GmbH</a>
 */
public interface Context {

    /**
     * Interaction example method that allows to add a string to the context.
     * 
     * @param string
     *            the string to add to the context
     */
    void add(String string);

    /**
     * Interaction example method that allows to retrieve all string from the
     * context.
     * 
     * @return all strings from the context.
     */
    Collection<String> get();

    /**
     * Interaction example method that allows to remove a string from the
     * context.
     * 
     * @param string
     *            the string to remove
     */
    void remove(String string);

}
