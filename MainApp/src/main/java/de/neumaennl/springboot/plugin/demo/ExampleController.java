package de.neumaennl.springboot.plugin.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.neumaennl.springboot.plugin.demo.api.Context;
import de.neumaennl.springboot.plugin.demo.api.Plugin;
import de.neumaennl.springboot.plugin.demo.api.PluginInitializationException;

/**
 * A simple controller that lists all plugins and the content of the context.
 *
 * @author Martin Neumann - <a href="http://www.brain-child.de">brainchild
 *         GmbH</a>
 */
@RestController
public class ExampleController {

    private Context context;

    @Autowired
    private List<Plugin> plugins;

    private final Map<String, String> pluginsWithInitError = new HashMap<>();

    @PostConstruct
    private void initialize() {

        context = new ContextImpl();

        for (Plugin plugin : plugins) {
            try {
                plugin.initialize(context);
            } catch (PluginInitializationException e) {
                pluginsWithInitError.put(plugin.getName(), e.getMessage());
            }
        }
    }

    /**
     * Calls {@link Plugin#doSomething() doSomething()} on each plugin and then
     * assembles an HTML page filled with information about the plugins and the
     * context.
     *
     * @return an HTML page filled with information about the plugins and the
     *         context.
     */
    @RequestMapping("/")
    public String index() {

        StringBuilder content = new StringBuilder();

        content.append("<html><head><title>");
        content.append("Spring Boot Plugin Example");
        content.append("</title></head><body>");

        content.append("<h1>Plugins</h1>");
        if (plugins.isEmpty()) {
            content.append("none");
        } else {
            content.append("<ul>");
            plugins.forEach(plugin -> content.append(String.format("<li>%s</li>", plugin.getName())));
            content.append("</ul>");
        }

        content.append("<h1>Plugins with initialization errors</h1>");
        if (pluginsWithInitError.isEmpty()) {
            content.append("none");
        } else {
            content.append("<ul>");
            pluginsWithInitError.forEach((plugin, msg) -> content.append(String.format("<li>%s: %s</li>", plugin, msg)));
            content.append("</ul>");
        }

        content.append("<b>doSomething() is called on all plugins each time this page is refreshed.</b></br>");

        for (Plugin plugin : plugins) {
            try {
                plugin.doSomething();
            } catch (RuntimeException e) {
                content.append(
                        String.format("%s threw an %s: %s<br/>", plugin.getName(), e.getClass().getSimpleName(),
                                e.getMessage()));
            }
        }

        content.append("<h1>Context</h1>");
        if (context.get().isEmpty()) {
            content.append("Context is empty");
        } else {
            content.append("<ul>");
            context.get().forEach(msg -> content.append(String.format("<li>%s</li>", msg)));
            content.append("</ul>");
        }
        content.append("</body></html>");

        return content.toString();
    }

}
