package week9;

public class BangunDatar 
{
    private int panjang;
    private int lebar;
    private double diameter;
    private int sisi;
    private static final double phi = 3.14;

    //Persegi
    public BangunDatar(int sisi)
    {
        this.sisi = sisi;
    }

    //Persegi Panjang dan Segitiga
    public BangunDatar(int panjang, int lebar)
    {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    //Lingkaran
    public BangunDatar(double diameter)
    {
        this.diameter = diameter;
    }

    public int luas(int sisi)
    {
        return sisi * sisi;
    }

    public int luas(int panjang, int lebar)
    {
        return panjang*lebar;
    }

    public double luas(double panjang, double lebar)
    {
        return (panjang*lebar)/2;
    }

    public double luas(double diameter)
    {
        return (diameter/2)*(diameter/2)*phi;
    }

    public int getPanjang()
    {
        return panjang;
    }

    public int getLebar()
    {
        return lebar;
    }

    public double getDiameter()
    {
        return diameter;
    }

    public int getSisi()
    {
        return sisi;
    }

    public double getPhi()
    {
        return phi;
    }
}