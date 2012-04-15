from tools import get_primes
import datetime

a = []
n = 1000000

#ts = datetime.datetime.now()
list_of_primes = get_primes(n)
#print datetime.datetime.now() - ts
#ts = datetime.datetime.now()

primes = set(p for p in list_of_primes)

max_sum = 0
max_len = 0
for i in range(len(list_of_primes)):
    sum = 0
    len = 0
    while sum < list_of_primes[-1]:
        sum = sum + list_of_primes[len]
        len = len + 1
        if len > max_len and sum in primes:
            max_len = len
            max_sum = sum
    del list_of_primes[0]

#print datetime.datetime.now() - ts
print "Prime " + str(max_sum)
