/*
1. работой с преобразованием строк
2. базовой арифметикой и выводом результата в консоль
3. примерами интерполяции сток
4. преобразованием типов
5. примером условных операторов (if else)
6. примером с циклами (for while)
7. примером создания отдельной функции
8. примером работы с массивом
*/
import kotlin.random.Random
data class GameResult(val number: Number,val number_win:Int ,var result:Boolean )
fun main(){
    println("Your name")
    val name:String = readln()
    val introduction:String = name + " welcome to our exciting game!"
    println(introduction)
    print("Select the number of rounds in the game\n")
    val round_str:String = readln()//.toInt()
    val round:Int = round_str.toInt() // Только ради преобразования типов
    games(round)
}
fun games(round:Int){
    var difference:Int
    var ratio:Double
    var ratio_loss:Double
    var number_of_wins:Int = 0
    var number_of_losses:Int = 0
    var number:Int
    var number_win:Int
    var result:Boolean = false
    var statistics = mutableListOf<GameResult>()
    print("To win the game you need to guess a number from 1 to 5\n")
    print("Ready? (y/n)\n")
    var ready_state: Boolean = false
    while (ready_state != true){
        if (readln().toLowerCase() == "y"){break}
        else{print("Ready? (y/n)\n")}
    }
    for (i in 1..3) {Thread.sleep(1000)
        println("We start in $i")
    }
    for (i in 1..round){
        println("Enter the number")
        number = readln().toInt()
        number_win = Random.nextInt(1, 6)
        result = number == number_win
        statistics.add(GameResult(number,number_win,result))
        if (result == true) {
            println("You win")
            number_of_wins += 1
        }
        else {
            println("You loss")
            number_of_losses += 1
        }

    }
    print("Statistic:\n")
    for (element in statistics) {print("Your number: ${element.number} | Winning number: ${element.number_win} | Game result: ${element.result}\n")}
    difference = round - number_of_wins
    ratio = number_of_wins.toDouble() / round * 100
    ratio_loss = number_of_losses.toDouble() / round * 100
    println("How many times have you lost: $difference | Win percentage: ${ratio.toInt()}% | Damage percentage: ${ratio_loss.toInt()}%")
}