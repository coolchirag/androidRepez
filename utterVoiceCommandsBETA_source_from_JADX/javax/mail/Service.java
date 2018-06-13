package javax.mail;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Vector;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.MailEvent;

public abstract class Service {
    private boolean connected = false;
    private Vector connectionListeners = null;
    protected boolean debug = false;
    private EventQueue f3049q;
    private Object qLock = new Object();
    protected Session session;
    protected URLName url = null;

    class TerminatorEvent extends MailEvent {
        private static final long serialVersionUID = 5542172141759168416L;

        TerminatorEvent() {
            super(new Object());
        }

        public void dispatch(Object obj) {
            Thread.currentThread().interrupt();
        }
    }

    protected Service(Session session, URLName uRLName) {
        this.session = session;
        this.url = uRLName;
        this.debug = session.getDebug();
    }

    private void terminateQueue() {
        synchronized (this.qLock) {
            if (this.f3049q != null) {
                Vector vector = new Vector();
                vector.setSize(1);
                this.f3049q.enqueue(new TerminatorEvent(), vector);
                this.f3049q = null;
            }
        }
    }

    public synchronized void addConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners == null) {
            this.connectionListeners = new Vector();
        }
        this.connectionListeners.addElement(connectionListener);
    }

    public synchronized void close() {
        setConnected(false);
        notifyConnectionListeners(3);
    }

    public void connect() {
        connect(null, null, null);
    }

    public synchronized void connect(String str, int i, String str2, String str3) {
        if (isConnected()) {
            throw new IllegalStateException("already connected");
        }
        String host;
        int port;
        String password;
        String str4;
        String str5;
        String str6;
        Object obj;
        AuthenticationFailedException authenticationFailedException;
        InetAddress byName;
        PasswordAuthentication requestPasswordAuthentication;
        String password2;
        boolean protocolConnect;
        boolean z = false;
        String str7 = null;
        String str8 = null;
        if (this.url != null) {
            str7 = this.url.getProtocol();
            host = str == null ? this.url.getHost() : str;
            port = i == -1 ? this.url.getPort() : i;
            if (str2 == null) {
                str2 = this.url.getUsername();
                if (str3 == null) {
                    password = this.url.getPassword();
                    str4 = str2;
                }
                password = str3;
                str4 = str2;
            } else {
                if (str3 == null) {
                    if (str2.equals(this.url.getUsername())) {
                        password = this.url.getPassword();
                        str4 = str2;
                    }
                }
                password = str3;
                str4 = str2;
            }
            str8 = this.url.getFile();
        } else {
            password = str3;
            str4 = str2;
            port = i;
            host = str;
        }
        if (str7 != null) {
            if (host == null) {
                host = this.session.getProperty("mail." + str7 + ".host");
            }
            if (str4 == null) {
                str4 = this.session.getProperty("mail." + str7 + ".user");
            }
        }
        if (host == null) {
            host = this.session.getProperty("mail.host");
        }
        if (str4 == null) {
            str4 = this.session.getProperty("mail.user");
        }
        if (str4 == null) {
            try {
                str4 = System.getProperty("user.name");
            } catch (SecurityException e) {
                if (this.debug) {
                    e.printStackTrace(this.session.getDebugOut());
                }
            }
        }
        if (password == null) {
            if (this.url != null) {
                setURLName(new URLName(str7, host, port, str8, str4, null));
                PasswordAuthentication passwordAuthentication = this.session.getPasswordAuthentication(getURLName());
                if (passwordAuthentication == null) {
                    int i2 = 1;
                    str5 = str4;
                    str6 = password;
                } else if (str4 == null) {
                    str4 = passwordAuthentication.getUserName();
                    str6 = passwordAuthentication.getPassword();
                    obj = null;
                    str5 = str4;
                } else if (str4.equals(passwordAuthentication.getUserName())) {
                    str6 = passwordAuthentication.getPassword();
                    obj = null;
                    str5 = str4;
                }
                z = protocolConnect(host, port, str5, str6);
                authenticationFailedException = null;
                if (!z) {
                    try {
                        byName = InetAddress.getByName(host);
                    } catch (UnknownHostException e2) {
                        byName = null;
                    }
                    requestPasswordAuthentication = this.session.requestPasswordAuthentication(byName, port, str7, null, str5);
                    if (requestPasswordAuthentication != null) {
                        str5 = requestPasswordAuthentication.getUserName();
                        password2 = requestPasswordAuthentication.getPassword();
                        protocolConnect = protocolConnect(host, port, str5, password2);
                        str4 = str5;
                        if (protocolConnect) {
                            setURLName(new URLName(str7, host, port, str8, str4, password2));
                            if (obj != null) {
                                this.session.setPasswordAuthentication(getURLName(), new PasswordAuthentication(str4, password2));
                            }
                            setConnected(true);
                            notifyConnectionListeners(1);
                        } else if (authenticationFailedException == null) {
                            throw authenticationFailedException;
                        } else {
                            throw new AuthenticationFailedException();
                        }
                    }
                }
                password2 = str6;
                str4 = str5;
                protocolConnect = z;
                if (protocolConnect) {
                    setURLName(new URLName(str7, host, port, str8, str4, password2));
                    if (obj != null) {
                        this.session.setPasswordAuthentication(getURLName(), new PasswordAuthentication(str4, password2));
                    }
                    setConnected(true);
                    notifyConnectionListeners(1);
                } else if (authenticationFailedException == null) {
                    throw new AuthenticationFailedException();
                } else {
                    throw authenticationFailedException;
                }
            }
        }
        obj = null;
        str6 = password;
        str5 = str4;
        try {
            z = protocolConnect(host, port, str5, str6);
            authenticationFailedException = null;
        } catch (AuthenticationFailedException e3) {
            authenticationFailedException = e3;
        }
        if (z) {
            byName = InetAddress.getByName(host);
            requestPasswordAuthentication = this.session.requestPasswordAuthentication(byName, port, str7, null, str5);
            if (requestPasswordAuthentication != null) {
                str5 = requestPasswordAuthentication.getUserName();
                password2 = requestPasswordAuthentication.getPassword();
                protocolConnect = protocolConnect(host, port, str5, password2);
                str4 = str5;
                if (protocolConnect) {
                    setURLName(new URLName(str7, host, port, str8, str4, password2));
                    if (obj != null) {
                        this.session.setPasswordAuthentication(getURLName(), new PasswordAuthentication(str4, password2));
                    }
                    setConnected(true);
                    notifyConnectionListeners(1);
                } else if (authenticationFailedException == null) {
                    throw authenticationFailedException;
                } else {
                    throw new AuthenticationFailedException();
                }
            }
        }
        password2 = str6;
        str4 = str5;
        protocolConnect = z;
        if (protocolConnect) {
            setURLName(new URLName(str7, host, port, str8, str4, password2));
            if (obj != null) {
                this.session.setPasswordAuthentication(getURLName(), new PasswordAuthentication(str4, password2));
            }
            setConnected(true);
            notifyConnectionListeners(1);
        } else if (authenticationFailedException == null) {
            throw new AuthenticationFailedException();
        } else {
            throw authenticationFailedException;
        }
    }

    public void connect(String str, String str2) {
        connect(null, str, str2);
    }

    public void connect(String str, String str2, String str3) {
        connect(str, -1, str2, str3);
    }

    public void finalize() {
        super.finalize();
        terminateQueue();
    }

    public synchronized URLName getURLName() {
        URLName uRLName;
        uRLName = (this.url == null || (this.url.getPassword() == null && this.url.getFile() == null)) ? this.url : new URLName(this.url.getProtocol(), this.url.getHost(), this.url.getPort(), null, this.url.getUsername(), null);
        return uRLName;
    }

    public synchronized boolean isConnected() {
        return this.connected;
    }

    protected synchronized void notifyConnectionListeners(int i) {
        if (this.connectionListeners != null) {
            queueEvent(new ConnectionEvent(this, i), this.connectionListeners);
        }
        if (i == 3) {
            terminateQueue();
        }
    }

    protected boolean protocolConnect(String str, int i, String str2, String str3) {
        return false;
    }

    protected void queueEvent(MailEvent mailEvent, Vector vector) {
        synchronized (this.qLock) {
            if (this.f3049q == null) {
                this.f3049q = new EventQueue();
            }
        }
        this.f3049q.enqueue(mailEvent, (Vector) vector.clone());
    }

    public synchronized void removeConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners != null) {
            this.connectionListeners.removeElement(connectionListener);
        }
    }

    protected synchronized void setConnected(boolean z) {
        this.connected = z;
    }

    protected synchronized void setURLName(URLName uRLName) {
        this.url = uRLName;
    }

    public String toString() {
        URLName uRLName = getURLName();
        return uRLName != null ? uRLName.toString() : super.toString();
    }
}
