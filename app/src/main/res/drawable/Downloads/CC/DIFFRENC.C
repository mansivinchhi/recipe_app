/* diffrence and simetric diffrance between two sets. */

#define MAX 30
#include<stdio.h>
#include<conio.h>
void Create(int set[]);
void Print(int set[]);
void Difference(int set1[], int set2[], int set3[]);
void Symmdiff(int set1[], int set2[], int set3[]);
int member(int set[],int x);

void main()
 {
  int set1[MAX],set2[MAX],set3[MAX];
  int x,op;
  clrscr();
  flushall();
  set1[0]=set2[0]=set3[0]=0;
  do
  {
  printf("\n 1) create \n 2)print \n3)Difference \n4)Symmetrec Difference \n 5)quite");
  printf("\n enter your choice");
  scanf("%d",&op);
  switch(op)
	{
		case 1: printf("creating the first set A:");
			Create(set1);
			printf("creating seconed set B :");
			Create(set2);
			break;
		case 2: printf("print the first element of first element A:");
			Print(set1);
			printf("print the second element of second element B:");
			Print(set2);
			break;
		case 3:Difference(set1,set2,set3);
		       Print(set3);
		       break;
		case 4:Symmdiff(set1,set2,set3);
		       Print(set3);
		       break;
	}
		printf("press any key to continew...");
		getch();
		}while(op!=5);

}
void Create(int set[])
{
	int n,i,x;
	set[0]=0;
	printf("\n  No. of the elements in the set is:");
	scanf("%d",&n);
	printf("\n enter set elem,ents are =");
	for(i=1;i<=n;i++)
		scanf("%d",&set[i]);
	set[0]=n;
}
void Print(int set[])
{
	int i,n;
	n=set[0];
	printf("\n member of the set are:");
	for(i=1;i<=n;i++)
		printf("%d",set[i]);
}
int member(int set[],int x)
{
	int i,n;
	n=set[0];
	for(i=1;i<=n;i++)
		if(x==set[i])
		return(1);
	return(0);

}
void Difference(int set1[],int set2[],int set3[])
{
	int i,n;
	n=set1[0];
	set3[0]=0;
	for(i=1;i<=n;i++)
		if(!member(set2,set1[i]))
		set3[++set3[0]]=set1[i];

}
void Symmdiff(int set1[],int set2[],int set3[])
{
	int i,n;
	n=set1[0];
	set3[0]=0;

	for(i=1;i<=n;i++)
		if(!member(set2,set1[i]))
		set3[++set3[0]]=set1[i];

		n=set2[0];
		for(i=1;i<=n;i++)
			if(!member(set1,set2[i]))
				set3[++set3[0]]=set2[i];


}


