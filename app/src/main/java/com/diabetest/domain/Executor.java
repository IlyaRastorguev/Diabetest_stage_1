package com.diabetest.domain;

import com.diabetest.domain.interactors.BaseInteractorImpl;

public interface Executor {

    void execute(final BaseInteractorImpl interactor);
}
