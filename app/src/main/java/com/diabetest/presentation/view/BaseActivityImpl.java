package com.diabetest.presentation.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.diabetest.model.ActionProperty;
import com.diabetest.model.State;
import com.diabetest.presentation.presentors.AbstractPresenter;
import com.diabetest.presentation.presentors.BasePresenter;
import com.diabetest.presentation.view.customViews.CustomStateEditText;

import java.util.HashMap;

public abstract class BaseActivityImpl extends AppCompatActivity implements AbstractPresenter.BasicView {

    private int layoutId;

    protected HashMap<Integer, Button> buttons;

    protected HashMap<Integer, CustomStateEditText> fields;

    protected BasePresenter presenter;

    public BaseActivityImpl(@NonNull int layoutId) {
        super();

        this.layoutId = layoutId;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();

        setContentView(layoutId);
        presenter.onStart();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showError(int id) {
    }

    @Override
    public void next(Class<? extends BaseActivityImpl> activityClass, Bundle bundle) {
    }

    @Override
    public void next() {
    }


    @Override
    public void previous() {

    }

    @Override
    public void doAction() {

    }

    @Override
    public void init() {

    }

    @Override
    public void initFragment(int containerId, Class<AbstractPresenter.BasicFragment> fragmentClass) {

    }

    public void addButton(Integer id) {
        if (buttons == null) buttons = new HashMap<>();

        buttons.put(id, (Button) findViewById(id));
    }

    public void setRequestAction(int id, HashMap<ActionProperty, Object> props) {
        Button button = buttons.get(id);

        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) throws ClassCastException {
                }
            });
        }
    }

    public void setTransitionAction(int id, final HashMap<ActionProperty, Object> props) {
        Button button = buttons.get(id);

        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) throws ClassCastException {
                    next(
                            (Class<? extends BaseActivityImpl>) props.get(ActionProperty.CLASS),
                            (Bundle) props.get(ActionProperty.BUNDLE)
                    );
                }
            });
        }
    }

    protected void setPresenter(BasePresenter presenter) {
        this.presenter = presenter;
    }

    public void addField(Integer id) {
        if (fields == null) fields = new HashMap<>();

        fields.put(id, (CustomStateEditText) findViewById(id));
    }

    public void applyFieldStatus(int id, State state) {
        CustomStateEditText field = fields.get(id);

        if (field == null) return;

        switch (state) {
            case ACTIVE:
                field.requestFocus();
                break;
            case CASUAL:
                field.restoreState();
                break;
            case SUCCESS:
                field.setSuccess(true);
                break;
            case ERROR:
                field.setHasError(true);
                break;
            case DISABLED:
                field.setDisabled(true);
                break;
        }
    }

    public void setFieldValidator(final int id, final String pattern) {
        final CustomStateEditText field = fields.get(id);

        field.addTextChangedListener(new TextWatcher() {

            private final int ID = id;
            private final String PATTERN = pattern;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.validateField(s.toString(), PATTERN, ID);
            }
        });
    }

}
