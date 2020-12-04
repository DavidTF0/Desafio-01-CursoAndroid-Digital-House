class DigitalHouseManager() {
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
        listaDeProfessores.remove(codigoProfessor)
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        val aluno = Aluno(nome = nome, sobrenome = sobrenome, codigoAluno = codigoAluno)
        listaDeAlunos[codigoAluno] = aluno
    }

    fun matricularAlunoNoCurso(codigoAluno: Int, codigoCurso: Int, data: String) {
        if (buscaCurso(codigoCurso) && buscaAluno(codigoAluno)) {
            val curso = listaDeCursos[codigoCurso]
            val aluno = listaDeAlunos[codigoAluno]

            if (aluno != null && curso != null) {
                curso.adicionarUmAluno(aluno)
                if (curso.adicionarUmAluno(aluno)) {
                    adicionaMatriculaALista(codigoCurso, codigoAluno, data)
                } else {
                    println("não foi possivel realizar a Matricula por não haver vagas no curso: ${listaDeCursos[codigoCurso]}")
                }
            }
        }
    }

    private fun adicionaMatriculaALista(codigoCurso: Int, codigoAluno: Int, data: String) {
      if (listaDeAlunos[codigoAluno] != null && listaDeCursos[codigoCurso] != null) {
            val matricula = Matricula(data, aluno = listaDeAlunos[codigoAluno],
                    curso = listaDeCursos[codigoCurso])
            listaDeMatriculas.add(matricula)
            println("Matricula do aluno ${listaDeAlunos[codigoAluno]} realizada no curso: ${listaDeCursos[codigoCurso]} ")
        } else {
            println("O aluno não existe ou não esta cadastrado\nO curso não existe ou não esta cadastrado")
        }
    }

    private fun buscaCurso(codigoCurso: Int): Boolean {
        if (listaDeCursos[codigoCurso]?.codigoCurso?.equals(codigoCurso) == true) {
            println("Curso encontrado: ${listaDeCursos[codigoCurso]}")
            return true
        } else {
            println("Curso não encontrado ou não Cadastrado")
            return false
        }
    }

    private fun buscaAluno(codigoAluno: Int): Boolean {
        if (listaDeAlunos[codigoAluno]?.codigoAluno?.equals(codigoAluno) == true) {
            println("Aluno encontrado: ${listaDeAlunos[codigoAluno]}")
            return true
        } else {
            println("Aluno não encontrado ou não Cadastrado")
            return false
        }
    }

    fun alocarProfessor(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {

    }

    fun buscaProfessorTitular(codigoProfessorTitular: Int) {
        if (listaDeProfessores[codigoProfessorTitular]?.codigoProfessor?.equals(codigoProfessorTitular) == true) {
            val professorTitular = listaDeProfessores[codigoProfessorTitular]
            if(professorTitular is ProfessorTitular){
                println(professorTitular)
                true
            }else {
                false
            }
        }
    }

    fun buscaProfessorAdjunto(codigoProfessorAdjunto: Int){
        if (listaDeProfessores[codigoProfessorAdjunto]?.codigoProfessor?.equals(codigoProfessorAdjunto) == true) {
            val professorAdjunto = listaDeProfessores[codigoProfessorAdjunto]
            if(professorAdjunto is ProfessorAdjunto){
                println(professorAdjunto)
                true
            }else {
                false
            }
        }
    }
}





