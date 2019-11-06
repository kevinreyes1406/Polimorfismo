
public class Pais {

    public Pais(String Pais, String moneda, String gentilicio, String idioma, String capital) {
        this.Pais = Pais;
        this.moneda = moneda;
        this.gentilicio = gentilicio;
        this.idioma = idioma;
        this.capital = capital;
    }

    public Pais() {
    }
    
private String Pais;
private String moneda;
private String gentilicio;
private String idioma;
private String capital;

//Encapsular

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getMoneda() {
        return moneda;
    }


    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getGentilicio() {
        return gentilicio;
    }

    public void setGentilicio(String gentilicio) {
        this.gentilicio = gentilicio;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    
}

