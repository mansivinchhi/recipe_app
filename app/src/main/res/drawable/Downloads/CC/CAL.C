#include<stdio.h>
#include<conio.h>
#define max 30

void create(int set[]);
void Print(int set[]);
void Union(int set1[] ,int set2[],int set3[]);
void Intersection(int set1[], int set2[], int set4[]);
void Difference(int set1[], int set2[],int set5[]);
int member(int set[] ,int x);

int main()
{
	int set1[max],set2[max],set3[max];
	int x,op,*temp; // x=member, op=optional, *temp to store a values
	clrscr();
	set1[0]=set2[0]=set3[0]=0;

	printf("----set opration----");
	printf("\n 1) create two sets:");
	printf("\n 2) print the sets:");
	printf("\n 3) A U B --- A union B");
	printf("\n 4) A n B --- A intersection B");
	printf("\n 5) U - B --- compliments of set");
	printf("\n 6) exit from a program \n");

	do      // Do while start here
	{
		printf("Enter your choice");
		scanf("%d",&op);
		switch(op)
		{
			case 1:
				printf("\n create set A :");
				create(set1);
				printf("\n create set B:");
				create(set2);
				break;

			case 2:
				printf("\n print set A :");
				Print(set1);
				printf("\n print set B:\n");
				Print(set2);
				break;

			case 3:
				Union(set1,set2,set3);
				Print(set3);
				break;

			case 4:
				Intersection(set1,set2,set3);
				Print(set3);
				break;

			case 5:
				Union(set1,set2,set3);
				temp=set3;
				Difference(temp,set1,set3);
				Print(set3);
				break;
			case 6:
				exit();

			default:
				printf("\n enter valid choice :\n");
				break;
		}
	}while(op!=6);
	return 0;
}
void create(int set[])
{
	int n,i,x;
	set[0]=0;
	printf("\n number of element in a set :\n");
	scanf("%d",&n);
	printf("Enter set element = \n");

	for(i=1;i<n;i++)
		scanf("%d",&set[i]);

	set[0]=n;


}
void Print(int set[])
{
	int i,n;
	n=set[0];
	printf("\n member of the set =");
	

	for(i=1;i<n;i++)
	printf("%d",set[i]);
}
void Union(int set1[], int set2[], int set3[])
{
	int i,n;
	set3[0]=0;
	n=set1[0];

	for(i=0;i<=n;i++)
	  set3[i]=set1[i];

	n=set2[0];
	for(i=1;i<=n;i++)
	  if(!member(set3,set2[i]))
		set3[++set3[0]]=set2[i];


}
int member(int set[],int x)
{
	int i,n;
	n=set[0];
	for(i=1; i<=n; i++)
		if(x==set[i])
			return 1;
	return(0);

}
void Intersection(int set1[],int set2[],int set3[])
{

	int i,n;
	set3[0]=0;
	n=set1[0];
	for(i=1; i<=n; i++)
		if(member(set2,set1[i]))
			set3[++set3[0]]=set1[i];


}
void Difference(int set1[], int set2[], int set3[])
{
	int i,n;
	n=set1[0];
	set3[0]=0;
	for(i=1; i<=n; i++)
		if(!member(set2,set1[i]))
		set3[++set3[0]]=set1[i];

}