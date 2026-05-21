//> using scala 3.3.1
//> using dep org.scalameta::munit::1.3.0

import scala.annotation.tailrec

def length[A](list: List[A]): Int = {
  lengthRec(0, list)
}

@tailrec
def lengthRec[A](acc: Int, list: List[A]): Int = {
  list match {
    case Nil => acc
    case x:: Nil => acc + 1
    case x:: xs => lengthRec(acc + 1, xs)
  }
}

class Tests extends munit.FunSuite:
  test("given an empty list return 0"):
    assertEquals(length(Nil), 0)

  test("given list of elements return the length"):
    assertEquals(length(List(1, 2, 3)), 3)
