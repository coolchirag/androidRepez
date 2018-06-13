package javax.mail;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;

public abstract class Transport extends Service {
    private Vector transportListeners = null;

    public Transport(Session session, URLName uRLName) {
        super(session, uRLName);
    }

    public static void send(Message message) {
        message.saveChanges();
        send0(message, message.getAllRecipients());
    }

    public static void send(Message message, Address[] addressArr) {
        message.saveChanges();
        send0(message, addressArr);
    }

    private static void send0(Message message, Address[] addressArr) {
        Address[] addressArr2 = null;
        if (addressArr == null || addressArr.length == 0) {
            throw new SendFailedException("No recipient addresses");
        }
        int i;
        Hashtable hashtable = new Hashtable();
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (i = 0; i < addressArr.length; i++) {
            if (hashtable.containsKey(addressArr[i].getType())) {
                ((Vector) hashtable.get(addressArr[i].getType())).addElement(addressArr[i]);
            } else {
                Vector vector4 = new Vector();
                vector4.addElement(addressArr[i]);
                hashtable.put(addressArr[i].getType(), vector4);
            }
        }
        i = hashtable.size();
        if (i == 0) {
            throw new SendFailedException("No recipient addresses");
        }
        Session defaultInstance = message.session != null ? message.session : Session.getDefaultInstance(System.getProperties(), null);
        if (i == 1) {
            Transport transport = defaultInstance.getTransport(addressArr[0]);
            try {
                transport.connect();
                transport.sendMessage(message, addressArr);
            } finally {
                transport.close();
            }
        } else {
            Enumeration elements = hashtable.elements();
            i = 0;
            Exception exception = null;
            while (elements.hasMoreElements()) {
                vector4 = (Vector) elements.nextElement();
                Address[] addressArr3 = new Address[vector4.size()];
                vector4.copyInto(addressArr3);
                Transport transport2 = defaultInstance.getTransport(addressArr3[0]);
                if (transport2 == null) {
                    for (Object addElement : addressArr3) {
                        vector.addElement(addElement);
                    }
                } else {
                    try {
                        transport2.connect();
                        transport2.sendMessage(message, addressArr3);
                        transport2.close();
                    } catch (Exception e) {
                        if (exception == null) {
                            exception = e;
                        } else {
                            exception.setNextException(e);
                        }
                        addressArr3 = e.getInvalidAddresses();
                        if (addressArr3 != null) {
                            for (Object addElement2 : addressArr3) {
                                vector.addElement(addElement2);
                            }
                        }
                        addressArr3 = e.getValidSentAddresses();
                        if (addressArr3 != null) {
                            for (Object addElement22 : addressArr3) {
                                vector2.addElement(addElement22);
                            }
                        }
                        Address[] validUnsentAddresses = e.getValidUnsentAddresses();
                        if (validUnsentAddresses != null) {
                            for (Object addElement3 : validUnsentAddresses) {
                                vector3.addElement(addElement3);
                            }
                        }
                        transport2.close();
                        i = 1;
                    } catch (Exception e2) {
                        if (exception == null) {
                            exception = e2;
                        } else {
                            exception.setNextException(e2);
                        }
                        transport2.close();
                        i = 1;
                    } catch (Throwable th) {
                        transport2.close();
                    }
                }
            }
            if (i != 0 || vector.size() != 0 || vector3.size() != 0) {
                Address[] addressArr4;
                Address[] addressArr5;
                if (vector2.size() > 0) {
                    addressArr4 = new Address[vector2.size()];
                    vector2.copyInto(addressArr4);
                } else {
                    addressArr4 = null;
                }
                if (vector3.size() > 0) {
                    addressArr5 = new Address[vector3.size()];
                    vector3.copyInto(addressArr5);
                } else {
                    addressArr5 = null;
                }
                if (vector.size() > 0) {
                    addressArr2 = new Address[vector.size()];
                    vector.copyInto(addressArr2);
                }
                throw new SendFailedException("Sending failed", exception, addressArr4, addressArr5, addressArr2);
            }
        }
    }

    public synchronized void addTransportListener(TransportListener transportListener) {
        if (this.transportListeners == null) {
            this.transportListeners = new Vector();
        }
        this.transportListeners.addElement(transportListener);
    }

    protected void notifyTransportListeners(int i, Address[] addressArr, Address[] addressArr2, Address[] addressArr3, Message message) {
        if (this.transportListeners != null) {
            queueEvent(new TransportEvent(this, i, addressArr, addressArr2, addressArr3, message), this.transportListeners);
        }
    }

    public synchronized void removeTransportListener(TransportListener transportListener) {
        if (this.transportListeners != null) {
            this.transportListeners.removeElement(transportListener);
        }
    }

    public abstract void sendMessage(Message message, Address[] addressArr);
}
