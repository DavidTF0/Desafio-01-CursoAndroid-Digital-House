class ProfessorAdjunto(var quantidadeDeHorasDeMonitoria: Int, nome: String, sobrenome: String, tempoDeCasa: Int, codigoProfessor: Int):
    Professor(nome, sobrenome, tempoDeCasa, codigoProfessor) {
    override fun toString(): String {
        return "Professor Adjunto nome: $nome $sobrenome, com codigo de Professor Adjunto: $codigoProfessor e a quantidade de Horas de Monitoria: $quantidadeDeHorasDeMonitoria \ntendo o tempo De Casa: $tempoDeCasa"
    }
}