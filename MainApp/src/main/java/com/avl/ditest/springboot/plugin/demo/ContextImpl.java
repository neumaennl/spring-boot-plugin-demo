package com.avl.ditest.springboot.plugin.demo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.avl.ditest.springboot.plugin.demo.api.Context;

/**
 * Simple implementation of the {@link Context} interface as an example of an
 * object that is shared between the main application and all plugins.
 *
 * @author Martin Neumann - <a href="http://www.brain-child.de">brainchild
 *         GmbH</a>
 */
public class ContextImpl implements Context {

    private final List<String> strings = new LinkedList<>();

    @Override
    public void add(String string) {

        strings.add(string);
    }

    @Override
    public Collection<String> get() {

        return strings;
    }

    @Override
    public void remove(String string) {

        strings.remove(string);
    }

}
