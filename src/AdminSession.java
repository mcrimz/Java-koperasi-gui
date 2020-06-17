/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahen
 */
class AdminSession {
    
    private static int a_id;
    private static String a_username_admin;    
    private static String a_pass_admin;
    private static String a_nama;
    private static String a_alamat;

    public static int getA_id() {
        return a_id;
    }

    public static String getA_username_admin() {
        return a_username_admin;
    }

    public static String getA_pass_admin() {
        return a_pass_admin;
    }

    public static String getA_nama() {
        return a_nama;
    }

    public static String getA_alamat() {
        return a_alamat;
    }

    public static void setA_id(int a_id) {
        AdminSession.a_id = a_id;
    }

    public static void setA_username_admin(String a_username_admin) {
        AdminSession.a_username_admin = a_username_admin;
    }

    public static void setA_pass_admin(String a_pass_admin) {
        AdminSession.a_pass_admin = a_pass_admin;
    }

    public static void setA_nama(String a_nama) {
        AdminSession.a_nama = a_nama;
    }

    public static void setA_alamat(String a_alamat) {
        AdminSession.a_alamat = a_alamat;
    }


}
