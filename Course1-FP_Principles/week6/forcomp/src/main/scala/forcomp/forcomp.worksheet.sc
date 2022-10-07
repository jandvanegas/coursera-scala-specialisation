def orderWordOccurrences(occurrences: List[(Char, Int)]): List[(Char, Int)] =
  val splitAt: Int = occurrences.length / 2
  if (occurrences.length == 1) occurrences
  else
    val (left, right) = occurrences.splitAt(splitAt)
    mergeOccurrences(orderWordOccurrences(left), orderWordOccurrences(right))

def mergeOccurrences(
    list1: List[(Char, Int)],
    list2: List[(Char, Int)]
): List[(Char, Int)] = list1 match
  case Nil => list2
  case x :: xs1 => {
    list2 match
      case Nil => list1
      case y :: ys1 =>
        if (x._2 <= y._2) x :: mergeOccurrences(xs1, list2)
        else y :: mergeOccurrences(list1, ys1)
  }
val test: String = "aaes"
val orderedOccurrences = test
  .toLowerCase()
  .groupBy(char => char)
  .map(x => Tuple2(x._1, x._2.length))
  .toList

orderWordOccurrences(orderedOccurrences)

def wordOccurrences(w: Word): Occurrences =
  w .toLowerCase()
    .groupBy(char => char)
    .map(x => Tuple2(x._1, x._2.length))
    .toList
    .sortWith((x, y) => x._2 < y._2)

type Word = String
type Sentence = List[Word]
type Occurrences = List[(Char, Int)]
val dictionary = List("ate", "eat", "tee", "tea", "test")
lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] =
  dictionary
    .map(w => Tuple2(wordOccurrences(w), w))
    .groupBy((occurrences, w) => occurrences)
    .map((occurences, list) => Tuple2(occurences, list.map(x => x._2)))

// dictionaryByOccurrences(orderedOccurrences)

def combinations(occurrences: Occurrences): List[Occurrences] = occurrences match
  case Nil => List(Nil)
  case x :: Nil =>
    (for 
      j <- 1 to x._2
    yield List(Tuple2(x._1, j))).toList
  case x :: xs =>
    (combinations(List(x)) ::: combinations(xs):::(for x_comb <- combinations(List(x))
      xs_comb <- combinations(xs)
    yield x_comb ::: xs_comb).toList).toSet.toList
      

val ans = combinations(orderedOccurrences)
ans.length
ans(1)
ans(2)
ans(3)
ans(4)
ans(5)
ans(6)
ans(7)
ans(8)
ans(9)
ans(10)
//ans(11)
//ans(12)
//ans(13)

combinations(Nil)

val abba = List(('a', 2), ('b', 2))
val abbacomb = combinations(abba)
abbacomb.length
val x = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
val y = List(('r', 1))

def remove(lista: List[(Char, Int)], b:(Char, Int)) : List[(Char, Int)]=
  lista.map(in => if (in._1 == b._1) (in._1, in._2 - b._2) else in)
    
val test2 = y.foldLeft(x)(remove)
      .filter(in => in._2 != 0)

