//> using scala 3.3.1
//> using dep org.scalameta::munit::1.3.0

//Run-length encoding of a list: https://aperiodic.net/pip/scala/s-99/#p10

import language.deprecated.symbolLiterals
import scala.annotation.tailrec
import munit.Clue.generate

type Encoding[T] = (Int, T)

def encode[T](list: List[T]): List[Encoding[T]] = encode(list, Nil).reverse

def encode[T](list: List[T], acc: List[Encoding[T]]): List[Encoding[T]] = {
  (list, acc) match {
    case (x:: xs, (count, elem)::encodings) if x == elem  => encode(xs, (count+1, elem)::encodings)
    case (x:: xs, _) => encode(xs, (1, x) :: acc)
    case (Nil, _) => acc
  }
}


class Tests extends munit.FunSuite:
  test("given an empty list return Nil"):
    assertEquals(encode(Nil), Nil)

  test("given input return expected"):
    val input = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expected = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
    assertEquals(encode(input), expected)


