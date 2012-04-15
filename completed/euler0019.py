##You are given the following information, but you may prefer to do some
##research for yourself.
##
##    * 1 Jan 1900 was a Monday.
##    * Thirty days has September,
##      April, June and November.
##      All the rest have thirty-one,
##      Saving February alone,
##      Which has twenty-eight, rain or shine.
##      And on leap years, twenty-nine.
##    * A leap year occurs on any year evenly divisible by 4, but not on a
##    century unless it is divisible by 400.
##
##How many Sundays fell on the first of the month during the twentieth century
##(1 Jan 1901 to 31 Dec 2000)?

import time
import datetime

m=0
y=1900
t = 0
for y in range(1901, 2001):
    for m in range(1,13):
        d = datetime.datetime(y, m, 01, 0, 0, 0)
        if d.strftime("%w") == "0":
            t += 1
print t
