#The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

#Find the sum of all the primes below two million.

import tools

p = tools.next_prime(0)
sum = 0
while p <= 2000000:
    sum = sum + p
    p = tools.next_prime(p)
    #print p

print sum
