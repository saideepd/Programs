import java.util.*;
class dijkstra
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes and starting node number:");
        int n=sc.nextInt();
        int start=sc.nextInt()-1;
        int i,j,min_val,min=0;
        int[][] cost=new int[n][n];
        System.out.println("Enter the cost adjacency matrix:(enter 65535 for infinity)");
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                cost[i][j]=sc.nextInt();
            }
        }
        System.out.println("Adjacency matrix is:\n");
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                System.out.print("\t"+cost[i][j]);
            }
            System.out.println();
        }
        int[] dist=new int[n];
        int[] path=new int[n];
        int[] visited=new int[n];
        for(i=0;i<n;i++)
        {
            visited[i]=0;//unvisited
            path[i]=0;
            if(cost[start][i]==65535)
                dist[i]=65535;
            else
            {
                dist[i]=cost[start][i];
                path[i]=start+1;
            }
        }
        visited[start]=1;
        dist[start]=0;
        System.out.print("\nPass 1:\nDistance: ");
        for(i=0;i<n;i++)
            System.out.print("\t"+dist[i]);
        System.out.print("\nPath:\t");
        for(i=0;i<n;i++)
            System.out.print("\t"+path[i]);
        System.out.print("\nVisited:");
        for(i=0;i<n;i++)
            System.out.print("\t"+visited[i]);

        for(i=1;i<n-1;i++)//n-2 passes
        {
            min_val=65536;
            for(j=0;j<n;j++)
            {
                if(visited[j]==0)
                {
                    if(dist[j]<min_val)
                    {
                        min=j;
                        min_val=dist[j];
                    }
                }
            }
            visited[min]=1;
            for(j=0;j<n;j++)
            {
                if((min_val+cost[min][j])<dist[j])
                {
                    dist[j]=min_val+cost[min][j];
                    path[j]=min+1;
                }
            }
            System.out.print("\n\nPass "+(i+1)+":\nDistance: ");
            for(j=0;j<n;j++)
                System.out.print("\t"+dist[j]);
            System.out.print("\nPath:\t");
            for(j=0;j<n;j++)
                System.out.print("\t"+path[j]);
            System.out.print("\nVisited:");
            for(j=0;j<n;j++)
                System.out.print("\t"+visited[j]);
        }
        for(i=0;i<n;i++)
        {
            if(i!=start)
            {
                System.out.print("\n\nPath from "+(start+1)+" --> "+(i+1)+" : "+(start+1));
                j=i;
                while(path[j]!=start+1)
                {
                    System.out.print(" --> "+(path[j]));
                    j=path[j]-1;
                }
                System.out.print(" --> "+(i+1)+" and distance = "+dist[i]);
            }
        }
	System.out.println();
    }

}

/*
OUTPUT:
Enter the number of nodes and starting node number:
3 1
Enter the cost adjacency matrix:(enter 65535 for infinity)
0 2 7
2 0 1
7 1 0
Adjacency matrix is:

	0	2	7
	2	0	1
	7	1	0

Pass 1:
Distance: 	0	2	7
Path:		1	1	1
Visited:	1	0	0

Pass 2:
Distance: 	0	2	3
Path:		1	1	2
Visited:	1	1	0

Path from 1 --> 2 : 1 --> 2 and distance = 2

Path from 1 --> 3 : 1 --> 2 --> 3 and distance = 3
*/
