package com.example.logonaf.exerccioarray;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Global {
    public static ArrayList alunos = new ArrayList();


    public Global() {
    }

    public boolean Create(Aluno a) {

        try{
            if (a.getRgm()!=null){
                alunos.add(a);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
    public boolean update(Aluno aluno) {
        try{
            alunos.set(alunos.indexOf(aluno),aluno);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Aluno consultar(String rgm) {
        for (int i=0;i< alunos.size();i++) {
            if ( ((Aluno)alunos.get(i)).getRgm().equals((rgm))){
                return (Aluno)alunos.get(i);
            }
        }
        return null;
    }
    public  boolean Excluir(Aluno aluno){
        if (alunos.contains(aluno)){
            alunos.remove(aluno);
            return true;
        }
        return false;
    }
    public ArrayList tudo() {
        return alunos;
    }

}
