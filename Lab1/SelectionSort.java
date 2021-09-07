import java.util.Date;

public class SelectionSort implements SortStrategy {
	long msecsTime=0;
	@Override
	public long[] sort(long[] numbers) {
		// TODO Auto-generated method stub
		for(int i=0;i<numbers.length;i++)
		{
			int min=i;
			for(int j=i+1;j<numbers.length;j++)
			{
				if(numbers[j]<numbers[min]) min=j;
				{
					long temp=numbers[i];
					numbers[i]=numbers[min];
					numbers[min]=temp;
				}
			}
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
		return "SelectionSort";
	}

}