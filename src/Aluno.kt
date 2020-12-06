data class Aluno (val nome: String, val sobrenome: String, val codigoAluno: Int) {
    override fun toString(): String {
        return "$nome $sobrenome com codigo de aluno: $codigoAluno)"
    }
}