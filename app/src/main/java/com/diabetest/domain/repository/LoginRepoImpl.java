package com.diabetest.domain.repository;

public class LoginRepoImpl extends AbstractRepository implements LoginRepo {
    @Override
    public boolean checkLogin() {
        return true;
    }
}
