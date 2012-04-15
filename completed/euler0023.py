# -*- coding: cp1252 -*-
##A perfect number is a number for which the sum of its proper divisors is
##exactly equal to the number. For example, the sum of the proper divisors
##of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect
##number.
##
##A number whose proper divisors are less than the number is called deficient
##and a number whose proper divisors exceed the number is called abundant.
##
##As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
##number that can be written as the sum of two abundant numbers is 24. By
##mathematical analysis, it can be shown that all integers greater than 28123
##can be written as the sum of two abundant numbers. However, this upper
##limit cannot be reduced any further by analysis even though it is known
##that the greatest number that cannot be expressed as the sum of two abundant
##numbers is less than this limit.
##
##Find the sum of all the positive integers which cannot be written as the
##sum of two abundant numbers.

from tools import is_abundant
size = 28123
abu = [] # # 28123
ab_sum = range(0, size)

for a in range(0, size):
    if is_abundant(a):
        abu.append(a)
        
for a in ab_sum:
    l = 0
    u = len(abu)-1
    while l<=u:
        if abu[l]+abu[u]<a:
            l += 1
        elif abu[l]+abu[u]>a:
            u -= 1
        elif abu[l]+abu[u]==a:
            ab_sum[a]=0
            l = u+1
        else:
            print "ERROR !"

sum = 0
for s in ab_sum:
    sum += s

print sum
  
