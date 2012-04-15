from tools import get_primes
from tools import is_permutation
import datetime

a = []
n = 9999

ts = datetime.datetime.now()
list_of_primes = [prime for prime in get_primes(n) if prime > 999]
set_of_primes = set(p for p in list_of_primes)

#print "\n".join(str(p) for p in list_of_primes)
print datetime.datetime.now() - ts
ts = datetime.datetime.now()

for p1p in range(len(list_of_primes)):
    p1 = list_of_primes[p1p]
    for p2p in range(p1p+1, len(list_of_primes)):
        p2 = list_of_primes[p2p]
        p3 = (p2+(p2-p1))
        if p3 in set_of_primes:
            #print "p1 " + str(p1) + " p2 " + str(p2) + " (p2+(p2-p1)) " + str(p2+(p2-p1))
            if is_permutation(str(p1), str(p2)) and is_permutation(str(p2), str(p3)):
                print str(p1) +"  "+ str(p2) +"  "+ str(p3)

print datetime.datetime.now() - ts

