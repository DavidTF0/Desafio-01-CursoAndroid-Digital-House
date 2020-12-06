fun main(){

    val digitalHouseManager = DigitalHouseManager()

    digitalHouseManager.registrarProfessorTitular("Jose", "Santa cruz", 1, "Android")
    digitalHouseManager.registrarProfessorAdjunto("David", "Teles", 2, 0)
    digitalHouseManager.registrarCurso("Android",1,5)
    digitalHouseManager.alocarProfessor(1,1,2)


}
