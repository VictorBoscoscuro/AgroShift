/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.util;

/**
 *
 * @author victo
 */
public class UserLogin {
    private static UserLogin instance = null;
  
    public String username;
    public Long id_user_login;
    public boolean is_admin;
    public String alias;
  
    // private constructor restricted to this class itself
    private UserLogin(String username,Long id_user_login,boolean is_admin, String alias)
    {
        this.username = username;
        this.id_user_login = id_user_login;
        this.is_admin = is_admin;
        this.alias = alias;
    }
  
    public static void setInstance(String username,Long id_user_login,boolean is_admin, String alias)
    {
        if (instance == null)
            instance = new UserLogin(username,id_user_login,is_admin,alias);
        System.out.println("La instancia del usuario ya esta creada");
    }
    public static UserLogin getInstance()
    {
        return instance;
    }
}
