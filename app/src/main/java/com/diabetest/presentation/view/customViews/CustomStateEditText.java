package com.diabetest.presentation.view.customViews;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.diabetest.R;

public class CustomStateEditText extends AppCompatEditText {

    private static final int[] ERROR_STATE = new int[]{R.attr.state_error};
    private static final int[] SUCCESS_STATE = new int[]{R.attr.state_success};
    private static final int[] DISABLED_STATE = new int[]{R.attr.state_disabled};

    private boolean hasError = false;
    private boolean success = false;
    private boolean disabled = false;

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
        this.disabled = false;
        this.success = false;

        refreshDrawableState();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
        this.hasError = false;
        this.disabled = false;

        refreshDrawableState();
    }

    public CustomStateEditText(Context context) {
        super(context);
    }

    public CustomStateEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomStateEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void restoreState() {
        hasError = false;
        success = false;
        disabled = false;

        refreshDrawableState();
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] state = super.onCreateDrawableState(extraSpace + 1);
        if (hasError) {
            mergeDrawableStates(state, ERROR_STATE);
        }
        if (success) {
            mergeDrawableStates(state, SUCCESS_STATE);
        }
        if (disabled)
            mergeDrawableStates(state, DISABLED_STATE);

        return state;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
        this.success = false;
        this.hasError = false;

        refreshDrawableState();
    }
}
