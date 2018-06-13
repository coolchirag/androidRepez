package javax.mail;

import java.util.Vector;
import javax.mail.event.MailEvent;

class EventQueue implements Runnable {
    private QueueElement head = null;
    private Thread qThread = new Thread(this, "JavaMail-EventQueue");
    private QueueElement tail = null;

    class QueueElement {
        MailEvent event = null;
        QueueElement next = null;
        QueueElement prev = null;
        Vector vector = null;

        QueueElement(MailEvent mailEvent, Vector vector) {
            this.event = mailEvent;
            this.vector = vector;
        }
    }

    public EventQueue() {
        this.qThread.setDaemon(true);
        this.qThread.start();
    }

    private synchronized QueueElement dequeue() {
        QueueElement queueElement;
        while (this.tail == null) {
            wait();
        }
        queueElement = this.tail;
        this.tail = queueElement.prev;
        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }
        queueElement.next = null;
        queueElement.prev = null;
        return queueElement;
    }

    public synchronized void enqueue(MailEvent mailEvent, Vector vector) {
        QueueElement queueElement = new QueueElement(mailEvent, vector);
        if (this.head == null) {
            this.head = queueElement;
            this.tail = queueElement;
        } else {
            queueElement.next = this.head;
            this.head.prev = queueElement;
            this.head = queueElement;
        }
        notifyAll();
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
    L_0x0000:
        r0 = r4.dequeue();	 Catch:{ InterruptedException -> 0x0024 }
        if (r0 != 0) goto L_0x0007;	 Catch:{ InterruptedException -> 0x0024 }
    L_0x0006:
        return;	 Catch:{ InterruptedException -> 0x0024 }
    L_0x0007:
        r2 = r0.event;	 Catch:{ InterruptedException -> 0x0024 }
        r3 = r0.vector;	 Catch:{ InterruptedException -> 0x0024 }
        r0 = 0;	 Catch:{ InterruptedException -> 0x0024 }
        r1 = r0;	 Catch:{ InterruptedException -> 0x0024 }
    L_0x000d:
        r0 = r3.size();	 Catch:{ InterruptedException -> 0x0024 }
        if (r1 >= r0) goto L_0x0000;
    L_0x0013:
        r0 = r3.elementAt(r1);	 Catch:{ Throwable -> 0x001e }
        r2.dispatch(r0);	 Catch:{ Throwable -> 0x001e }
    L_0x001a:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x000d;
    L_0x001e:
        r0 = move-exception;
        r0 = r0 instanceof java.lang.InterruptedException;	 Catch:{ InterruptedException -> 0x0024 }
        if (r0 != 0) goto L_0x0006;
    L_0x0023:
        goto L_0x001a;
    L_0x0024:
        r0 = move-exception;
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.EventQueue.run():void");
    }

    void stop() {
        if (this.qThread != null) {
            this.qThread.interrupt();
            this.qThread = null;
        }
    }
}
