package com.singpaulee.bangundatardanbangunruang;


public class BankSoal {

    private String pertanyaan[] = {
            "Sebuah persegi ABCD memiliki sisi 7cm, tentukan Luas dan Keliling bangun tersebut!",
            "Sebuah persegi panjang EFGH memiliki lebar 5cm dan panjang 10cm. Tentukan Luas dan Keliling persegi panjang EFGH!",
            "Sebuah bangun datar segitiga BAC, dengan siku-siku di A memiliki panjang sisi AB=4cm, BC=5cm dan AC=3cm. \n Tentukan Luas dan Keliling segitiga BAC !",
            "Sebuah bangun datar belah ketupat ABCD mempunyai sisi dengan panjang 10cm, dan mempunyai 2 diagonal AC dan BD. \n Tetukan Luas dan Keliling belah ketupat tersebut !",
            "Sebuah bangun datar jajar genjang ABCD mempunyai tinggi 7cm, panjang sisi AB=DC=AD=BC=8cm. \n Tentukan Luas dan Keliling jajar genjang ABCD !",
            "Sebuah bangun datar layang-layang ABCD memiliki panjang sisi AB=AD=12cm, CB=CD=22cm. Panjang diagonal AC=30cm, Panjang diagonal BD=15cm. \n Tentukan Luas dan Keliling bangun tersebut !",
            "Sebuah bangun datar Trapesium EFGH mempunyai panjang sisi EF=16cm, HG=6cm dan memiliki tinggi 7cm. \n Tentukan Luas dan Keliling Trapesium EFGH",
            "Sebuah kubus memiliki panjang sisi AB adalah 12 cm. Tentukan panjang rusuk semua kubus !",
            "Sebuah bak mandi berbentuk kubus dengan panjang sisi bagian dalam adalah 80 cm. Jika bak mandi terisi 3/4 bagian dengan air tentukan berapa liter volume air di dalam bak mandi tersebut!",
            "Volume sebuah kubus adalah 1331 cm3. Tentukan luas permukaan kubus tersebut!",
            "Pak Budi hendak membuat kandang ayam berbentuk kubus dengan kerangka terbuat dari besi. Panjang sisi kandang yang direncanakan adalah 40 cm. Jika Pak Budi memiliki bahan besi sepanjang 30 meter, tentukan jumlah kandang yang dapat dibuat!",
            "Sebuah bak mandi berbentuk kubus dengan ukuran panjang sisi 80 cm. Jika bak mandi diisi dengan air kran yang memiliki debit 1 500 cm3 / detik, tentukan waktu yang diperlukan untuk mengisi bak mandi dari kondisi kosong hingga penuh!",
            "Segitiga samasisi adalah segitiga yang semua sisinya sama panjang dan tiga sudut yang sama besar yaitu...derajat\n",
            "Panjang sisi belah ketupat = 5 cm, berapakah kelilingnya ?",
            "Jumlah diagonal bidang yang dimiliki oleh prisma segi enam adalah...",
            "Banyaknya rusuk dan sisi prisma segi-8 berturut-turut adalah...",
            "Alas sebuah limas berbentuk segi-6. Banyaknya rusuk dan sisi limas berturut-turut adalah...",
            "Banyak bidang pada prisma segi-30 adalah...",
            "Banyaknya rusuk dan sisi prisma segi-8 berturut-turut adalah...",
            "Alas sebuah limas berbentuk segi-6. Banyaknya rusuk dan sisi limas berturut-turut adalah...",
            "Jika panjang diagonal sisi kubus 6√2 cm, panjang diagonal ruangnya adalah... cm",
            "Luas sisi kubus yang panjang diagonal ruangnya √75 cm adalah... cm2.",
            "Panjang seluruh rusuk kubus 192 cm. Luas permukaan kubus adalah...",
            "Luas alas suatu prisma yang berbentuk persegi adalah 36 cm2. Jika tinggi prisma 20 cm, luas seluruh sisi prisma adalah... cm2.",
            "Alas sebuah prisma berbentuk belah ketupat dengan panjang diagonalnya 16 cm dan 20 cm. Jika tinggi prisma 24 cm, volume prisma tersebut adalah...",

    };


    private String jawaban[] = {
            "49cm(cm kuadrat) dan 28cm",
            "50cm(cm kuadrat) dan 30cm",
            "6cm(cm kuadrat) dan 12cm",
            "96cm(cm kuadrat) dan 40cm",
            "56cm(cm kuadrat) dan 32cm",
            "225cm(cm kuadrat) dan 68cm",
            "77cm(cm kuadrat) dan 38cm",
            "144cm",
            "384liter",
            "1.452cm(cm kuadrat)",
            "6buah",
            "17,01menit",
            "90",
            "180",
            "20cm",
            "30",
            "24 dan 10",
            "12 dan 7",
            "24 dan 10",
            "12 dan 7",
            "6√3",
            "150",
            "1.536 cm(cm kuadrat)",
            "552",
            "3.840",
    };

    private String pilihanJawaban[][] = {
            {"49cm(cm kuadrat) dan 28cm","48cm(cm kuadrat) dan 26cm","49cm(cm kuadrat) dan 26cm"},
            {"50cm dan 30cm(cm kuadrat)","50cm(cm kuadrat) dan 30cm","50cm dan 30cm"},
            {"6cm(cm kuadrat) dan 12cm","7cm(cm kuadrat) dan 11cm","5cm(cm kuadrat) dan 13cm"},
            {"95cm(cm kuadrat) dan 42cm","95cm(cm kuadrat) dan 40cm","96cm(cm kuadrat) dan 40cm"},
            {"52cm(cm kuadrat) dan 30cm","56cm(cm kuadrat) dan 32cm","56cm(cm kuadrat) dan 30cm"},
            {"225cm(cm kuadrat) dan 68cm","225cm(cm kuadrat) dan 60cm","220cm(cm kuadrat) dan 65cm"},
            {"76cm(cm kuadrat) dan 42cm","88cm(cm kuadrat) dan 48cm","77cm(cm kuadrat) dan 38cm"},
            {"146","134","144cm"},
            {"384liter","348liter","438liter"},
            {"2.441cm(cm kuadrat)","1.442cm(cm kuadrat)","1.452cm(cm kuadrat)"},
            {"4buah","6buah","8buah"},
            {"17,01menit","17,1menit","18,01menit"},
            {"120","90","45"},
            {"90","180","75"},
            {"20cm","30cm","40cm"},
            {"15","45","30"},
            {"28 dan 12","24 dan 10","12 dan 24"},
            {"14 dan 9","12 dan 7","7 dan 8"},
            {"24 dan 10","26 dan 10","10 dan 26"},
            {"12 dan 7","7 dan 12","12 dan 12"},
            {"6√2","6√3","8√3"},
            {"110","125","150"},
            {"1.635cm(cm kuadrat)","1.356cm(cm kuadrat)","1.536 cm(cm kuadrat)"},
            {"225","552","525"},
            {"3.488","3.844","3.840"},
    };

    public  String getSoal(int a){
        String soal = pertanyaan[a];
        return  soal;
    }

    public String getPilihanJawaban1(int a){
        String pila = pilihanJawaban[a][0];
        return pila;
    }
    public String getPilihanJawaban2(int a){
        String pilb = pilihanJawaban[a][1];
        return pilb;
    }
    public String getPilihanJawaban3(int a){
        String pilc = pilihanJawaban[a][2];
        return pilc;
    }

    public String getJawaban(int a){
        String jwbn = jawaban[a];
        return jwbn;
    }

}
