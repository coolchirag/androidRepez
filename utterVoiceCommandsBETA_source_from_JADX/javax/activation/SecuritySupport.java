package javax.activation;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

class SecuritySupport {

    class C05381 implements PrivilegedAction {
        C05381() {
        }

        public Object run() {
            Object obj = null;
            try {
                obj = Thread.currentThread().getContextClassLoader();
            } catch (SecurityException e) {
            }
            return obj;
        }
    }

    class C05392 implements PrivilegedExceptionAction {
        private final /* synthetic */ Class val$c;
        private final /* synthetic */ String val$name;

        C05392(Class cls, String str) {
            this.val$c = cls;
            this.val$name = str;
        }

        public Object run() {
            return this.val$c.getResourceAsStream(this.val$name);
        }
    }

    class C05403 implements PrivilegedAction {
        private final /* synthetic */ ClassLoader val$cl;
        private final /* synthetic */ String val$name;

        C05403(ClassLoader classLoader, String str) {
            this.val$cl = classLoader;
            this.val$name = str;
        }

        public Object run() {
            try {
                List arrayList = new ArrayList();
                Enumeration resources = this.val$cl.getResources(this.val$name);
                while (resources != null && resources.hasMoreElements()) {
                    URL url = (URL) resources.nextElement();
                    if (url != null) {
                        arrayList.add(url);
                    }
                }
                if (arrayList.size() <= 0) {
                    return null;
                }
                Object obj = new URL[arrayList.size()];
                try {
                    return (URL[]) arrayList.toArray(obj);
                } catch (IOException e) {
                    return obj;
                } catch (SecurityException e2) {
                    return obj;
                }
            } catch (IOException e3) {
                return null;
            } catch (SecurityException e4) {
                return null;
            }
        }
    }

    class C05414 implements PrivilegedAction {
        private final /* synthetic */ String val$name;

        C05414(String str) {
            this.val$name = str;
        }

        public Object run() {
            try {
                List arrayList = new ArrayList();
                Enumeration systemResources = ClassLoader.getSystemResources(this.val$name);
                while (systemResources != null && systemResources.hasMoreElements()) {
                    URL url = (URL) systemResources.nextElement();
                    if (url != null) {
                        arrayList.add(url);
                    }
                }
                if (arrayList.size() <= 0) {
                    return null;
                }
                Object obj = new URL[arrayList.size()];
                try {
                    return (URL[]) arrayList.toArray(obj);
                } catch (IOException e) {
                    return obj;
                } catch (SecurityException e2) {
                    return obj;
                }
            } catch (IOException e3) {
                return null;
            } catch (SecurityException e4) {
                return null;
            }
        }
    }

    class C05425 implements PrivilegedExceptionAction {
        private final /* synthetic */ URL val$url;

        C05425(URL url) {
            this.val$url = url;
        }

        public Object run() {
            return this.val$url.openStream();
        }
    }

    private SecuritySupport() {
    }

    public static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new C05381());
    }

    public static InputStream getResourceAsStream(Class cls, String str) {
        try {
            return (InputStream) AccessController.doPrivileged(new C05392(cls, str));
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getException());
        }
    }

    public static URL[] getResources(ClassLoader classLoader, String str) {
        return (URL[]) AccessController.doPrivileged(new C05403(classLoader, str));
    }

    public static URL[] getSystemResources(String str) {
        return (URL[]) AccessController.doPrivileged(new C05414(str));
    }

    public static InputStream openStream(URL url) {
        try {
            return (InputStream) AccessController.doPrivileged(new C05425(url));
        } catch (PrivilegedActionException e) {
            throw ((IOException) e.getException());
        }
    }
}
