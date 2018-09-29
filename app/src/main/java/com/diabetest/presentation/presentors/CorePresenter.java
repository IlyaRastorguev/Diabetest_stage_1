package com.diabetest.presentation.presentors;

import com.diabetest.model.AbstractScreen;
import com.diabetest.model.ActionProperty;
import com.diabetest.model.ActionType;
import com.diabetest.model.Button;
import com.diabetest.model.Field;
import com.diabetest.model.FieldPattern;
import com.diabetest.model.State;
import com.diabetest.presentation.view.BaseActivityImpl;

import java.util.HashMap;

public class CorePresenter<A extends BaseActivityImpl, S extends AbstractScreen> {

    private A activity;

    private S screen;

    CorePresenter(A a, S s) {
        activity = a;
        screen = s;
    }

    public A getActivity() {
        return activity;
    }

    void initButtons() {

        if (screen.getButtons() != null)
            for (Button button : screen.getButtons()) {

                setButton(button.getButtonId());

                setButtonCallback(button.getActionType(), button.getButtonId(), button.getProps());
            }
    }

    private void setButton(int id) {
        activity.addButton(id);
    }

    private void setButtonCallback(ActionType actionType, int id, HashMap<ActionProperty, Object> props) {
        switch (actionType) {
            case REQUEST:
                activity.setRequestAction(id, props);
                break;
            case TRANSITION:
                activity.setTransitionAction(id, props);
                break;
        }
    }

    void initFields() {

        if (screen.getFields() != null)
            for (Field field : screen.getFields()) {

                final int id = field.getFieldId();
                final State state = field.getState();
                final FieldPattern pattern = field.getFieldPattern();

                setField(id);

                setFieldState(id, state);

                setFieldValidator(id, pattern);

            }
    }

    private void setField(int id) {
        activity.addField(id);
    }

    private void setFieldState(int id, State state) {
        activity.applyFieldStatus(id, state);
    }

    private void setFieldValidator(int id, FieldPattern pattern) {
        if (pattern != null) activity.setFieldValidator(id, pattern.getPattern());
    }
}
