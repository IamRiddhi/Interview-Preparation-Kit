void spiralPrint(int input[][1000], int row, int col){
	int rowStart = 0;
  	int rowEnd = row - 1;
  	int colStart = 0;
  	int colEnd = col - 1;
  	int count = row * col;
  	while(count)
    {
    	for(int j=colStart;count && j<=colEnd;j++)
        {
          cout<<input[rowStart][j]<<" ";
          count --;
        }
      	rowStart ++;
      	for(int i=rowStart;count && i<=rowEnd;i++)
        {
          cout<<input[i][colEnd]<<" ";
          count--;
        }
      	colEnd--;
      	for(int j=colEnd;count && j>=colStart;j--)
        {
          cout<<input[rowEnd][j]<<" ";
          count--;
        }
      	rowEnd --;
      	for(int i=rowEnd;count && i>=rowStart;i--)
        {
          cout<<input[i][colStart]<<" ";
          count--;
        }
      	colStart ++;
    }
}