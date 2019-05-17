package com.avl.ditest.springboot.plugin.demo.another;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.avl.ditest.springboot.plugin.demo.api.Context;
import com.avl.ditest.springboot.plugin.demo.api.Plugin;
import com.avl.ditest.springboot.plugin.demo.api.PluginInitializationException;

/**
 * Another implementation of the {@link Plugin} interface as an example.
 *
 * @author Martin Neumann - <a href="http://www.brain-child.de">brainchild
 *         GmbH</a>
 */
@Component
public class AnotherPlugin implements Plugin {

    private Context context;

    private final String doSomethingString = "AnotherPlugin only adds this string when doSomething() is called if the String is not already in the context.";
    private final String doSomethingElseString = "AnotherPlugin adds this string to the context every 5 seconds after an initial delay of 2 seconds.";

    @Override
    public String getName() {

        return "AnotherPlugin";
    }

    @Override
    public void initialize(Context context) throws PluginInitializationException {

        this.context = context;

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.scheduleAtFixedRate(() -> doSomethingElse(), 2, 5, TimeUnit.SECONDS);
    }

    @Override
    public boolean doSomething() {

        if (!context.get().contains(doSomethingString)) {
            context.add(doSomethingString);
            return true;
        }
        return false;
    }

    private void doSomethingElse() {

        context.add(doSomethingElseString);
    }

}
