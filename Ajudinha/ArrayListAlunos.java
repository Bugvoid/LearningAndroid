package com.example.exercicioaula7bv3;

import java.util.*;

public class ArrayListAlunos {

	//public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	//ou:
	public static ArrayList alunos = new ArrayList();

	public ArrayListAlunos() {
	}
	
	public boolean insert(Aluno aluno) {
		System.out.print(aluno.getRgm());
		try{
			if (select(aluno.getRgm())==null){
				alunos.add(aluno);
				return true;
			}else{
				return false;
			}
		}catch (Exception e){
			return false;
		}
	}
	
	public boolean delete(Aluno aluno) {
		if (alunos.contains(aluno)){
			alunos.remove(aluno);
			return true;
		}
		return false;
	}
	
	public boolean update(Aluno aluno) {
		try{
			alunos.set(alunos.indexOf(aluno),aluno);
			return true;
		}catch (Exception e){
			return false;
		}
	}
	
	public Aluno select(String rgm) {
		for (int i=0;i< alunos.size();i++) {
			if ( ((Aluno)alunos.get(i)).getRgm().equals((rgm))){
				return (Aluno)alunos.get(i);
			}
		}
		return null;
	}
	
	public ArrayList selectAll() {
		return alunos;
	}
}
