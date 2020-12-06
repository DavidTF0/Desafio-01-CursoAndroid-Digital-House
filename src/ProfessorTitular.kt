class ProfessorTitular(val especialidade: String, nome: String, sobrenome: String, tempoDeCasa: Int, codigoProfessor: Int ):
    Professor(nome, sobrenome, tempoDeCasa, codigoProfessor) {
    override fun toString(): String {
        return "Professor Titular nome: $nome $sobrenome, especialista em $especialidade, com o tempo de casa: $tempoDeCasa"
    }
}