fun main(){

    val digitalHouseManager = DigitalHouseManager()

    digitalHouseManager.registrarProfessorTitular("Jose", "Santa cruz", 10001, "Android")

    digitalHouseManager.registrarProfessorTitular("João", "Luiz", 10002, "Full Stack")

    digitalHouseManager.registrarProfessorAdjunto("David", "Teles", 10003, 0)

    digitalHouseManager.registrarProfessorAdjunto("Maria", "Camargo", 10004,0)

    digitalHouseManager.registrarProfessorAdjunto("Teste01", "exclusão de Professor", 10005, 10)

    digitalHouseManager.registrarCurso("Full Stack",20001,3)

    digitalHouseManager.registrarCurso("Android", 20002, 2)

    digitalHouseManager.registrarCurso("Curso teste de exclusão", 20003, 10)

    digitalHouseManager.matricularAluno("Luiz", "Freitas", 30001)

    digitalHouseManager.matricularAluno("Roberto", "Pereira", 30002)

    digitalHouseManager.matricularAluno("Juliana", "Bernardes", 30003)

    digitalHouseManager.matricularAluno("Aluno Teste exclusão", "", 30004)

    digitalHouseManager.alocarProfessor(20001,10002,10003)

    digitalHouseManager.alocarProfessor(20002,10001,10004)

    digitalHouseManager.matricularAlunoNoCurso(30001,20001,"06/12/2020")

    digitalHouseManager.matricularAlunoNoCurso(30002,20001,"06/12/2020")

    digitalHouseManager.matricularAlunoNoCurso(30004,20001,"06/12/2020")

    digitalHouseManager.matricularAlunoNoCurso(30001,20002,"06/12/2020")

    digitalHouseManager.matricularAlunoNoCurso(30001,20002,"06/12/2020")

    digitalHouseManager.matricularAlunoNoCurso(30003,20002,"06/12/2020")

    digitalHouseManager.excluirCurso(20003)

    digitalHouseManager.excluirProfessor(10005)

    digitalHouseManager.removeAlunoDoCurso(20001, 30004)




}
