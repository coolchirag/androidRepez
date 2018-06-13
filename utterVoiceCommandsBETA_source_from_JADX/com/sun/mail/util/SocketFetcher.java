package com.sun.mail.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SocketFetcher {

    class C05361 implements PrivilegedAction {
        C05361() {
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

    private SocketFetcher() {
    }

    private static void configureSSLSocket(Socket socket, Properties properties, String str) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            String property = properties.getProperty(new StringBuilder(String.valueOf(str)).append(".ssl.protocols").toString(), null);
            if (property != null) {
                sSLSocket.setEnabledProtocols(stringArray(property));
            } else {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1"});
            }
            property = properties.getProperty(new StringBuilder(String.valueOf(str)).append(".ssl.ciphersuites").toString(), null);
            if (property != null) {
                sSLSocket.setEnabledCipherSuites(stringArray(property));
            }
        }
    }

    private static Socket createSocket(InetAddress inetAddress, int i, String str, int i2, int i3, SocketFactory socketFactory, boolean z) {
        Socket createSocket = socketFactory != null ? socketFactory.createSocket() : z ? SSLSocketFactory.getDefault().createSocket() : new Socket();
        if (inetAddress != null) {
            createSocket.bind(new InetSocketAddress(inetAddress, i));
        }
        if (i3 >= 0) {
            createSocket.connect(new InetSocketAddress(str, i2), i3);
        } else {
            createSocket.connect(new InetSocketAddress(str, i2));
        }
        return createSocket;
    }

    private static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new C05361());
    }

    public static Socket getSocket(String str, int i, Properties properties, String str2) {
        return getSocket(str, i, properties, str2, false);
    }

    public static Socket getSocket(String str, int i, Properties properties, String str2, boolean z) {
        Socket createSocket;
        Socket createSocket2;
        int i2;
        if (str2 == null) {
            str2 = "socket";
        }
        if (properties == null) {
            properties = new Properties();
        }
        String property = properties.getProperty(new StringBuilder(String.valueOf(str2)).append(".connectiontimeout").toString(), null);
        int i3 = -1;
        if (property != null) {
            try {
                i3 = Integer.parseInt(property);
            } catch (NumberFormatException e) {
            }
        }
        String property2 = properties.getProperty(new StringBuilder(String.valueOf(str2)).append(".timeout").toString(), null);
        String property3 = properties.getProperty(new StringBuilder(String.valueOf(str2)).append(".localaddress").toString(), null);
        InetAddress inetAddress = null;
        if (property3 != null) {
            inetAddress = InetAddress.getByName(property3);
        }
        String property4 = properties.getProperty(new StringBuilder(String.valueOf(str2)).append(".localport").toString(), null);
        int i4 = 0;
        if (property4 != null) {
            try {
                i4 = Integer.parseInt(property4);
            } catch (NumberFormatException e2) {
            }
        }
        property4 = properties.getProperty(new StringBuilder(String.valueOf(str2)).append(".socketFactory.fallback").toString(), null);
        if (property4 == null || !property4.equalsIgnoreCase("false")) {
            int i5 = 1;
        } else {
            Object obj = null;
        }
        String property5 = properties.getProperty(new StringBuilder(String.valueOf(str2)).append(".socketFactory.class").toString(), null);
        int i6 = -1;
        try {
            SocketFactory socketFactory = getSocketFactory(property5);
            if (socketFactory != null) {
                property4 = properties.getProperty(new StringBuilder(String.valueOf(str2)).append(".socketFactory.port").toString(), null);
                if (property4 != null) {
                    try {
                        i6 = Integer.parseInt(property4);
                    } catch (NumberFormatException e3) {
                    }
                }
                if (i6 == -1) {
                    i6 = i;
                }
                createSocket = createSocket(inetAddress, i4, str, i6, i3, socketFactory, z);
                createSocket2 = createSocket != null ? createSocket(inetAddress, i4, str, i, i3, null, z) : createSocket;
                i2 = -1;
                if (property2 != null) {
                    try {
                        i2 = Integer.parseInt(property2);
                    } catch (NumberFormatException e4) {
                    }
                }
                if (i2 >= 0) {
                    createSocket2.setSoTimeout(i2);
                }
                configureSSLSocket(createSocket2, properties, str2);
                return createSocket2;
            }
        } catch (SocketTimeoutException e5) {
            throw e5;
        } catch (Throwable e6) {
            if (obj == null) {
                Throwable targetException;
                IOException iOException;
                if (e6 instanceof InvocationTargetException) {
                    targetException = ((InvocationTargetException) e6).getTargetException();
                    if (targetException instanceof Exception) {
                        targetException = (Exception) targetException;
                        if (targetException instanceof IOException) {
                            iOException = new IOException("Couldn't connect using \"" + property5 + "\" socket factory to host, port: " + str + ", " + i6 + "; Exception: " + targetException);
                            iOException.initCause(targetException);
                            throw iOException;
                        }
                        throw ((IOException) targetException);
                    }
                }
                targetException = e6;
                if (targetException instanceof IOException) {
                    iOException = new IOException("Couldn't connect using \"" + property5 + "\" socket factory to host, port: " + str + ", " + i6 + "; Exception: " + targetException);
                    iOException.initCause(targetException);
                    throw iOException;
                }
                throw ((IOException) targetException);
            }
        }
        createSocket = null;
        if (createSocket != null) {
        }
        i2 = -1;
        if (property2 != null) {
            i2 = Integer.parseInt(property2);
        }
        if (i2 >= 0) {
            createSocket2.setSoTimeout(i2);
        }
        configureSSLSocket(createSocket2, properties, str2);
        return createSocket2;
    }

    private static SocketFactory getSocketFactory(String str) {
        Class cls = null;
        if (str == null || str.length() == 0) {
            return cls;
        }
        ClassLoader contextClassLoader = getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                cls = contextClassLoader.loadClass(str);
            } catch (ClassNotFoundException e) {
            }
        }
        if (cls == null) {
            cls = Class.forName(str);
        }
        return (SocketFactory) cls.getMethod("getDefault", new Class[0]).invoke(new Object(), new Object[0]);
    }

    public static Socket startTLS(Socket socket) {
        return startTLS(socket, new Properties(), "socket");
    }

    public static Socket startTLS(Socket socket, Properties properties, String str) {
        Throwable targetException;
        IOException iOException;
        String hostName = socket.getInetAddress().getHostName();
        int port = socket.getPort();
        try {
            SocketFactory socketFactory = getSocketFactory(properties.getProperty(new StringBuilder(String.valueOf(str)).append(".socketFactory.class").toString(), null));
            SSLSocketFactory sSLSocketFactory = (socketFactory == null || !(socketFactory instanceof SSLSocketFactory)) ? (SSLSocketFactory) SSLSocketFactory.getDefault() : (SSLSocketFactory) socketFactory;
            Socket createSocket = sSLSocketFactory.createSocket(socket, hostName, port, true);
            configureSSLSocket(createSocket, properties, str);
            return createSocket;
        } catch (Throwable e) {
            if (e instanceof InvocationTargetException) {
                targetException = ((InvocationTargetException) e).getTargetException();
                if (targetException instanceof Exception) {
                    targetException = (Exception) targetException;
                    if (targetException instanceof IOException) {
                        iOException = new IOException("Exception in startTLS: host " + hostName + ", port " + port + "; Exception: " + targetException);
                        iOException.initCause(targetException);
                        throw iOException;
                    }
                    throw ((IOException) targetException);
                }
            }
            targetException = e;
            if (targetException instanceof IOException) {
                iOException = new IOException("Exception in startTLS: host " + hostName + ", port " + port + "; Exception: " + targetException);
                iOException.initCause(targetException);
                throw iOException;
            }
            throw ((IOException) targetException);
        }
    }

    private static String[] stringArray(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        List arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
