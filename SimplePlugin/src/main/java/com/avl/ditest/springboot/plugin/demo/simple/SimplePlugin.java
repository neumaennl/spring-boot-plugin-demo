package com.avl.ditest.springboot.plugin.demo.simple;

import org.springframework.stereotype.Component;

import com.avl.ditest.springboot.plugin.demo.api.Context;
import com.avl.ditest.springboot.plugin.demo.api.Plugin;
import com.avl.ditest.springboot.plugin.demo.api.PluginInitializationException;

/**
 * A simple implementation of the {@link Plugin} interface as an example.
 *
 * @author Martin Neumann - <a href="http://www.brain-child.de">brainchild
 *         GmbH</a>
 */
@Component
public class SimplePlugin implements Plugin {

    private Context context;

    private final String signatureString = "SimplePlugin adds this string every time doSomething() is called.";

    @Override
    public String getName() {

        return "SimplePlugin";
    }

    @Override
    public void initialize(Context context) throws PluginInitializationException {

        this.context = context;
    }

    @Override
    public boolean doSomething() {

        context.add(signatureString);
        return true;
    }

}
