data class Curso(val nome: String, val codigoCurso: Int, var professorTitular: ProfessorTitular?, var professorAdjunto: ProfessorAdjunto?,
                 val quantidadeMaximaDeAlunos: Int) {

    var listaDeAlunosDoCurso = mutableListOf<Aluno>()

    fun adicionarUmAluno(umAluno:Aluno):Boolean{
        if(listaDeAlunosDoCurso.size == quantidadeMaximaDeAlunos){
            println("Curso esta com a quantidade Maxima de Alunos.\nE o Aluno não pode ser adicionado ao curso $nome\n")
            return false
        }else{
            listaDeAlunosDoCurso.add(umAluno)
            println("Aluno adicionado ao Curso de codigo:${codigoCurso}, $nome\n")
            return true
        }
    }

    fun excluirAluno(umAluno: Aluno){
        println("$umAluno sera excluido do curso $nome\n")
        listaDeAlunosDoCurso.remove(umAluno)
    }

    override fun toString(): String {
        return "Curso $nome com codigo de curso: $codigoCurso com professorTitular $professorTitular e professorAdjunto $professorAdjunto \ntendo uma sala com a quantidade maxima de Alunos de $quantidadeMaximaDeAlunos"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Curso

        if (codigoCurso != other.codigoCurso) return false

        return true
    }
}
