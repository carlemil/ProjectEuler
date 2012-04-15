##Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
##containing over five-thousand first names, begin by sorting it into
##alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
##
##For example, when the list is sorted into alphabetical order, COLIN, which is
##worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
##would obtain a score of 938 53 = 49714.
##
##What is the total of all the name scores in the file?
def get_word_score(word):
    s = 0
    
    for i in range(0,len(word)):
        s += ord(word[i])-64

    #print "word: %s - score: %d " % (word, s)
    return s

data = []
score = 0

f = open("euler0022_names.txt")
while 1:
    line = f.readline()
    if not line: break
    a = line.lstrip().replace('"','').split(',')
    a.sort()
    i = 1
    for word in a:
        temp = get_word_score(word)
        score += temp * i
        i += 1

print score
