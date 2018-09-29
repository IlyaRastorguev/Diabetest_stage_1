package com.diabetest.domain;

import com.diabetest.domain.interactors.AbstractInteractor;

public interface Executor {

    void execute(final AbstractInteractor interactor);
}
