package com.jeewms.www.wms.util.listviewanimations.swinginadapters.prepared;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nineoldandroids.animation.Animator;
import com.jeewms.www.wms.util.listviewanimations.swinginadapters.AnimationAdapter;

public class AlphaInAnimationAdapter extends AnimationAdapter {

    public AlphaInAnimationAdapter(final BaseAdapter baseAdapter) {
        super(baseAdapter);
    }

    @Override
    protected long getAnimationDelayMillis() {
        return DEFAULTANIMATIONDELAYMILLIS;
    }

    @Override
    protected long getAnimationDurationMillis() {
        return DEFAULTANIMATIONDURATIONMILLIS;
    }

    @Override
    public Animator[] getAnimators(final ViewGroup parent, final View view) {
        return new Animator[0];
    }
}
