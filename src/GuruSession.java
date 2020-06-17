/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahen
 */
public class GuruSession {
    private static int id_guru;
    private static String G_nip;
    private static String G_username_guru;
    private static String G_password_guru;
    private static String G_nama_lngkap_guru;
    private static String G_alamat_guru;
    private static int G_pinjaman;

    public static int getId_guru() {
        return id_guru;
    }

    public static String getG_nip() {
        return G_nip;
    }

    public static String getG_username_guru() {
        return G_username_guru;
    }

    public static String getG_password_guru() {
        return G_password_guru;
    }

    public static String getG_nama_lngkap_guru() {
        return G_nama_lngkap_guru;
    }

    public static String getG_alamat_guru() {
        return G_alamat_guru;
    }

    public static int getG_pinjaman() {
        return G_pinjaman;
    }

    public static void setId_guru(int id_guru) {
        GuruSession.id_guru = id_guru;
    }

    public static void setG_nip(String G_nip) {
        GuruSession.G_nip = G_nip;
    }

    public static void setG_username_guru(String G_username_guru) {
        GuruSession.G_username_guru = G_username_guru;
    }

    public static void setG_password_guru(String G_password_guru) {
        GuruSession.G_password_guru = G_password_guru;
    }

    public static void setG_nama_lngkap_guru(String G_nama_lngkap_guru) {
        GuruSession.G_nama_lngkap_guru = G_nama_lngkap_guru;
    }

    public static void setG_alamat_guru(String G_alamat_guru) {
        GuruSession.G_alamat_guru = G_alamat_guru;
    }

    public static void setG_pinjaman(int G_pinjaman) {
        GuruSession.G_pinjaman = G_pinjaman;
    }

    
    
}
