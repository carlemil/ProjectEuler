import math

def read_file(name):
    data = []
    f = open(name)
    while 1:
        line = f.readline()
        if not line: break
        data.append(line[1:-1].split('","'))
    f.close()
    return data
	
def is_prime(a):
    a = abs(a)
    if a == 1:
        return False
    if a==2 or a==3 or a==5:
        return True
    if a%2==0 or a%3==0 or a%5==0:
        return False
    i = 5
    asqrt = int(math.sqrt(a))
    while i < asqrt:
        i += 2
        if a % i == 0:
            return False
        i += 4
        if a % i == 0:
            return False
    return True

def get_primes(max):
    if max < 40000:
        return get_primes_low(max)
    else:
        return get_primes_high(max)

def get_primes_high(max):
    list=[2]
    append = list.append
    for cand in range(3, max+1, 2):
        if is_prime(cand):
            append(cand)
    return list
    
def get_primes_low(max):
    list = [0 for a in range(0, max+1)]
    for cand in range(2, max+1):
        for not_prime in range(cand*2, max+1, cand):
            list[not_prime] = 1
    ret_list = []
    for pos in range(2,max+1):
        if list[pos] == 0:
            ret_list.append(pos)
    return ret_list


def next_prime(p):
    p += 1
    while not is_prime(p):
        p += 1
    return p

def factor(n):
    f = 1
    for i in range(1,n):
        f *= i
    return f

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

def is_palindromic(a):
    return str(a) == str(a)[::-1]

def is_amicable(n):
    sd = 0
    for d in get_divisors(n):
        sd += d
    ss = 0
    for d in get_divisors(sd):
        ss += d
    if ss == n and ss != sd:
        return True
    return False

def is_pandigital_1to9(pan):
    pand_list = [0 for x in range(0, 11)]
    s = str(pan)
    nio = 0
    if len(s) == 9:
        for i in range(0,9):
            if pand_list[int(s[i])]==0:
                pand_list[int(s[i])] = 1
                nio += 1
    if nio == 9 and pand_list[0]==0:
        return True
    return False

def is_abundant(n):
    s = 0
    i = 1 
    b = n/i
    while i<=b:
        if(n%i==0):
            s += i
            if b != i:
                if n % b == 0:
                    s += b
        i = i + 1
        b = n / i

    if s > n*2:
        return True
    else:
        return False

def is_permutation(a, b):
    a_ = [t for t in a]
    b_ = [t for t in b]
    a_.sort()
    b_.sort()
    if a_ == b_:
        return True
    return False

def get_divisors_old_n_slow(a):
    divisors = []
    for i in range (1,a):
        if(a%i==0):
            divisors.append(i)
    divisors.append(a)
    return divisors

def swap(v, a, b):
    t=v[a]
    v[a]=v[b]
    v[b]=t
    
def triangle_number(tn):
    return int(1.0/2 * tn * (tn + 1))

def pentagonal_number(tn):
    return int(1.0/2 * tn * (3 * tn - 1))
    
def hexagonal_number(tn):
    return int(tn * (2 * tn - 1))

def word_value(a):
    res = 0
    for c in a:
        res += ord(c) - 64
    return res
    
def get_divisors(a):
    divisors = []
    i = 2
    b = a/i
    while i<=b:
        if(a%i==0):
            divisors.append(i)
            if b != i:
                if a % b == 0:
                    divisors.append(b)
        i = i + 1
        b = a / i
    divisors.append(1)
    return divisors

def next_lex_permutation(v, n): 
## scan from right to left to find the first i such that
## v[i+1] > v[i]
    i = n - 2
    while ((i >= 0) and not(v[i+1] > v[i])):
         i = i-1  
## If there is no such i, then the elements are in reverse
## lexicographical order and we have found the last permutation.
    if (i < 0): 
        return None
##Otherwise, exchange v[i] with the next-largest element
##in v[i+1],...,v[n]
    k = n - 1 
    while (v[i] > v[k]):
        k = k-1
    swap(v, i, k)
##then reverse P[i+1],...,P[n].
    r = v[i+1:]
    l = v[:i+1]
    r.reverse()
    v = l+r
    return v
