//> using scala 3.3.1
//> using dep org.scalameta::munit::1.3.0

import scala.annotation.tailrec

def reverse(list: List[Int]): List[Int] =
  reverseRec(list, Nil)

@tailrec
def reverseRec(list: List[Int], tail: List[Int]): List[Int] = {
  (list, tail) match {
    case (Nil, tail) => tail
    case (x::Nil, tail) => x:: tail
    case (x::xs, tail) => reverseRec(xs, x:: tail)
  }
}

class Tests extends munit.FunSuite:
  test("given an empty list return None"):
    assertEquals(reverse(Nil), Nil)

  test("given a list of one element return the same list"):
    assertEquals(reverse(List(1)), List(1))

  test("given a list of two than element return the reversed list"):
    assertEquals(reverse(List(1, 2, 3)), List(3, 2, 1))
