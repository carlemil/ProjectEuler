
from tools import read_file

class Node:
    def __init__(self, nr, edges):
        self.nr = nr
        self.edges = edges
        self.mst_edges = []
        self.connected_to = []
        self.in_mst = False
        

def handle_node(nr, inl):
    utl = []
    for i in range(len(inl)):
        t = inl[i].strip()
        if not t == '-':
            utl.append([i, int(t)])
    return Node(nr, sorted(utl, key=lambda x:(x[1], x[0])))

def find(nodes_nrs, node_nr):
    for n in nodes_nrs,:
        if n == node_nr:
            return n
    return None
    
def is_loop(t):
    for n in mst:
        if n.nr == t:
            return True
    return False

data = read_file("euler0107_network.txt")

g = []
g_tot = 0
for i in range(0,len(data)):
    g.append(handle_node(i, data[i]))
for n in g:
    for e in n.edges:
        g_tot += e[1]
        n.connected_to.append(g[e[0]])
g_tot /= 2
# init tree
mst = []
mst.append(g[0])
g[0].in_mst = True
# done init

#find shortest edge among nodes in mst
while len(mst) < len(g):
    shortest_edge_node = mst[0]
    for n in mst:
        if shortest_edge_node.edges[0][1] >= n.edges[0][1]:
            shortest_edge_node = n
    if not is_loop(shortest_edge_node.connected_to[0].nr):
        # add to mst
        mst.append(shortest_edge_node.connected_to[0])
        #print "added"
        #print "%d -> %d" % (shortest_edge_node.nr, shortest_edge_node.connected_to[0].nr)
        # set the other node to in_mst = True
        shortest_edge_node.connected_to[0].in_mst = True
        # set the edge in the mst list in parrent nodes.
        shortest_edge_node.mst_edges.append(shortest_edge_node.edges[0])
    # remove edge from both nodes edges lists
    # find the possition of the edge to delete in the connected node
    delete_index = 0
    for i in range(len(shortest_edge_node.connected_to[0].edges)):
        if shortest_edge_node.connected_to[0].edges[i][0] == shortest_edge_node.nr:
            delete_index = i
 
    del(shortest_edge_node.connected_to[0].edges[delete_index])
    del(shortest_edge_node.edges[0])

    # remove the connected to connection from both nodes
    # use the same index as above for delete in connected node
    del(shortest_edge_node.connected_to[0].connected_to[delete_index])
    del(shortest_edge_node.connected_to[0])

sum_mst = 0
temp = []

for a in mst:
    temp.append( a.nr)
    for e in a.mst_edges:
        sum_mst += e[1]

temp.sort()
print g_tot-sum_mst
