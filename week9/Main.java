package week9;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args){
        BangunDatar BD = new BangunDatar (0,0);
        BangunRuang BR = new BangunRuang (0,0);
        Scanner input = new Scanner(System.in);
        
        System.out.println("=======================");
        System.out.println("||Persegi         : 1||");
        System.out.println("||Persegi Panjang : 2||");
        System.out.println("||Segitiga        : 3||");
        System.out.println("||Lingkaran       : 4||");
        System.out.println("||Kubus           : 5||");
        System.out.println("||Balok           : 6||");
        System.out.println("||Prisma Segitiga : 7||");
        System.out.println("||Silinder        : 8||");
        System.out.println("=======================");
        System.out.print("Masukan Pilihan : ");
        int pilihan = input.nextInt();

        if (pilihan == 1)
        {
            System.out.print("Masukan Sisi : ");
            int sisi = input.nextInt();
            System.out.println("Luas Persegi : " + BD.luas(sisi));
        }
        else if (pilihan == 2)
        {
            System.out.print("Masukan Panjang : ");
            int panjang = input.nextInt();
            System.out.print("Masukan Lebar : ");
            int lebar = input.nextInt();
            System.out.println("Luas Persegi Panjang : " + BD.luas(panjang,lebar));
        }
        else if (pilihan == 3)
        {
            System.out.print("Masukan Panjang : ");
            Double panjang = input.nextDouble();
            System.out.print("Masukan Lebar : ");
            Double lebar = input.nextDouble();
            System.out.println("Luas Segitiga : " + BD.luas(panjang,lebar));
        }
        else if (pilihan == 4)
        {
            System.out.print("Masukan Diameter : ");
            Double diameter = input.nextDouble();
            System.out.println("Luas Lingkaran : " + BD.luas(diameter));
        }
        else if (pilihan == 5)
        {
            System.out.print("Masukan Sisi 1 : ");
            int sisi1 = input.nextInt();
            System.out.print("Masukan Sisi 2 : ");
            int sisi2 = input.nextInt();
            System.out.print("Masukan Sisi 3 : ");
            int sisi3 = input.nextInt();
            System.out.println("Volume Kubus : " + BR.volume(sisi1,sisi2,sisi3));
        }
        else if(pilihan == 6)
        {
            System.out.print("Masukan Panjang : ");
            int panjang = input.nextInt();
            System.out.print("Masukan Lebar : ");
            int lebar = input.nextInt();
            System.out.print("Masukan Tinggi : ");
            int tinggi = input.nextInt();
            System.out.println("Volume Balok : " + BR.volume(panjang,lebar,tinggi));
        }
        else if(pilihan ==7)
        {
            System.out.print("Masukan Panjang : ");
            Double panjang = input.nextDouble();
            System.out.print("Masukan Lebar : ");
            Double lebar = input.nextDouble();
            System.out.print("Masukan Tinggi : ");
            Double tinggi = input.nextDouble();
            System.out.println("Volume Prisma Segitiga : " + BR.volume(panjang,lebar,tinggi));
        }
        else if(pilihan == 8)
        {
            System.out.print("Masukan Diameter : ");
            Double diameter = input.nextDouble();
            System.out.print("Masukan Tinggi : ");
            Double tinggi = input.nextDouble();
            System.out.println("Volume Silinder : " + BR.volume(diameter,tinggi));
        }
        else
        {
            System.out.print("Pilihan Tidak Valid");
        }



        /*System.out.println("Luas Persegi : " + BD.luas(2));
        System.out.println("Luas Persegi Panjang : " + BD.luas(5,2));
        System.out.println("Luas Segitiga : " + BD.luas(5.0,2.5));
        System.out.println("Luas Lingkaran : " + BD.luas(10.0));
        System.out.println("Volume Kubus : " + BR.volume(2,2,2));
        System.out.println("Volume Balok : " + BR.volume(5,2,4));
        System.out.println("Volume Prisma Segitiga : " + BR.volume(5.0,2.5,6.0));
        System.out.println("Volume Silinder : " + BR.volume(10.0,8.0));
        */

    }
}