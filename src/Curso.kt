data class Curso(val nome: String, val codigoCurso: Int, var professorTitular: ProfessorTitular?, var professorAdjunto: ProfessorAdjunto?,
                 val quantidadeMaximaDeAlunos: Int) {

    var listaDeAlunosDoCurso = mutableListOf<Aluno>()

    fun adicionarUmAluno(umAluno:Aluno):Boolean{
        if(listaDeAlunosDoCurso.size == quantidadeMaximaDeAlunos){
            println("Curso esta com a quantidade Maxima de Alunos.\n E o Aluno não pode ser adicionado a esse curso.")
            return false
        }else{
            listaDeAlunosDoCurso.add(umAluno)
            println("Aluno adicionado ao Curso de codigo:${codigoCurso}, $nome")
            return true
        }
    }

    fun excluirAluno(umAluno: Aluno){
        listaDeAlunosDoCurso.remove(umAluno)
    }
}
