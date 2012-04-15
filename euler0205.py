##Peter has nine four-sided (pyramidal) dice, each with faces
##numbered 1, 2, 3, 4.
##Colin has six six-sided (cubic) dice, each with faces numbered
##1, 2, 3, 4, 5, 6.
##
##Peter and Colin roll their dice and compare totals: the highest
##total wins. The result is a draw if the totals are equal.
##
##What is the probability that Pyramidal Pete beats Cubic Colin?
##Give your answer rounded to seven decimal places in the
##form 0.abcdefg
import math, random
colin = [0] * (6*6+1)

for a in range(1,7):
    for b in range(1,7):
        for c in range(1,7):
            for d in range(1,7):
                for e in range(1,7):
                    for f in range(1,7):
                        colin[a+b+c+d+e+f] += 1

print colin
peter = [0] * (6*6+1)
for a in range(1,5):
    for b in range(1,5):
        for c in range(1,5):
            for d in range(1,5):
                for e in range(1,5):
                    for f in range(1,5):
                        for g in range(1,5):
                            for h in range(1,5):
                                for i in range(1,5):
                                    peter[a+b+c+d+e+f+g+h+i] += 1


print peter
sc = sum(colin) * 1.0
sp = sum(peter) * 1.0
for i in range(0,len(colin)):
    colin[i] = colin[i] / sc
for i in range(0,len(peter)):
    peter[i] = peter[i] / sp
    
print colin
print peter
