package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.View;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.LoginDTO.LoginResponce;

/**
 * Created by chinn on 02/21/18.
 */

public interface LoginView {

    void loginvalidation();

    void isValidUsername();

    void isValidPassword();

    void showResponce(LoginResponce loginResponces);

    void Error(String responce);

}
