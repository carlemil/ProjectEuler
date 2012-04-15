##In the 5 by 5 matrix below, the minimal path sum from the top left to the
##bottom right, by only moving to the right and down, is indicated in red and
##is equal to 2427.
##	
##131	673	234	103	18
##201	96	342	965	150
##630	803	746	422	111
##537	699	497	121	956
##805	732	524	37	331
##
##Find the minimal path sum, in matrix.txt (right click and 'Save Link/Target
##As...'), a 31K text file containing a 80 by 80 matrix, from the top left to
##the bottom right by only moving right and down.

def read_file(name):
    data = []
    f = open(name)
    while 1:
        line = f.readline()
        if not line: break
        temp_data = []
        for a in line.split(','):
            a = a.strip()
            temp_data.append(int(a))
        data.append(temp_data)
    f.close()
    return data


data = read_file('euler0081_matrix.txt')
for i in range(1, len(data)):
    data[i][0] += data[i-1][0]
    data[0][i] += data[0][i-1]

for i in range(1, len(data)):
    for j in range(1, len(data[i])):
        a = data[i][j] + data[i-1][j]
        b = data[i][j] + data[i][j-1]
        if a < b:
            data[i][j] = a
        else:
            data[i][j] = b
print data[79][79]








