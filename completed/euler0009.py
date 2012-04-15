#A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,
#a2 + b2 = c2

#For example, 3'2 + 4'2 = 9 + 16 = 25 = 52.

#There exists exactly one Pythagorean triplet for which a + b + c = 1000.
#Find the product abc.

import math

for a in range(1,1000):
    for b in range(a+1,1000):
        c = math.sqrt(math.pow(a,2)+math.pow(b,2))
        if (a+b+c) == 1000:
            print a*b*c
