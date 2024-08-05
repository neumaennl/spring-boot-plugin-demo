package de.neumaennl.springboot.plugin.demo.api;

/**
 * This exception is thrown by a plugin if it can not initialize itself.
 *
 * @author Martin Neumann - <a href="http://www.brain-child.de">brainchild
 *         GmbH</a>
 */
public class PluginInitializationException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new {@code PluginInitializationException} with the specified
     * detail message, cause, suppression enabled or disabled, and writable
     * stack trace enabled or disabled.
     *
     * @param message
     *            the detail message.
     * @param cause
     *            the cause. (A {@code null} value is permitted,and indicates
     *            that the cause is nonexistent or unknown.)
     * @param enableSuppression
     *            whether or not suppression is enabled or disabled
     * @param writableStackTrace
     *            whether or not the stack trace should be writable
     */
    public PluginInitializationException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {

        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Creates a new {@code PluginInitializationException} with the specified
     * detail message and cause.
     * <p>
     * Note that the detail message associated with {@code cause} is <i>not</i>
     * automatically incorporated in this exception's detail message.
     *
     * @param message
     *            the detail message (which is saved for later retrieval by the
     *            {@link #getMessage()} method).
     * @param cause
     *            the cause (which is saved for later retrieval by the
     *            {@link #getCause()} method). (A {@code null} value is
     *            permitted, and indicates that the cause is nonexistent or
     *            unknown.)
     */
    public PluginInitializationException(String message, Throwable cause) {

        super(message, cause);
    }

    /**
     * Creates a new {@code PluginInitializationException} with the specified
     * detail message. The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause(Throwable) initCause}.
     *
     * @param message
     *            the detail message. The detail message is saved for later
     *            retrieval by the {@link #getMessage()} method.
     */
    public PluginInitializationException(String message) {

        super(message);
    }

    /**
     * Creates a new {@code PluginInitializationException} with the specified
     * cause and a detail message of
     * {@code (cause==null ? null : cause.toString())} (which typically contains
     * the class and detail message of cause).This constructor is useful for
     * exceptions that are little more than wrappers for other throwables.
     *
     * @param cause
     *            the cause (which is saved for later retrieval by the
     *            {@link #getCause()} method). (A {@code null} value is
     *            permitted, and indicates that the cause is nonexistent or
     *            unknown.)
     */
    public PluginInitializationException(Throwable cause) {

        super(cause);
    }

}
