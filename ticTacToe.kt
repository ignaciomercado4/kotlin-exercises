import java.util.Scanner
import kotlin.random.Random

fun main() {
    var tablero: Array<String> = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
    val scanner = Scanner(System.`in`)

    while (!verificarGanador(tablero)) {
        manejarInputUsuario(scanner, tablero)
        manejarTurnoMaquina(tablero)
    }

    scanner.close()
    return
}

fun mostrarTablero(tablero: Array<String>) {
    println("*****Tablero*****")
    println(tablero[0] + "|" + tablero[1] + "|" + tablero[2])
    println(tablero[3] + "|" + tablero[4] + "|" + tablero[5])
    println(tablero[6] + "|" + tablero[7] + "|" + tablero[8])
}

fun manejarInputUsuario(scanner: Scanner, tablero: Array<String>) {
    var posicionElegidaEsValida: Boolean = false
    mostrarTablero(tablero)
    println("Elija una posición para rellenar")
    do {
        val eleccionUsuario: String = scanner.nextLine()
        if (!(eleccionUsuario.toInt() > 0 && eleccionUsuario.toInt() <= 9)) {
            println("Posicion fuera de los límites")
        } else if (tablero[eleccionUsuario.toInt() - 1] == "X" ||
            tablero[eleccionUsuario.toInt() - 1] == "O") {
            println("Posición ocupada")
        } else {
            tablero[eleccionUsuario.toInt() - 1] = "X"
            posicionElegidaEsValida = true
        }
    } while (!posicionElegidaEsValida)
    return
}

fun manejarTurnoMaquina(tablero: Array<String>) {
    var posicionElegidaEsValida: Boolean = false
    mostrarTablero(tablero)
    do {
        val eleccionUsuario: String = Random.nextInt(0, 9).toString()
        if (!(eleccionUsuario.toInt() >= 0 && eleccionUsuario.toInt() <= 9)) {
            continue
        } else if (tablero[eleccionUsuario.toInt()] == "X" ||
            tablero[eleccionUsuario.toInt() - 1] == "O") {
            continue
        } else {
            tablero[eleccionUsuario.toInt() - 1] = "O"
            posicionElegidaEsValida = true
        }
    } while (!posicionElegidaEsValida)
    return
}

fun verificarGanador(tablero: Array<String>): Boolean {
    // horizontales
    if (tablero[0] == tablero[1] && tablero[1] == tablero[2]) {
        println("***************")
        println("Ganó " + tablero[0])
        return true
    }
    if (tablero[3] == tablero[4] && tablero[4] == tablero[5]) {
        println("***************")
        println("Ganó " + tablero[3])
        return true
    }
    if (tablero[6] == tablero[7] && tablero[7] == tablero[8]) {
        println("***************")
        println("Ganó " + tablero[6])
        return true
    }

    //verticales
    if (tablero[0] == tablero[3] && tablero[3] == tablero[6]) {
        println("***************")
        println("Ganó " + tablero[0])
        return true
    }
    if (tablero[1] == tablero[4] && tablero[4] == tablero[7]) {
        println("***************")
        println("Ganó " + tablero[1])
        return true
    }
    if (tablero[2] == tablero[5] && tablero[5] == tablero[8]) {
        println("***************")
        println("Ganó " + tablero[2])
        return true
    }

    //diagonales
    if (tablero[0] == tablero[4] && tablero[4] == tablero[8]) {
        println("***************")
        println("Ganó " + tablero[0])
        return true
    }
    if (tablero[2] == tablero[4] && tablero[4] == tablero[6]) {
        println("***************")
        println("Ganó " + tablero[3])
        return true
    }
    if (tablero.all { it == "X" || it == "O" }) {
        println("***************")
        println("Empate!")
        return true
    }

    return false
}