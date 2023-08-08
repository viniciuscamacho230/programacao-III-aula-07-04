package br.edu.umfg.tecnologia;

public class Aluno {
    private int registroAcademico;
    private String nome;
    private double notaPrimeraProva, notaPrimeraSegunda, notaTrabalho;
    private static final double PESO_PROVA = 0.35;
    private static final double PESO_TRABALHO = 0.3;

    public Aluno(int registroAcademico, String nome, double notaPrimeraProva, double notaPrimeraSegunda, double notaTrabalho) throws Exception {
        this.registroAcademico = registroAcademico;
        this.nome = nome;
        this.notaPrimeraProva = notaPrimeraProva;
        this.notaPrimeraSegunda = notaPrimeraSegunda;
        this.notaTrabalho = notaTrabalho;

        validarNota(notaPrimeraProva);
        validarNota(notaPrimeraSegunda);
        validarNota(notaTrabalho);
    }

    public double media(){
        return ((notaPrimeraProva + notaPrimeraSegunda) * PESO_PROVA) + (notaTrabalho * PESO_TRABALHO);
    }


    public String situcao(){
        //IF TERNARIO
        return media() >= 7.0 ? "APROVADO" : "EXAME";
    }

    @Override
    public String toString(){

        return "| R.A: " + registroAcademico + "| Nome: " + nome + " | Situação: " + situcao();
    }

    private void validarNota(double nota) throws Exception{
        if (nota < 0 || nota > 10)
            throw new Exception("Valor nota " + nota + "Invalido");
    }

}
