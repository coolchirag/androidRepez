package br.com.dina.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import br.com.dina.ui.C0093b;
import br.com.dina.ui.C0094c;
import br.com.dina.ui.C0095d;
import br.com.dina.ui.p010a.C0089b;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.p010a.C0091c;
import java.util.ArrayList;
import java.util.List;

public class UITableView extends LinearLayout {
    private int f323a = 0;
    private LayoutInflater f324b;
    private LinearLayout f325c;
    private LinearLayout f326d;
    private List<C0089b> f327e = new ArrayList();
    private C0100d f328f;

    public UITableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f324b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f325c = (LinearLayout) this.f324b.inflate(C0095d.f315f, null);
        addView(this.f325c, new LayoutParams(-1, -1));
        this.f326d = (LinearLayout) this.f325c.findViewById(C0094c.f305c);
    }

    private void m290a(View view, C0089b c0089b) {
        if (c0089b instanceof C0090a) {
            C0090a c0090a = (C0090a) c0089b;
            int i = this.f323a;
            if (c0090a.f294b >= 0) {
                ((ImageView) view.findViewById(C0094c.f307e)).setBackgroundResource(c0090a.f294b);
            }
            if (c0090a.f295c >= 0) {
                ((ImageView) view.findViewById(C0094c.f309g)).setBackgroundResource(c0090a.f295c);
            } else {
                ((ImageView) view.findViewById(C0094c.f309g)).setBackgroundResource(C0093b.f302a);
            }
            if (c0090a.f297e != null) {
                ((TextView) view.findViewById(C0094c.f306d)).setText(c0090a.f297e);
            } else {
                ((TextView) view.findViewById(C0094c.f306d)).setVisibility(8);
            }
            ((TextView) view.findViewById(C0094c.f303a)).setText(c0090a.f296d);
            if (c0090a.f298f >= 0) {
                ((TextView) view.findViewById(C0094c.f303a)).setTextColor(c0090a.f298f);
            }
            view.setTag(Integer.valueOf(i));
            if (c0090a.f293a) {
                view.setOnClickListener(new C0099c(this));
            } else {
                ((ImageView) view.findViewById(C0094c.f309g)).setVisibility(8);
            }
        } else if (c0089b instanceof C0091c) {
            C0091c c0091c = (C0091c) c0089b;
            int i2 = this.f323a;
            if (c0091c.f299a != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(C0094c.f308f);
                linearLayout.removeAllViews();
                linearLayout.addView(c0091c.f299a);
            }
        }
    }

    public final void m291a() {
        this.f323a = 0;
        View inflate;
        C0089b c0089b;
        if (this.f327e.size() > 1) {
            for (C0089b c0089b2 : this.f327e) {
                inflate = this.f323a == 0 ? this.f324b.inflate(C0095d.f310a, null) : this.f323a == this.f327e.size() + -1 ? this.f324b.inflate(C0095d.f312c, null) : this.f324b.inflate(C0095d.f311b, null);
                int i = this.f323a;
                m290a(inflate, c0089b2);
                inflate.setClickable(c0089b2.mo51a());
                this.f326d.addView(inflate);
                this.f323a++;
            }
        } else if (this.f327e.size() == 1) {
            inflate = this.f324b.inflate(C0095d.f314e, null);
            c0089b2 = (C0089b) this.f327e.get(0);
            int i2 = this.f323a;
            m290a(inflate, c0089b2);
            inflate.setClickable(c0089b2.mo51a());
            this.f326d.addView(inflate);
        }
    }

    public final void m292a(C0090a c0090a) {
        this.f327e.add(c0090a);
    }

    public final int m293b() {
        return this.f327e.size();
    }

    public void setClickListener(C0100d c0100d) {
        this.f328f = c0100d;
    }
}
