#We shall say that an n-digit number is pandigital if it makes use of all the
#digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is 
#also prime.
#
#What is the largest n-digit pandigital prime that exists?

from tools import is_prime
from tools import is_prime_old


fl = [1,2,3,4,5,6,7]#,8]#,9]

l = fl[len(fl)-1]
pands = []

def permut(list, string):
    val = 0
    if string != "":
        val = int(string)
        pands.append(val)
    for i in range(0, len(list)):
        tmp = list[i]
        del list[i]
        string = string + str(tmp)
        permut(list, string)
        list.insert(i, tmp)
        string = string[:-1]

permut(fl, "")
pands.sort()
pands.reverse()

for pan in pands:
    if is_prime(pan):
        print pan
        break

