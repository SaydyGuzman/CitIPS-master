package com.i054114.citips.Utilities;

/**on 28/11/2017.
 */

public class Constans {

    //BASE DE DATOS USUARIO
    public static final String TABLE_NAME_USERS = "users";
    public static final String TABLE_FIELD_USER_ID = "id";
    public static final String TABLE_FIELD_USER_USERNAME = "username";
    public static final String TABLE_FIELD_USER_PASSWORD = "password";
    public static final String TABLE_FIELD_USER_CONFIRMPASSWORD = "confirmpassword";
    public static final String CREATE_TABLE_USERS =
            "CREATE TABLE "+ TABLE_NAME_USERS+" ("+
                    TABLE_FIELD_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLE_FIELD_USER_USERNAME+" TEXT, "+
                    TABLE_FIELD_USER_PASSWORD+" TEXT, "+
                    TABLE_FIELD_USER_CONFIRMPASSWORD+" TEXT)";
}
