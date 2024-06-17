/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week11;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author HRP
 */
public class Week11 {

    /**
     * @param args the command line arguments
     */
    
        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/db_perpustakaan";
        static final String USER = "root";
        static final String PASS = "";
        
        static Connection conn;
        static Statement stmt;
        static ResultSet rs;
        
    public static void menu() {
        
        System.out.println("====================");
        System.out.println("||      Menu      ||");
        System.out.println("||1. Insert Data  ||");
        System.out.println("||2. Update Data  ||");
        System.out.println("||3. Delete Data  ||");
        System.out.println("||4. Show Data    ||");
        System.out.println("||5. Exit         ||");
        System.out.println("====================");
    }
        
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilih;

        do {
            menu();
            System.out.print("Pilih Menu : ");
            pilih = input.nextInt();
            input.nextLine();

            switch(pilih) {
                case 1:
                    insert(input);
                break;
                case 2:
                    update(input);
                break;
                case 3:
                    delete(input);
                break;
                case 4:
                    show();
                break;
                case 5:
                    System.out.println("Keluar");
                break;
                default:
                    System.out.println("Pilihan Menu Tidak Valid");
            }
        } while (pilih != 5);

        input.close();
    }
    
    public static void insert(Scanner input) {
        System.out.print("Masukkan ID : ");
        int ID = input.nextInt();
        input.nextLine();
        System.out.print("Masukkan Judul Buku : ");
        String Judul_Buku = input.nextLine();
        System.out.print("Masukkan Tahun Terbit : ");
        int Tahun_Terbit = input.nextInt();
        System.out.print("Masukkan Stok : ");
        int Stok = input.nextInt();
        System.out.print("Masukkan Penulis : ");
        int Penulis = input.nextInt();
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql = "INSERT INTO buku (ID, Judul_Buku, Tahun_Terbit, Stok, Penulis) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, ID);
            ps.setString(2, Judul_Buku);
            ps.setInt(3, Tahun_Terbit);
            ps.setInt(4, Stok);
            ps.setInt(5, Penulis);

            ps.execute();

            stmt.close();
            conn.close();
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void update(Scanner input) {
        
        System.out.print("Masukkan ID Buku Yang Ingin Di Update : ");
        int ID = input.nextInt();
        input.nextLine(); 
        if (!exists(ID)) {
                System.out.println("Data Tidak Ditemukan");
            return;
        }
        System.out.print("Masukkan Judul Buku Baru : ");
        String Judul_Buku = input.nextLine();
        System.out.print("Masukkan Tahun Terbit Baru : ");
        int Tahun_Terbit = input.nextInt();
        System.out.print("Masukkan Stok Baru : ");
        int Stok = input.nextInt();
        System.out.print("Masukkan Penulis Baru : ");
        int Penulis = input.nextInt();

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE buku SET Judul_Buku = ?, Tahun_Terbit = ?, Stok = ?, Penulis = ? WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, Judul_Buku);
            ps.setInt(2, Tahun_Terbit);
            ps.setInt(3, Stok);
            ps.setInt(4, Penulis);
            ps.setInt(5, ID);

            ps.executeUpdate();

            ps.close();
            conn.close();
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void delete(Scanner input) {
        
        System.out.print("Masukkan ID Buku Yang Ingin Di Delete : ");
        int ID = input.nextInt();
        input.nextLine();
        if (!exists(ID)) {
                System.out.println("Data Tidak Ditemukan");
            return;
        }

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "DELETE FROM buku WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, ID);

            ps.executeUpdate();

            ps.close();
            conn.close();
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void show() {
    
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM buku");
            
            int i = 1;
            while(rs.next()) {
                System.out.println("======================================================");
                System.out.println("Data ke-" + i);
		System.out.println("ID: " + rs.getString("ID"));
		System.out.println("Judul Buku: " + rs.getString("Judul_Buku"));
		System.out.println("Tahun Terbit: " + rs.getString("Tahun_Terbit"));
		System.out.println("Stok: " + rs.getString("Stok"));
		System.out.println("Penulis: " + rs.getString("Penulis"));
		i++;
            }
            
            rs.close();
            stmt.close();
            conn.close();
	}
        
	catch(Exception e) {
            e.printStackTrace();
	}
    }
    
    public static boolean exists(int ID) {
        
        boolean found = false;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT id FROM buku WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, ID);
            
            rs = ps.executeQuery();

            found = rs.next();

            rs.close();
            ps.close();
            conn.close();
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }

        return found;
    }
    
    
}