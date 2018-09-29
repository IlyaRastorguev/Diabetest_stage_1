package com.diabetest.model.authScreen;

import com.diabetest.R;
import com.diabetest.model.AbstractScreen;
import com.diabetest.model.ActionProperty;
import com.diabetest.model.ActionType;
import com.diabetest.model.Button;
import com.diabetest.presentation.view.BaseActivityImpl;
import com.diabetest.presentation.view.LoginActivity;
import com.diabetest.presentation.view.SingupActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AuthScreen extends AbstractScreen {

    public AuthScreen() {
        super();

        initScreen();
    }

    private void setButtons() {
        if (getButtons() == null) {
            List<Button> btns = new ArrayList<>();
            HashMap<ActionProperty, Class<? extends BaseActivityImpl>> props = new HashMap<>();

            Button loginButton = new Button();

            props.put(ActionProperty.CLASS, LoginActivity.class);
            props.put(ActionProperty.BUNDLE, null);

            loginButton.setButtonId(R.id.login);
            loginButton.setActionType(ActionType.TRANSITION);
            loginButton.setProps(props);

            btns.add(loginButton);

            Button singupButton = new Button();

            props = new HashMap<>();
            props.put(ActionProperty.CLASS, SingupActivity.class);
            props.put(ActionProperty.BUNDLE, null);

            singupButton.setButtonId(R.id.singup);
            singupButton.setActionType(ActionType.TRANSITION);
            singupButton.setProps(props);

            btns.add(singupButton);

            super.setButtons(btns);
        }
    }

    @Override
    protected void initScreen() {
        setButtons();
    }
}
