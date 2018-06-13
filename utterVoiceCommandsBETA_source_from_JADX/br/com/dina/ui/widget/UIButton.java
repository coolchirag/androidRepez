package br.com.dina.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import br.com.dina.ui.C0094c;
import br.com.dina.ui.C0095d;
import br.com.dina.ui.C0096e;

public class UIButton extends LinearLayout {
    private LayoutInflater f317a;
    private LinearLayout f318b = ((LinearLayout) this.f317a.inflate(C0095d.f314e, null));
    private C0098b f319c;
    private CharSequence f320d;
    private CharSequence f321e;
    private int f322f;

    public UIButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClickable(true);
        this.f317a = (LayoutInflater) context.getSystemService("layout_inflater");
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0096e.f316a, 0, 0);
        this.f320d = obtainStyledAttributes.getString(0);
        this.f321e = obtainStyledAttributes.getString(1);
        this.f322f = obtainStyledAttributes.getResourceId(2, -1);
        if (this.f320d != null) {
            ((TextView) this.f318b.findViewById(C0094c.f303a)).setText(this.f320d.toString());
        } else {
            ((TextView) this.f318b.findViewById(C0094c.f303a)).setText("subtitle");
        }
        if (this.f321e != null) {
            ((TextView) this.f318b.findViewById(C0094c.f306d)).setText(this.f321e.toString());
        } else {
            ((TextView) this.f318b.findViewById(C0094c.f306d)).setVisibility(8);
        }
        if (this.f322f >= 0) {
            ((ImageView) this.f318b.findViewById(C0094c.f307e)).setImageResource(this.f322f);
        }
        this.f318b.setOnClickListener(new C0097a(this));
        addView(this.f318b, layoutParams);
    }
}
