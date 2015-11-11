package com.dbiousanalytics.charlie.dbiousanalytics;

/**
 * Created by charlie on 11/11/2015.
 */
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;

public class CheckableListView extends LinearLayout implements Checkable {
    private static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};

    private boolean mChecked = false;

    public CheckableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public boolean isChecked() {
        return mChecked;
    }

    public void setChecked(boolean b) {
        if(b!=mChecked) {
            mChecked = b;
            refreshDrawableState();
        }
    }

    public void toggle(){
        setChecked(!mChecked);
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }
}
