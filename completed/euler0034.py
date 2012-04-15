##145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
##
##Find the sum of all numbers which are equal to the sum of the
##factorial of their digits.
##
##Note: as 1! = 1 and 2! = 2 are not sums they are not included.

from tools import factor

facts = []
for f in range(1,11):
    facts.append(factor(f))

sum = 0
for i in range(3,100000):
    temp = []
    t = i
    while t/10 >= 1:
        temp.append(t-((t/10)*10))
        t = t /10
    temp.append(t)
    s = 0
    for j in temp:
        s += facts[j]
    if s == i:
        sum += s

print sum
