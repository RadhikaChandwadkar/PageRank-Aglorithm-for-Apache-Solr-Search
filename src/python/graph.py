
from decimal import *
getcontext().prec = 6
import networkx as nx
def createGraph():
    dir= "f:/crawl_data"
    G=nx.read_edgelist("edgeList.txt",create_using=nx.DiGraph())    
    pr = nx.pagerank(G,alpha=0.85, personalization=None, max_iter=30, tol=1e-06, nstart=None, weight='weight',dangling=None)
    fh = open("external_pageRankFile","w")
    fh.truncate()
    
    for k,v in pr.items():
       
        fh.write(dir+str(k)+"="+str(v)+"\n")
    fh.close()
    
    
if __name__ == '__main__':
    createGraph()