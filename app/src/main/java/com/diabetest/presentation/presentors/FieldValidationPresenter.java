package com.diabetest.presentation.presentors;

import com.diabetest.domain.Executor;
import com.diabetest.domain.MainThread;
import com.diabetest.model.AbstractScreen;
import com.diabetest.model.FieldValidator;
import com.diabetest.model.State;
import com.diabetest.presentation.view.BaseActivityImpl;

public class FieldValidationPresenter<A extends BaseActivityImpl, S extends AbstractScreen> extends AbstractPresenter<A, S> implements BasePresenter {

    public FieldValidationPresenter(Executor executor, MainThread mainThread, A activity, S screen) {
        super(executor, mainThread, activity, screen);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onResume() {
        resolveScreen();
    }

    @Override
    public void resolveScreen() {
        initFields();
    }

    public void validateField(String value, String pattern, int id) {
        final boolean result = FieldValidator.validate(value, pattern);

        if (!result) getActivity().applyFieldStatus(id, State.ERROR);
        else getActivity().applyFieldStatus(id, State.SUCCESS);
    }
}
