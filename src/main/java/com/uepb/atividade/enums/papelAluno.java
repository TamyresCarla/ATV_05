package com.uepb.atividade.enums;

public enum papelAluno {

	ESTAGIO(1, "Estagiario"), JUNIOR(2, "Junior"), PLENO(3, "Pleno"), SENIOR(4, "Senior"), MASTER(5, "Master"), ESPECIALISTA(6,"Especialista");

	private int cod;
	private String descricao;

	private papelAluno(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static papelAluno toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (papelAluno x : papelAluno.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
