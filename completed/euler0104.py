# The Fibonacci sequence is defined by the recurrence relation:
#
# Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.
# It turns out that F541, which contains 113 digits, is the first
# Fibonacci number for which the last nine digits are 1-9 pandigital
# (contain all the digits 1 to 9, but not necessarily in order).
# And F2749, which contains 575 digits, is the first Fibonacci
# number for which the first nine digits are 1-9 pandigital.
#
# Given that Fk is the first Fibonacci number for which the first
# nine digits AND the last nine digits are 1-9 pandigital, find k.

from tools import is_pandigital_1to9

f1 = 1
f2 = 1
k = 2
loop = True
while loop:
    temp = f1
    f1 += f2
    f2 = temp
    k += 1
    if is_pandigital_1to9(str(f1)[0: 9]):
        if is_pandigital_1to9(str(f1)[-9:]):
            print k
            loop = False
