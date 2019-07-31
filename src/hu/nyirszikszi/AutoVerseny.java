package hu.nyirszikszi;

class AutoVerseny {
    private String csapat;
    private String versenyzo;
    private int eletkor;
    private String palya;
    private String korido;
    private int kor;

    AutoVerseny(String csapat, String versenyzo, int eletkor, String palya, String korido, int kor) {
        this.csapat = csapat;
        this.versenyzo = versenyzo;
        this.eletkor = eletkor;
        this.palya = palya;
        this.korido = korido;
        this.kor = kor;
    }

    String getCsapat() {
        return csapat;
    }

    String getVersenyzo() {
        return versenyzo;
    }

    int getEletkor() {
        return eletkor;
    }

    String getPalya() {
        return palya;
    }

    String getKorido() {
        return korido;
    }

    int getKor() {
        return kor;
    }

    @Override
    public String toString() {
        return "AutoVerseny{" +
                "csapat='" + csapat + "'" +
                ", versenyzo='" + versenyzo + "'" +
                ", eletkor=" + eletkor +
                ", palya='" + palya + "'" +
                ", korido='" + korido + "'" +
                ", kor=" + kor +
                "}\n";
    }
}