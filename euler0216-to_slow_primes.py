##Consider numbers t(n) of the form t(n) = 2n^2-1 with n > 1.
##The first such numbers are 7, 17, 31, 49, 71, 97, 127 and 161.
##It turns out that only 49 = 7*7 and 161 = 7*23 are not prime.
##For n 10000 there are 2202 numbers t(n) that are prime.
##
##How many numbers t(n) are prime for n 50,000,000 ?

from tools import get_primes
n = 10000
list_of_primes = get_primes(n*100)
set_of_primes = set(p for p in list_of_primes)
def t(n):
    return (2*(n**2))-1
p=0
i=0

for n in range(2,n):
    i+=1
##    if i % 1000 == 0:
##        print i
    if t(n) in set_of_primes:
        p+=1
        print t(n)
##    print "--- %d" % (n)
##print "-----"
print i
print p

