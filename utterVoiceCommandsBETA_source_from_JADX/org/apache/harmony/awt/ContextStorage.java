package org.apache.harmony.awt;

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import org.apache.harmony.awt.datatransfer.DTK;

public final class ContextStorage {
    private static final ContextStorage globalContext = new ContextStorage();
    private final Object contextLock = new ContextLock();
    private DTK dtk;
    private GraphicsEnvironment graphicsEnvironment;
    private volatile boolean shutdownPending = false;
    private Toolkit toolkit;

    class ContextLock {
        private ContextLock() {
        }
    }

    public static Object getContextLock() {
        return getCurrentContext().contextLock;
    }

    private static ContextStorage getCurrentContext() {
        return globalContext;
    }

    public static DTK getDTK() {
        return getCurrentContext().dtk;
    }

    public static Toolkit getDefaultToolkit() {
        return getCurrentContext().toolkit;
    }

    public static GraphicsEnvironment getGraphicsEnvironment() {
        return getCurrentContext().graphicsEnvironment;
    }

    public static void setDTK(DTK dtk) {
        getCurrentContext().dtk = dtk;
    }

    public static void setDefaultToolkit(Toolkit toolkit) {
        getCurrentContext().toolkit = toolkit;
    }

    public static void setGraphicsEnvironment(GraphicsEnvironment graphicsEnvironment) {
        getCurrentContext().graphicsEnvironment = graphicsEnvironment;
    }

    public static boolean shutdownPending() {
        return getCurrentContext().shutdownPending;
    }

    final void shutdown() {
    }
}
