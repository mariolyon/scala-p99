//> using scala 3.3.1
//> using dep org.scalameta::munit::1.3.0

//isPalindrome: https://aperiodic.net/pip/scala/s-99/#p06

import scala.annotation.tailrec

def isPalindrome[A](list: List[A]): Boolean =
  list.nonEmpty && list.reverse.equals(list)

class Tests extends munit.FunSuite:
  test("given an empty list return false"):
    assertEquals(isPalindrome(Nil), false)

  test("given a palindrome return true"):
    assertEquals(isPalindrome("abcba".toList), true)

  test("given a non palindrome return false"):
    assertEquals(isPalindrome("abcbd".toList), false)
