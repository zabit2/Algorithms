public class TrapRain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] blockArray = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(findRainBlocks(blockArray));
	}
	
	public static int findRainBlocks(int[] blockArray)
	{
		int result=0;
		
		if(blockArray.length<=2 || blockArray==null)
			return result;
		int[] maxLeft = new int[blockArray.length];
		int[] maxRight = new int[blockArray.length];
		int max=blockArray[0];
		maxLeft[0]=max;
		for(int i=1;i<maxLeft.length;++i)
		{
			if(blockArray[i]<max)
				maxLeft[i]=max;
			else
			{
				maxLeft[i]=blockArray[i];
				max=blockArray[i];
			}
		}
		max=blockArray[blockArray.length-1];
		maxRight[blockArray.length-1]=max;
		for(int j=blockArray.length-2;j>=0;--j)
		{
			if(blockArray[j]<max)
				maxRight[j]=max;
			else
			{
				maxRight[j]=blockArray[j];
				max=blockArray[j];
			}
				
		}
		
		for(int i=0;i<blockArray.length;++i)
		{
			result+=Math.min(maxLeft[i],maxRight[i])-blockArray[i];
		}
		return result;
	}

}
