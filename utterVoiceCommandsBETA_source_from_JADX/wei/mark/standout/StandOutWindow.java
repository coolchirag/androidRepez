package wei.mark.standout;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public abstract class StandOutWindow extends Service {
    private static Map<Class<? extends StandOutWindow>, Map<Integer, Window>> f758a = new HashMap();
    private static Window f759b = null;
    private WindowManager f760c;
    private NotificationManager f761d;
    private LayoutInflater f762e;
    private boolean f763f;

    public class Window extends FrameLayout {
        StandOutWindow f3121a;
        public Class<? extends StandOutWindow> f3122b = this.f3121a.getClass();
        public int f3123c;
        public boolean f3124d;
        public C0623o f3125e;
        public Bundle f3126f;
        final /* synthetic */ StandOutWindow f3127g;

        public Window(StandOutWindow standOutWindow, int i) {
            View inflate;
            View findViewById;
            this.f3127g = standOutWindow;
            super(standOutWindow);
            standOutWindow.setTheme(StandOutWindow.m753f());
            this.f3121a = standOutWindow;
            this.f3123c = i;
            this.f3125e = new C0623o(this);
            this.f3126f = new Bundle();
            int c = standOutWindow.mo71c();
            if (C0624p.m2851a(c, C0616h.f3150a)) {
                inflate = this.f3127g.f762e.inflate(C0612d.f3138a, null);
                ((ImageView) inflate.findViewById(C0611c.f3131b)).setImageResource(this.f3127g.mo69b());
                TextView textView = (TextView) inflate.findViewById(C0611c.f3133d);
                StandOutWindow standOutWindow2 = this.f3127g;
                int i2 = this.f3123c;
                textView.setText(standOutWindow2.m773e());
                findViewById = inflate.findViewById(C0611c.f3134e);
                findViewById.setOnClickListener(new C0618j(this));
                findViewById.setVisibility(8);
                View findViewById2 = inflate.findViewById(C0611c.f3137h);
                findViewById2.setOnClickListener(new C0619k(this));
                View findViewById3 = inflate.findViewById(C0611c.f3136g);
                findViewById3.setOnTouchListener(new C0620l(this));
                View findViewById4 = inflate.findViewById(C0611c.f3135f);
                findViewById4.setOnTouchListener(new C0621m(this));
                StandOutWindow standOutWindow3 = this.f3127g;
                int i3 = this.f3123c;
                int c2 = standOutWindow3.mo71c();
                if (C0624p.m2851a(c2, C0616h.f3155f)) {
                    findViewById.setVisibility(0);
                }
                if (C0624p.m2851a(c2, C0616h.f3151b)) {
                    findViewById2.setVisibility(8);
                }
                if (C0624p.m2851a(c2, C0616h.f3153d)) {
                    findViewById3.setOnTouchListener(null);
                }
                if (C0624p.m2851a(c2, C0616h.f3152c)) {
                    findViewById4.setVisibility(8);
                }
                findViewById = (FrameLayout) inflate.findViewById(C0611c.f3132c);
            } else {
                inflate = new FrameLayout(this.f3121a);
                inflate.setId(C0611c.f3130a);
                FrameLayout frameLayout = (FrameLayout) inflate;
            }
            addView(inflate);
            findViewById.setOnTouchListener(new C0617i(this, c));
            standOutWindow.mo68a(i, (FrameLayout) findViewById);
            if (findViewById.getChildCount() == 0) {
                throw new RuntimeException("You must attach your view to the given frame in createAndAttachView()");
            }
            if (!C0624p.m2851a(c, C0616h.f3163n)) {
                m2846a(findViewById);
            }
            if (!C0624p.m2851a(c, C0616h.f3164o)) {
                StandOutWindow standOutWindow4 = this.f3127g;
                c = this.f3123c;
                if (!C0624p.m2851a(standOutWindow4.mo71c(), C0616h.f3165p)) {
                    inflate = findViewById.findViewById(C0611c.f3135f);
                    if (inflate != null) {
                        inflate.setOnTouchListener(new C0622n(this));
                    }
                }
            }
            setTag(findViewById.getTag());
        }

        private static void m2846a(View view) {
            Queue linkedList = new LinkedList();
            linkedList.add(view);
            while (true) {
                View view2 = (View) linkedList.poll();
                if (view2 != null) {
                    if (view2 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        for (int i = 0; i < viewGroup.getChildCount(); i++) {
                            linkedList.add(viewGroup.getChildAt(i));
                        }
                    }
                } else {
                    return;
                }
            }
        }

        public final C0615g m2847a() {
            C0615g c0615g = (C0615g) super.getLayoutParams();
            return c0615g == null ? this.f3127g.mo67a(this.f3123c) : c0615g;
        }

        public final boolean m2848a(boolean z) {
            StandOutWindow standOutWindow = this.f3127g;
            int i = this.f3123c;
            int c = standOutWindow.mo71c();
            if (C0624p.m2851a(c, C0616h.f3161l)) {
                return false;
            }
            StandOutWindow standOutWindow2 = this.f3121a;
            i = this.f3123c;
            StandOutWindow.m757h();
            if (!C0624p.m2851a(c, C0616h.f3162m)) {
                View findViewById = findViewById(C0611c.f3130a);
                if (z) {
                    findViewById.setBackgroundResource(C0610b.f3129b);
                } else if (C0624p.m2851a(c, C0616h.f3150a)) {
                    findViewById.setBackgroundResource(C0610b.f3128a);
                } else {
                    findViewById.setBackgroundResource(0);
                }
            }
            C0615g a = m2847a();
            a.m2850a(z);
            standOutWindow = this.f3121a;
            i = this.f3123c;
            standOutWindow.m766a(this, a);
            if (z) {
                StandOutWindow.f759b = this;
            } else if (StandOutWindow.f759b == this) {
                StandOutWindow.f759b = null;
            }
            return true;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            StandOutWindow standOutWindow = this.f3127g;
            int i = this.f3123c;
            StandOutWindow.m759i();
            if (keyEvent.getAction() == 1) {
                switch (keyEvent.getKeyCode()) {
                    case 4:
                        this.f3127g.m752b(this);
                        return true;
                }
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        public /* synthetic */ LayoutParams getLayoutParams() {
            return m2847a();
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            C0615g a = m2847a();
            StandOutWindow standOutWindow = this.f3127g;
            int i = this.f3123c;
            int c = standOutWindow.mo71c();
            if (motionEvent.getAction() == 0 && StandOutWindow.f759b != this) {
                this.f3127g.m774e(this.f3123c);
            }
            if (motionEvent.getPointerCount() >= 2 && C0624p.m2851a(c, C0616h.f3160k)) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                float x2 = motionEvent.getX(1);
                float y2 = motionEvent.getY(1);
                x = Math.abs(x - x2);
                y = Math.abs(y - y2);
                switch (motionEvent.getAction() & 255) {
                    case 2:
                        double d = ((double) y) - this.f3125e.f3183j;
                        a.width = (int) ((((double) x) - this.f3125e.f3182i) + ((double) a.width));
                        a.height = (int) (((double) a.height) + d);
                        this.f3125e.f3182i = (double) x;
                        this.f3125e.f3183j = (double) y;
                        standOutWindow = this.f3127g;
                        i = this.f3123c;
                        standOutWindow.m766a(this, a);
                        break;
                    case 5:
                        this.f3125e.f3182i = (double) x;
                        this.f3125e.f3183j = (double) y;
                        this.f3125e.f3180g = this.f3125e.f3182i;
                        this.f3125e.f3181h = this.f3125e.f3183j;
                        break;
                }
            }
            return false;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 4:
                    if (StandOutWindow.f759b == this) {
                        this.f3127g.m752b(this);
                    }
                    StandOutWindow standOutWindow = this.f3127g;
                    int i = this.f3123c;
                    StandOutWindow.m755g();
                    break;
            }
            return true;
        }

        public void setLayoutParams(LayoutParams layoutParams) {
            if (layoutParams instanceof C0615g) {
                super.setLayoutParams(layoutParams);
                return;
            }
            throw new IllegalArgumentException("Window: LayoutParams must be an instance of StandOutWindow.LayoutParams.");
        }
    }

    public static void m740a(Context context, Class<? extends StandOutWindow> cls) {
        context.startService(m749b(context, (Class) cls));
    }

    public static void m741a(Context context, Class<? extends StandOutWindow> cls, int i) {
        boolean a = m743a(i, (Class) cls);
        context.startService(new Intent(context, cls).putExtra("id", i).setAction(a ? "RESTORE" : "SHOW").setData(a ? Uri.parse("standout://" + cls + '/' + i) : null));
    }

    private static boolean m743a(int i, Class<? extends StandOutWindow> cls) {
        return m751b(i, (Class) cls) != null;
    }

    private boolean m744a(int i, Window window, MotionEvent motionEvent) {
        boolean z = false;
        C0615g a = window.m2847a();
        int c = mo71c();
        int i2 = window.f3125e.f3176c - window.f3125e.f3174a;
        int i3 = window.f3125e.f3177d - window.f3125e.f3175b;
        switch (motionEvent.getAction()) {
            case 0:
                window.f3125e.f3176c = (int) motionEvent.getRawX();
                window.f3125e.f3177d = (int) motionEvent.getRawY();
                window.f3125e.f3174a = window.f3125e.f3176c;
                window.f3125e.f3175b = window.f3125e.f3177d;
                break;
            case 1:
                window.f3125e.f3184k = false;
                if (motionEvent.getPointerCount() == 1 && C0624p.m2851a(c, C0616h.f3158i) && a.gravity == 51) {
                    Display defaultDisplay = this.f760c.getDefaultDisplay();
                    int width = defaultDisplay.getWidth();
                    int height = defaultDisplay.getHeight();
                    a.x = Math.min(Math.max(a.x, 0), width - a.width);
                    a.y = Math.min(Math.max(a.y, 0), height - a.height);
                }
                if (Math.abs(i2) < a.f3143a && Math.abs(i3) < a.f3143a) {
                    z = true;
                }
                if (!z || !C0624p.m2851a(c, C0616h.f3157h)) {
                    if (C0624p.m2851a(c, C0616h.f3156g)) {
                        m756h(i);
                        break;
                    }
                }
                m756h(i);
                break;
                break;
            case 2:
                int rawX = ((int) motionEvent.getRawX()) - window.f3125e.f3176c;
                c = ((int) motionEvent.getRawY()) - window.f3125e.f3177d;
                window.f3125e.f3176c = (int) motionEvent.getRawX();
                window.f3125e.f3177d = (int) motionEvent.getRawY();
                if (window.f3125e.f3184k || Math.abs(i2) >= a.f3143a || Math.abs(i3) >= a.f3143a) {
                    window.f3125e.f3184k = true;
                    if (motionEvent.getPointerCount() == 1) {
                        a.x = rawX + a.x;
                        a.y += c;
                    }
                    m766a(window, a);
                    break;
                }
        }
        return true;
    }

    private boolean m745a(Window window, MotionEvent motionEvent) {
        C0615g a = window.m2847a();
        int c = mo71c();
        switch (motionEvent.getAction()) {
            case 0:
                window.f3125e.f3176c = (int) motionEvent.getRawX();
                window.f3125e.f3177d = (int) motionEvent.getRawY();
                window.f3125e.f3174a = window.f3125e.f3176c;
                window.f3125e.f3175b = window.f3125e.f3177d;
                a.f3148f = ((float) a.width) / ((float) a.height);
                break;
            case 2:
                int rawY = ((int) motionEvent.getRawY()) - window.f3125e.f3177d;
                a.width = (((int) motionEvent.getRawX()) - window.f3125e.f3176c) + a.width;
                a.height += rawY;
                if (a.width >= a.f3144b && a.width <= a.f3146d) {
                    window.f3125e.f3176c = (int) motionEvent.getRawX();
                }
                if (a.height >= a.f3145c && a.height <= a.f3147e) {
                    window.f3125e.f3177d = (int) motionEvent.getRawY();
                }
                a.width = Math.min(Math.max(a.width, a.f3144b), a.f3146d);
                a.height = Math.min(Math.max(a.height, a.f3145c), a.f3147e);
                if (C0624p.m2851a(c, C0616h.f3159j)) {
                    c = (int) (((float) a.height) * a.f3148f);
                    int i = (int) (((float) a.width) / a.f3148f);
                    if (i < a.f3145c || i > a.f3147e) {
                        a.width = c;
                    } else {
                        a.height = i;
                    }
                }
                m766a(window, a);
                break;
        }
        return true;
    }

    private static Intent m749b(Context context, Class<? extends StandOutWindow> cls) {
        return new Intent(context, cls).setAction("CLOSE_ALL");
    }

    private static Window m751b(int i, Class<? extends StandOutWindow> cls) {
        HashMap hashMap = (HashMap) f758a.get(cls);
        return hashMap == null ? null : (Window) hashMap.get(Integer.valueOf(i));
    }

    private synchronized boolean m752b(Window window) {
        boolean z = false;
        synchronized (this) {
            if (window != null) {
                z = window.m2848a(false);
            }
        }
        return z;
    }

    protected static int m753f() {
        return 0;
    }

    private synchronized Window m754g(int i) {
        View window;
        View i2 = m758i(i);
        window = i2 == null ? new Window(this, i) : i2;
        Animation b = mo70b(i);
        window.f3124d = true;
        try {
            this.f760c.addView(window, window.m2847a());
            if (b != null) {
                window.getChildAt(0).startAnimation(b);
            }
        } catch (Exception e) {
        }
        Class cls = getClass();
        HashMap hashMap = (HashMap) f758a.get(cls);
        if (hashMap == null) {
            hashMap = new HashMap();
            f758a.put(cls, hashMap);
        }
        hashMap.put(Integer.valueOf(i), window);
        int b2 = mo69b();
        long currentTimeMillis = System.currentTimeMillis();
        Context applicationContext = getApplicationContext();
        CharSequence a = mo66a();
        CharSequence charSequence = " is floating results...";
        Intent b3 = m749b((Context) this, getClass());
        PendingIntent pendingIntent = null;
        if (b3 != null) {
            pendingIntent = PendingIntent.getService(this, 0, b3, 134217728);
        }
        Notification notification = new Notification(b2, a, currentTimeMillis);
        notification.setLatestEventInfo(applicationContext, a, charSequence, pendingIntent);
        notification.flags |= 32;
        if (this.f763f) {
            this.f761d.notify(getClass().hashCode() - 1, notification);
        } else {
            startForeground(getClass().hashCode() - 1, notification);
            this.f763f = true;
        }
        m774e(i);
        return window;
    }

    protected static boolean m755g() {
        return false;
    }

    private synchronized void m756h(int i) {
        View i2 = m758i(i);
        if (i2 == null) {
            Log.w("StandOutWindow", "Tried to bringToFront() a null window.");
        } else {
            LayoutParams a = i2.m2847a();
            try {
                this.f760c.removeView(i2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.f760c.addView(i2, a);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    protected static boolean m757h() {
        return false;
    }

    private Window m758i(int i) {
        return m751b(i, getClass());
    }

    protected static boolean m759i() {
        return false;
    }

    private synchronized void m762l() {
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = (HashMap) f758a.get(getClass());
        for (Integer intValue : hashMap == null ? new HashSet() : hashMap.keySet()) {
            linkedList.add(Integer.valueOf(intValue.intValue()));
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            m772d(((Integer) it.next()).intValue());
        }
    }

    protected abstract String mo66a();

    protected abstract C0615g mo67a(int i);

    protected abstract void mo68a(int i, FrameLayout frameLayout);

    protected final void m766a(Window window, C0615g c0615g) {
        if (window == null) {
            Log.w("StandOutWindow", "Tried to updateViewLayout() a null window.");
            return;
        }
        try {
            window.setLayoutParams(c0615g);
            this.f760c.updateViewLayout(window, c0615g);
        } catch (Exception e) {
        }
    }

    protected abstract int mo69b();

    public Animation mo70b(int i) {
        return AnimationUtils.loadAnimation(this, 17432576);
    }

    protected int mo71c() {
        return 0;
    }

    protected final synchronized void m770c(int i) {
        if (C0624p.m2851a(mo71c(), C0616h.f3155f)) {
            int b = mo69b();
            long currentTimeMillis = System.currentTimeMillis();
            Notification notification = new Notification(b, String.format("%s: %s", new Object[]{mo66a() + " Hidden", ""}), currentTimeMillis);
            notification.setLatestEventInfo(getApplicationContext(), mo66a() + " Hidden", "", null);
            View i2 = m758i(i);
            if (i2 == null) {
                Log.w("StandOutWindow", "Tried to hide(" + i + ") a null window.");
            } else {
                Animation d = mo72d();
                i2.f3124d = false;
                if (d != null) {
                    try {
                        d.setAnimationListener(new C0613e(this, i2));
                        i2.getChildAt(0).startAnimation(d);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    this.f760c.removeView(i2);
                }
                notification.flags = (notification.flags | 32) | 16;
                this.f761d.notify(getClass().hashCode() + i, notification);
            }
        } else {
            m772d(i);
        }
    }

    protected Animation mo72d() {
        return AnimationUtils.loadAnimation(this, 17432577);
    }

    protected final synchronized void m772d(int i) {
        View i2 = m758i(i);
        if (i2 == null) {
            Log.w("StandOutWindow", "Tried to close(" + i + ") a null window.");
        } else {
            Class cls = getClass();
            HashMap hashMap = (HashMap) f758a.get(cls);
            if (hashMap != null) {
                hashMap.remove(Integer.valueOf(i));
                if (hashMap.isEmpty()) {
                    f758a.remove(cls);
                }
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(this, 17432577);
            if (!i2.f3124d) {
                this.f761d.cancel(getClass().hashCode() + i);
            }
            if (loadAnimation != null) {
                try {
                    loadAnimation.setAnimationListener(new C0614f(this, i2));
                    i2.getChildAt(0).startAnimation(loadAnimation);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                this.f760c.removeView(i2);
            }
            hashMap = (HashMap) f758a.get(getClass());
            if ((hashMap == null ? 0 : hashMap.size()) == 0) {
                this.f763f = false;
                stopForeground(true);
            }
        }
    }

    protected final String m773e() {
        return mo66a();
    }

    protected final synchronized boolean m774e(int i) {
        boolean a;
        if (!C0624p.m2851a(mo71c(), C0616h.f3161l)) {
            Window i2 = m758i(i);
            if (i2 != null) {
                m752b(f759b);
                a = i2.m2848a(true);
            }
        }
        a = false;
        return a;
    }

    protected final boolean m775f(int i) {
        return m743a(i, getClass());
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.f760c = (WindowManager) getSystemService("window");
        this.f761d = (NotificationManager) getSystemService("notification");
        this.f762e = (LayoutInflater) getSystemService("layout_inflater");
        this.f763f = false;
    }

    public void onDestroy() {
        super.onDestroy();
        m762l();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (intent != null) {
            String action = intent.getAction();
            int intExtra = intent.getIntExtra("id", 0);
            if (intExtra == -1) {
                throw new RuntimeException("ID cannot equals StandOutWindow.ONGOING_NOTIFICATION_ID");
            } else if ("SHOW".equals(action) || "RESTORE".equals(action)) {
                m754g(intExtra);
            } else if ("HIDE".equals(action)) {
                m770c(intExtra);
            } else if ("CLOSE".equals(action)) {
                m772d(intExtra);
            } else if ("CLOSE_ALL".equals(action)) {
                m762l();
            } else if ("SEND_DATA".equals(action)) {
                if (m775f(intExtra) || intExtra == -2) {
                    intent.getBundleExtra("wei.mark.standout.data");
                    intent.getIntExtra("requestCode", 0);
                    intent.getSerializableExtra("wei.mark.standout.fromCls");
                    intent.getIntExtra("fromId", 0);
                } else {
                    Log.w("StandOutWindow", "Failed to send data to non-existant window. Make sure toId is either an existing window's id, or is DISREGARD_ID.");
                }
            }
        } else {
            Log.w("StandOutWindow", "Tried to onStartCommand() with a null intent.");
        }
        return 2;
    }
}
