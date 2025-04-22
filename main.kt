import java.util.Scanner

fun main() {
    val tablero: Array<Array<String>> = arrayOf(
        arrayOf("1", "2", "3"),
        arrayOf("4", "5", "6"),
        arrayOf("7", "8", "9"),
    )
    mostrarTablero(tablero)
}

fun mostrarTablero(tablero: Array<Array<String>>) {
    println("*****Tablero*****")
    for (fila in tablero) {
        println(fila[0] + "|" + fila[1] + "|" + fila[2])
    }
}

fun manejarInputUsuario(scanner: Scanner, tablero: Array<Array<String>>) {

}