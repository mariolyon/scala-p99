//> using scala 3.3.1
//> using dep org.scalameta::munit::1.3.0

//title: https://aperiodic.net/pip/scala/s-99/#pxx

import language.deprecated.symbolLiterals
import scala.annotation.tailrec

def solve[A](list: List[Any]): List[Any] = ???

class Tests extends munit.FunSuite:
  test("given an empty list return Nil"):
    assertEquals(solve(Nil), Nil)

  test("given input return expected"):
    val input = ???
    val expected = ???
    assertEquals(solve(input), expected)


