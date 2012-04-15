# It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, 
# but in a different order.
#
# Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

from tools import is_permutation

for i in range(1, 10000000):
    if is_permutation(str(i), str(i*2)):
        if is_permutation(str(i), str(i*3)):
            if is_permutation(str(i), str(i*4)):
                if is_permutation(str(i), str(i*5)):
                    if is_permutation(str(i), str(i*6)):
                        print i
                        break

