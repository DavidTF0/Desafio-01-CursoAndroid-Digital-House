class DigitalHouseManager {
    private var listaDeAlunos = mutableMapOf<Int, Aluno>()
    private var listaDeCursos = mutableMapOf<Int, Curso>()
    private var listaDeProfessores = mutableMapOf<Int, Professor>()
    private var listaDeMatriculas = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {
        val curso = Curso(
                nome = nome, codigoCurso = codigoCurso,
                quantidadeMaximaDeAlunos = quantidadeMaximaDeAlunos, professorTitular = null, professorAdjunto = null,
        )
        listaDeCursos[codigoCurso] = curso
    }

    fun excluirCurso(codigoCurso: Int) {
        println("Curso de codigo: $codigoCurso e nome ${listaDeCursos[codigoCurso]?.nome}, sera excluido\n")
        listaDeCursos.remove(codigoCurso)
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int,
                                  quantidadeDeHorasDeMonitoria: Int) {
        val professorAdjunto = ProfessorAdjunto(nome = nome, sobrenome = sobrenome,
                codigoProfessor = codigoProfessor, quantidadeDeHorasDeMonitoria = 0, tempoDeCasa = 0)
        listaDeProfessores[codigoProfessor] = professorAdjunto
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        val professorTitular = ProfessorTitular(nome = nome, sobrenome = sobrenome, especialidade = especialidade,
                tempoDeCasa = 0, codigoProfessor = codigoProfessor)
        listaDeProfessores[codigoProfessor] = professorTitular
    }

    fun excluirProfessor(codigoProfessor: Int) {
        println("Professor de codigo: $codigoProfessor e nome ${listaDeProfessores[codigoProfessor]?.nome} ${listaDeProfessores[codigoProfessor]?.sobrenome}, sera excluido\n")
        listaDeProfessores.remove(codigoProfessor)
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        val aluno = Aluno(nome = nome, sobrenome = sobrenome, codigoAluno = codigoAluno)
        listaDeAlunos[codigoAluno] = aluno
    }

    fun matricularAlunoNoCurso(codigoAluno: Int, codigoCurso: Int, data: String) {
        if (buscarCurso(codigoCurso) && buscarAluno(codigoAluno)) {
            val curso = listaDeCursos[codigoCurso]
            val aluno = listaDeAlunos[codigoAluno]

            if (aluno != null && curso != null) {
                curso.adicionarUmAluno(aluno)
                if (curso.adicionarUmAluno(aluno)) {
                    adicionaMatriculaALista(codigoCurso, codigoAluno, data)
                    println("Aluno ${listaDeAlunos[codigoAluno]?.nome} ${listaDeAlunos[codigoAluno]?.sobrenome}\n" +
                            "adicionado ao curso ${listaDeCursos[codigoCurso]?.nome}")
                } else {
                    println("não foi possivel realizar a Matricula\n" +
                            "por não haver vagas no curso: ${listaDeCursos[codigoCurso]?.nome}\n")
                }
            }
        }
    }

    private fun adicionaMatriculaALista(codigoCurso: Int, codigoAluno: Int, data: String) {
      if (listaDeAlunos[codigoAluno] != null && listaDeCursos[codigoCurso] != null) {
            val matricula = Matricula(data, aluno = listaDeAlunos[codigoAluno],
                    curso = listaDeCursos[codigoCurso])
            listaDeMatriculas.add(matricula)
            println("Matricula do aluno ${listaDeAlunos[codigoAluno]}" +
                    " realizada no curso: ${listaDeCursos[codigoCurso]?.nome}\n")
        } else {
            println("O aluno com o codigo: $codigoAluno, não existe ou não esta cadastrado\n" +
                    "O curso de codigo: $codigoCurso não existe ou não esta cadastrado\n")
        }
    }

    private fun buscarCurso(codigoCurso: Int): Boolean {
        if (listaDeCursos[codigoCurso]?.codigoCurso?.equals(codigoCurso) == true) {
            println("Curso encontrado: ${listaDeCursos[codigoCurso]}\n")
            return true
        } else {
            println("Curso de codigo: $codigoCurso, não encontrado ou não Cadastrado\n")
            return false
        }
    }

    private fun buscarAluno(codigoAluno: Int): Boolean {
        if (listaDeAlunos[codigoAluno]?.codigoAluno?.equals(codigoAluno) == true) {
            println("Aluno encontrado: ${listaDeAlunos[codigoAluno]}\n")
            return true
        } else {
            println("Aluno de codigo: $codigoAluno, não encontrado ou não Cadastrado\n")
            return false
        }
    }

    fun alocarProfessor(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        if(buscarCurso(codigoCurso) && buscarProfessorTitular(codigoProfessorTitular) && buscarProfessorAdjunto(codigoProfessorAdjunto)){
            val curso = listaDeCursos[codigoCurso]
            val professorTitular = listaDeProfessores[codigoProfessorTitular]
            val professorAdjunto = listaDeProfessores[codigoProfessorAdjunto]

            curso?.professorTitular = professorTitular as ProfessorTitular
            curso?.professorAdjunto = professorAdjunto as ProfessorAdjunto

            println("Professores alocados no curso: ${listaDeCursos[codigoCurso]?.nome}\n")
        }
    }

    private fun buscarProfessorTitular(codigoProfessorTitular: Int): Boolean {
        if (listaDeProfessores[codigoProfessorTitular]?.codigoProfessor?.equals(codigoProfessorTitular) == true) {
            val professorTitular = listaDeProfessores[codigoProfessorTitular]
            if(professorTitular is ProfessorTitular){
                println("Professor Titular encontrado: ${listaDeProfessores[codigoProfessorTitular]}\n")
                return true
            }
        }
        println("Codigo de professor titular: $codigoProfessorTitular, não existe ou não esta cadastrado\n")
        return false
    }

    private fun buscarProfessorAdjunto(codigoProfessorAdjunto: Int):Boolean {
        if (listaDeProfessores[codigoProfessorAdjunto]?.codigoProfessor?.equals(codigoProfessorAdjunto) == true) {
            val professorAdjunto = listaDeProfessores[codigoProfessorAdjunto]
            if(professorAdjunto is ProfessorAdjunto) {
                println("Professor Adjunto encontrado: ${listaDeProfessores[codigoProfessorAdjunto]}\n")
                return true
            }
        }
        println("Codigo de professor adjunto: $codigoProfessorAdjunto, não existe ou não esta cadastrado\n")
        return false
    }

    fun removeAlunoDoCurso(codigoCurso: Int, codigoAluno: Int){
        if(buscarCurso(codigoCurso) && buscarAluno(codigoAluno)){
            val aluno = listaDeAlunos[codigoAluno] as Aluno
            listaDeCursos[codigoCurso]?.excluirAluno(aluno)
        }
    }
}





