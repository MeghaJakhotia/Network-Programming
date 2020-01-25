#include <stdio.h>
struct node{
	unsigned dist[20];
	unsigned from[20];
}rt[10];
void main()
{
	int n,i,j,k,cost[20][20];
	clrscr();
	printf("enter nodes");
	scanf("%d",&n);
	printf("enter cost mat");
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		{
			scanf("%d",&cost[i][j]);
			rt[i].dist[j]=cost[i][j];
			rt[i].from[j]=i;
		}

	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			for(k=0;k<n;k++)
			{
				if(rt[i].dist[j]>rt[i].dist[k]+rt[k].dist[j])
				{
				     rt[i].dist[j]=rt[i].dist[k]+rt[k].dist[j];
				     rt[i].from[j]=k;
				}
			}
	for(i=0;i<n;i++)
	{
		printf("Router %d \n",i+1);
		for(j=0;j<n;j++)
		{
			printf("\nDistance of %d is %d via %d",j+1,rt[i].dist[j],rt[i].from[j]+1);
		}
	}
	getch();
}
