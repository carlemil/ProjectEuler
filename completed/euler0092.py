# A number chain is created by continuously adding the square of the digits in a number to form a 
# new number until it has been seen before.
#
# For example,
#
# 44  32  13  10  1  1
# 85  89  145  42  20  4  16  37  58  89
#
# Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing 
# is that EVERY starting number will eventually arrive at 1 or 89.
#
# How many starting numbers below ten million will arrive at 89?

from sets import Set

tmp = Set()

l01 = [0 for i in range(0, 7*(9*9) + 1)]
l89 = [0 for i in range(0, 7*(9*9) + 1)]
l01[1] = 1
l89[89] = 1
t89 = 0
t01 = 0


def nextNumber(n):
    k = 0 
    while n: 
        m = n % 10 
        n = n/10 
        k = k + m*m 
    return k 

for i in range(1, 10000001):
    n = i
    tmp.clear()
    while(True):
        n = nextNumber(n)
        tmp.add(n)
        if (l01[n] == 1):
            for t in tmp:
                l01[t] = 1
            t01 += 1
            break
        if (l89[n] == 1):
            for t in tmp:
                l89[t] = 1
            t89 += 1
            break

print t89
