# A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 is almost unimaginably 
# large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.
#
#Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum

from math import pow

m = 0

for i in range(1L,100L):
    for j in range(1L,100L):
        p = i**j
        s = 0
        while (p):
            s += p % 10L
            p = p / 10L
        if s > m:
            m = s

print m
