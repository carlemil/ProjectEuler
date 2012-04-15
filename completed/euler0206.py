# Find the unique positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0,
# where each "_" is a single digit.

def ver(t):
    s = str(t)
    if s[0]=='1' and s[2]=='2' and s[4]=='3' and s[6]=='4' and s[8]=='5' and s[10]=='6' and s[12]=='7' and s[14]=='8' and s[16]=='9' and s[18]=='0':
        return True
    return False

   #1010101010
l = 1010100030
   #1389026623
u = 1390000000
n = l
while n < u:
    n = n + 40
    if ver((n)**2):
        print "found if %d" % (n)
        break
    n = n + 60
    if ver((n)**2):
        print "found if %d" % (n)
        break
