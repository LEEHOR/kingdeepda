/*
 * Copyright 2013 Niek Haarman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jeewms.www.wms.util.listviewanimations.swinginadapters.prepared;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.jeewms.www.wms.util.listviewanimations.swinginadapters.SingleAnimationAdapter;

/**
 * An implementation of the AnimationAdapter class which applies a
 * swing-in-from-bottom-animation to views.
 */
public class SwingBottomInAnimationAdapter extends SingleAnimationAdapter {

    private static final String TRANSLATION_Y = "translationY";
    private final long mAnimationDelayMillis;
    private final long mAnimationDurationMillis;

    public SwingBottomInAnimationAdapter(final BaseAdapter baseAdapter) {
        this(baseAdapter, DEFAULTANIMATIONDELAYMILLIS, DEFAULTANIMATIONDURATIONMILLIS);
    }

    public SwingBottomInAnimationAdapter(final BaseAdapter baseAdapter, final long animationDelayMillis) {
        this(baseAdapter, animationDelayMillis, DEFAULTANIMATIONDURATIONMILLIS);
    }

    public SwingBottomInAnimationAdapter(final BaseAdapter baseAdapter, final long animationDelayMillis, final long animationDurationMillis) {
        super(baseAdapter);
        mAnimationDelayMillis = animationDelayMillis;
        mAnimationDurationMillis = animationDurationMillis;
    }

    @Override
    protected long getAnimationDelayMillis() {
        return mAnimationDelayMillis;
    }

    @Override
    protected long getAnimationDurationMillis() {
        return mAnimationDurationMillis;
    }

    @Override
    protected Animator getAnimator(final ViewGroup parent, final View view) {
        // TODO magic number
        return ObjectAnimator.ofFloat(view, TRANSLATION_Y, 500, 0);
    }

}
