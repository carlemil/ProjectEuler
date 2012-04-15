##Starting with 1 and spiralling anticlockwise in the following way, a square
##spiral with side length 7 is formed.
##
##37 36 35 34 33 32 31
##38 17 16 15 14 13 30
##39 18  5  4  3 12 29
##40 19  6  1  2 11 28
##41 20  7  8  9 10 27
##42 21 22 23 24 25 26
##43 44 45 46 47 48 49
##
##It is interesting to note that the odd squares lie along the bottom right
##diagonal, but what is more interesting is that 8 out of the 13 numbers lying
##along both diagonals are prime; that is, a ratio of 8/13 ~ 62%.
##
##If one complete new layer is wrapped around the spiral above, a square spiral
##with side length 9 will be formed. If this process is continued, what is the
##side length of the square spiral for which the ratio of primes along both
##diagonals first falls below 10%?

from tools import is_prime

a=0
b=0
c=0
d=0

t1=2
a=1
t2=4
b=1
t3=6
c=1
t4=8
d=1
nr = 0
nr_of_primes = 0
while True:
    a += t1
    t1 += 8
    b += t2
    t2 += 8
    c += t3
    t3 += 8
    d += t4
    t4 += 8

    nr += 4
    if is_prime(a):
        nr_of_primes += 1
    if is_prime(b):
        nr_of_primes += 1
    if is_prime(c):
        nr_of_primes += 1
    #if is_prime(d):
    #    nr_of_primes += 1

    if nr_of_primes*10 < nr:
        break

print b-a-1
