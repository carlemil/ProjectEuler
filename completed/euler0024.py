# permutation is an ordered arrangement of objects. For example,
# 3124 is one possible permutation of the digits 1, 2, 3 and 4.
# If all of the permutations are listed numerically or alphabetically,
# we call it lexicographic order. The lexicographic permutations of
# 0, 1 and 2 are:

#012   021   102   120   201   210

# What is the millionth lexicographic permutation of the digits
# 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

def swap(v, a, b):
    t=v[a]
    v[a]=v[b]
    v[b]=t  


def next(v, n): 
## scan from right to left to find the first i such that
## v[i+1] > v[i]
    i = n - 2
    while ((i >= 0) and not(v[i+1] > v[i])):
         i = i-1  
    #print "i %d" % (i)
## If there is no such i, then the elements are in reverse
## lexicographical order and we have found the last permutation.
    if (i < 0): 
        return v

##Otherwise, exchange v[i] with the next-largest element
##in v[i+1],...,v[n]
    k = n - 1 
    while (v[i] > v[k]):
        k = k-1
    swap(v, i, k)
##then reverse P[i+1],...,P[n].

##    r = v[i:]
##    l = v[:i]
##    r.reverse()
##    l.extend(r)
##    v = l
##    print " mystiskt"
##    print v
##    print v[i+1:]
##    print i
    r = v[i+1:]
    l = v[:i+1]
##    print r
##    print l
    r.reverse()
    v = l+r
##    print "rev"
##    print v
    return v

v = [0,1,2,3,4,5,6,7,8,9]
n = len(v)

for a in range(999999):
    v = next(v, n)
##    print "-----"
s = ""
for a in v:
    s += str(a)
print s
