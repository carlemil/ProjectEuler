##The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
##
##Find the sum of all numbers, less than one million, which are palindromic
##in base 10 and base 2.
##
##(Please note that the palindromic number, in either base, may not include
## leading zeros.)

from tools import is_palindromic

def to_base_2(n):
    n = int(n)
    ret = ""
    while n > 0:
        if n==((n>>1)<<1):
            ret = "0" + ret
        else:
            ret = "1" + ret
        n=n>>1
    return ret

import math
sum = 0

for p in range(0, 999999):
    if p%10!=0 and is_palindromic(p):  
        b2 = to_base_2(str(p))
        if is_palindromic(b2):
            sum += int(p)

print sum
