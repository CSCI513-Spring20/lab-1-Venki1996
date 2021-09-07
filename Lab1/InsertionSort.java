import java.util.Date;

public class InsertionSort implements SortStrategy {
	long msecsTime=0;
	@Override
	public long[] sort(long[] numbers) {
		// TODO Auto-generated method stub
		for(int i=1;i<numbers.length;i++)
		{
			long index=numbers[i];
			int j=i;
			while(j>0 && numbers[j-1]>index)
			{
				numbers[j]=numbers[j-1];
				j--;
			}
			numbers[j]=index;
		}
		return numbers;
	}

	@Override
	public long getSortTime() {
		// TODO Auto-generated method stub
		long currentTime=(new Date()).getTime();
		long toMsecs=(currentTime-msecsTime);
		return toMsecs;
	}

	@Override
	public void resetTimer() {
		// TODO Auto-generated method stub
		msecsTime=(new Date()).getTime();

	}

	@Override
	public String strategyName() {
		// TODO Auto-generated method stub
		return "InsertionSort";
	}

}
