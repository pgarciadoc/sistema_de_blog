package src.main.java.br.com.nebulaworks.BrainDrain.dto;

public class Posts {

    private String id;
    private String titulo;
    private String data;
    private String criadoPor;
    private String editadoPor;
    private String arquivos;
    private String url;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(String criadoPor) {
        this.criadoPor = criadoPor;
    }

    public String getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(String editadoPor) {
        this.editadoPor = editadoPor;
    }

    public String getArquivos() {
        return arquivos;
    }

    public void setArquivos(String arquivos) {
        this.arquivos = arquivos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
