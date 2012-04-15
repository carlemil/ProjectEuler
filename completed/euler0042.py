# The nth term of the sequence of triangle numbers is given by, tn = 1/2n(n+1); so the first ten 
# triangle numbers are:
#
# 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
#
# By converting each letter in a word to a number corresponding to its alphabetical position 
# and adding these values we form a word value. For example, the word value for SKY is 19 + 11 
# + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a 
# triangle word.
#
# Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing 
# nearly two-thousand common English words, how many are triangle words?

from tools import triangle_number
from tools import word_value

max = 100
triangle_numbers = [0 for i in range(0, triangle_number(max+1))]

for i in range(0, max):
    triangle_numbers[triangle_number(i)] = 1
    
f = file('euler0042_words.txt')
c = 0

for word in f.readline()[1:-1].split('","'):
    c += triangle_numbers[word_value(word)]

print c
