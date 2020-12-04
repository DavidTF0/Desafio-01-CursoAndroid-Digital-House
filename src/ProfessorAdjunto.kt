class ProfessorAdjunto(var quantidadeDeHorasDeMonitoria: Int, nome: String, sobrenome: String, tempoDeCasa: Int, codigoProfessor: Int):
    Professor(nome, sobrenome, tempoDeCasa, codigoProfessor) {
    override fun toString(): String {
        return "Professor Adjunto (Codigo Professor Adjunto: ${codigoProfessor}, nome:$nome $sobrenome, Quantidade de Horas de Monitoria: $quantidadeDeHorasDeMonitoria, tempoDeCasa: $tempoDeCasa)"
    }
}