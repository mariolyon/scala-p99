//> using scala 3.3.1
//> using dep org.scalameta::munit::1.3.0

//Modified run-length encoding: https://aperiodic.net/pip/scala/s-99/#p11

import language.deprecated.symbolLiterals
import scala.annotation.tailrec

type Encoding[T] = (Int, T) | T

def encode[T](list: List[T]): List[Encoding[T]] = encode(list, Nil).reverse

def encode[T](list: List[T], acc: List[Encoding[T]]): List[Encoding[T]] = {
  (list, acc) match {
    case (x :: xs, (count: Int, elem) :: encodings) if x == elem => encode(xs, (count + 1, x) :: encodings)
    case (x :: xs, elem :: encodings) if x == elem => encode(xs, (2, x) :: encodings)
    case (x :: xs, _) => encode(xs, x :: acc)
    case (Nil, _) => acc
  }
}


class Tests extends munit.FunSuite:
  test("given an empty list return Nil"):
    assertEquals(encode(Nil), Nil)

  test("given input return expected"):
    val input = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expected = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
    assertEquals(encode(input), expected)



