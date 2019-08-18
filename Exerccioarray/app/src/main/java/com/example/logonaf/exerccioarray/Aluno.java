package com.example.logonaf.exerccioarray;

public class Aluno {
    private String rgm;
    private String nome;
    private float nota_parcial;
    private  float nota_trabs;
    private  float nota_reg;

    public Aluno(String rgm, String nome, float nota_parcial, float nota_trabs, float nota_reg) {
        this.rgm = rgm;
        this.nome = nome;
        this.nota_parcial = nota_parcial;
        this.nota_trabs = nota_trabs;
        this.nota_reg = nota_reg;
    }

    public Aluno() {
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "rgm='" + rgm + '\'' +
                ", nome='" + nome + '\'' +
                ", nota_parcial=" + nota_parcial +
                ", nota_trabs=" + nota_trabs +
                ", nota_reg=" + nota_reg +
                '}';
    }

    public String getRgm() {
        return rgm;
    }

    public void setRgm(String rgm) {
        this.rgm = rgm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota_parcial() {
        return nota_parcial;
    }

    public void setNota_parcial(float nota_parcial) {
        this.nota_parcial = nota_parcial;
    }

    public float getNota_trabs() {
        return nota_trabs;
    }

    public void setNota_trabs(float nota_trabs) {
        this.nota_trabs = nota_trabs;
    }

    public float getNota_reg() {
        return nota_reg;
    }

    public void setNota_reg(float nota_reg) {
        this.nota_reg = nota_reg;
    }
}
