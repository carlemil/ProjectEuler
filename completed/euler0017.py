##If the numbers 1 to 5 are written out in words: one, two, three, four, five,
##then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
##
##If all the numbers from 1 to 1000 (one thousand) inclusive were written out
##in words, how many letters would be used?
##
##NOTE: Do not count spaces or hyphens.
##For example, 342 (three hundred and forty-two) contains 23 letters
##and 115 (one hundred and fifteen) contains 20 letters. The use of "and"
##when writing out numbers is in compliance with British usage.

a = ['','one','two','three','four','five','six','seven','eight','nine']
aa = ['ten','eleven','twelve','thirteen','fourteen','fifteen','sixteen','seventeen','eighteen','nineteen']
b = ['','ten','twenty','thirty','forty','fifty','sixty','seventy','eighty','ninety']
c = 'hundred'

sum = 'onethousand'
for i in range(1,1000):
    s = ''
    temp = []
    t = i
    while t/10 >= 1:
        temp.append(t-((t/10)*10))
        t = t /10
    temp.append(t)
    temp.reverse()
    if len(temp)==1:
        s += a[temp[0]]
    if len(temp)==2:
        if temp[0] == 1:
            s += aa[temp[1]]
        else:
            s += b[temp[0]]+a[temp[1]]
    if len(temp)==3:
        s += a[temp[0]]+c
        if not (temp[1]==0 and temp[2]==0):
            s += 'and'
        if temp[1] == 1:
            s += aa[temp[2]]
        else:
            s += b[temp[1]]+a[temp[2]]
    sum += s.strip()

print len(sum)
