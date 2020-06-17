/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahen
 */
public class MuridSession {

    private static String m_username_murid;    
    private static String m_pass_murid;
    private static String m_nama_murid;
    private static String m_alamat_murid;

    public static String getM_username_murid() {
        return m_username_murid;
    }

    public static String getM_pass_murid() {
        return m_pass_murid;
    }

    public static String getM_nama_murid() {
        return m_nama_murid;
    }

    public static String getM_alamat_murid() {
        return m_alamat_murid;
    }

    public static void setM_username_murid(String m_username_murid) {
        MuridSession.m_username_murid = m_username_murid;
    }

    public static void setM_pass_murid(String m_pass_murid) {
        MuridSession.m_pass_murid = m_pass_murid;
    }

    public static void setM_nama_murid(String m_nama_murid) {
        MuridSession.m_nama_murid = m_nama_murid;
    }

    public static void setM_alamat_murid(String m_alamat_murid) {
        MuridSession.m_alamat_murid = m_alamat_murid;
    }
    
    
}
