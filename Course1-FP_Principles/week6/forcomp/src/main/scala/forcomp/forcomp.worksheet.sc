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
import forcomp.Anagrams.*

val x = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
val y = List(('r', 1))
subtract(x, y)
val sentence = List("Yes", "man")
val occurrences = sentenceOccurrences(sentence)
occurrences.length
val comb = combinations(occurrences)
comb(0)
sentenceOccurrences(sentence).length

val words =
  (
    for
      word <- comb
      if dictionaryByOccurrences.contains(word)
    yield word
  )
words.length
words.filter(a => a != words.head).length
comb.length
comb(0)

sentenceAnagrams(sentence)
