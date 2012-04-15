##The product 7254 is unusual, as the identity, 39 * 186 = 7254, containing
##multiplicand, multiplier, and product is 1 through 9 pandigital.
##
##Find the sum of all products whose multiplicand/multiplier/product identity
##can be written as a 1 through 9 pandigital.
##HINT: Some products can be obtained in more than one way so be sure to only
##include it once in your sum.

from sets import Set

def is_pandigital(mand, mier, prod):
    pand_list = [0 for x in range(0, 11)]
    s = str(mand)+str(mier)+str(prod)
    nio = 0
    if len(s) == 9:
        for i in range(0,9):
            if pand_list[int(s[i])]==0:
                pand_list[int(s[i])] = 1
                nio += 1
    if nio == 9 and pand_list[0]==0:
        return True
    return False

prod_list = []

max=10000

for i in range(max):
    for j in range(max):
        if i*j>max:
            break
        if is_pandigital(i, j, i*j):
            prod_list.append(i*j)
set = Set(prod_list)
print sum(set)

