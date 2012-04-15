##The number, 1406357289, is a 0 to 9 pandigital number because it is
##made up of each of the digits 0 to 9 in some order, but it also has
##a rather interesting sub-string divisibility property.
##
##Let d_(1) be the 1^(st) digit, d_(2) be the 2^(nd) digit, and so on.
##In this way, we note the following:
##
##    * d_(2)d_(3)d_(4)=406 is divisible by 2
##    * d_(3)d_(4)d_(5)=063 is divisible by 3
##    * d_(4)d_(5)d_(6)=635 is divisible by 5
##    * d_(5)d_(6)d_(7)=357 is divisible by 7
##    * d_(6)d_(7)d_(8)=572 is divisible by 11
##    * d_(7)d_(8)d_(9)=728 is divisible by 13
##    * d_(8)d_(9)d_(10)=289 is divisible by 17
##
##Find the sum of all 0 to 9 pandigital numbers with this property.

fl = [0,1,2,3,4,5,6,7,8,9]

l = len(fl)
pands = []

def permut(list, string):
    if string != "":
        if len(string) == l:
            pands.append(string)
    for i in range(0, len(list)):
        tmp = list[i]
        del list[i]
        string = string + str(tmp)
        permut(list, string)
        list.insert(i, tmp)
        string = string[:-1]

def div_prop(s):
    if int(s[1:4])%2==0:
        if int(s[2:5])%3==0:
            if int(s[3:6])%5==0:
                if int(s[4:7])%7==0:
                    if int(s[5:8])%11==0:
                        if int(s[6:9])%13==0:
                            if int(s[7:10])%17==0:
                                return int(s)
    return 0
permut(fl, "")
pands.sort()

summa = 0
for p in pands:
    summa += div_prop(p)
print summa


