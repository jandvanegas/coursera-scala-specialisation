package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do print(s"${pascal(col, row)} ")
      println()

  /** Exercise 1
    */
  def pascal(c: Int, r: Int): Int =
    if (c == 0) {
      return 1
    } else if (c == r) {
      return 1
    } else {
      return pascal(c - 1, r - 1) + pascal(c, r - 1)
    }

  /** Exercise 2
    */
  def balance(chars: List[Char]): Boolean =
    openbrackets(chars, 0)

  def openbrackets(internalChars: List[Char], numOfOpenBrackets: Int): Boolean =
    if (internalChars.isEmpty){
      return numOfOpenBrackets == 0
    } else if (internalChars.head == '(' ){
      val newNumOfOpenBrackets = numOfOpenBrackets + 1
      return openbrackets(internalChars.tail, newNumOfOpenBrackets)
    } else if (internalChars.head == ')'){
      if (numOfOpenBrackets > 0){
        val newNumOfOpenBrackets = numOfOpenBrackets - 1
        return openbrackets(internalChars.tail, newNumOfOpenBrackets)
      }
      return false
    } else {
      return openbrackets(internalChars.tail, numOfOpenBrackets)
    }
  /** Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = ???
