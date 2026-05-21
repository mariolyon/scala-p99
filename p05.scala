//> using scala 3.3.1
//> using dep org.scalameta::munit::1.3.0

// Reverse a list: https://aperiodic.net/pip/scala/s-99/#p05
import scala.annotation.tailrec

def reverse[A](list: List[A]): List[A] =
  reverseRec(list, Nil)

@tailrec
def reverseRec[A](list: List[A], tail: List[A]): List[A] = {
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
