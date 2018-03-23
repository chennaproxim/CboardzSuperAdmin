package com.cboadz.app.cboardzsuperadmin.SuperAdmin.View;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.LoginDTO.LoginResponce;

/**
 * Created by chinn on 02/21/18.
 */

public interface LoginView {

    void loginvalidation();

    void isValidUsername();

    void isValidPassword();

    void showResponse(LoginResponce loginResponces);

    void Error(String responce);

}
