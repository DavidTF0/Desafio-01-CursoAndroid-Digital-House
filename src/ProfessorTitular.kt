class ProfessorTitular(val especialidade: String, nome: String, sobrenome: String, tempoDeCasa: Int, codigoProfessor: Int ):
    Professor(nome, sobrenome, tempoDeCasa, codigoProfessor) {
    override fun toString(): String {
        return "Professor Titular (Codigo Professor Titular: ${codigoProfessor}, nome:$nome $sobrenome, especialidade: $especialidade, tempoDeCasa: $tempoDeCasa)"
    }
}