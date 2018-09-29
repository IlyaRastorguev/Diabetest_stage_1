package com.diabetest.model.loginScreen;

import com.diabetest.R;
import com.diabetest.model.AbstractScreen;
import com.diabetest.model.Field;
import com.diabetest.model.FieldPattern;
import com.diabetest.model.State;

import java.util.ArrayList;
import java.util.List;

public class LoginScreen extends AbstractScreen {

    public LoginScreen() {
        super();

        initScreen();
    }

    private void setButtons() {
    }

    private void setFields() {
        List<Field> fields = new ArrayList<>();

        Field<String> field = new Field<>();
        field.setState(State.ACTIVE);
        field.setFieldId(R.id.emailField);
        field.setFieldPattern(FieldPattern.EMAIL);
        fields.add(field);

        field = new Field<>();
        field.setState(State.CASUAL);
        field.setFieldId(R.id.password);
        field.setFieldPattern(FieldPattern.PASSWORD);
        fields.add(field);

        super.setFields(fields);
    }

    @Override
    protected void initScreen() {
        setButtons();
        setFields();
    }
}
