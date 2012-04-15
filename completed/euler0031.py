# In England the currency is made up of pound, P, and pence, p, and there are eight coins in general circulation:
#
# 1p, 2p, 5p, 10p, 20p, 50p, P1 (100p) and P2 (200p).
# It is possible to make P2 in the following way:
#
# 1*P1 + 1*50p + 2*20p + 1*5p + 1*2p + 3*1p
# How many different ways can P2 be made using any number of coins?)

total_sum = 200
coins = [200,100,50,20,10,5,2,1]

def rec(current_coin, current_sum):
    if (coins[current_coin] == 1):
        return 1
    perms = 0
    loops = (total_sum - current_sum ) / coins[current_coin]
    i = 0
    while (i <= loops):
        if (current_sum + i * coins[current_coin] <= total_sum):
            perms += rec(current_coin + 1, current_sum + i * coins[current_coin])
        i += 1
    return perms
    
print rec(0, 0)

