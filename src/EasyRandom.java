import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Random;


public class EasyRandom <Type>{

	enum DataType{
		
		bytes,shorts,ints,longs,floats,doubles;
		
	}
	
	DataType type;
	Type[] params;
	
	@SafeVarargs
	public EasyRandom(Type... params) {
		this.params = params;
		isValid(params);
		sort();
	}
	
	private boolean hasDecimals(){
		return (isFloat() || isDouble());
	}
	
	private void sort(){
		
		say(Arrays.toString(params));
		
		if (isByte()){
			Byte[] array = (Byte[]) params;
			for (int i=0; i < params.length; i+=2)
				if (array[i] > array[i+1])
					swap(params, i, i+1);
		}
		else if (isShort()){
			Short[] array = (Short[]) params;
			for (int i=0; i < params.length; i+=2)
				if (array[i] > array[i+1])
					swap(params, i, i+1);
		}
		else if (isInt()){
			Integer[] array = (Integer[]) params;
			for (int i=0; i < params.length; i+=2)
				if (array[i] > array[i+1])
					swap(params, i, i+1);
		}
		else if (isLong()){
			Long[] array = (Long[]) params;
			for (int i=0; i < params.length; i+=2)
				if (array[i] > array[i+1])
					swap(params, i, i+1);
		}
		else if (isFloat()){
			Float[] array = (Float[]) params;
			for (int i=0; i < params.length; i+=2)
				if (array[i] > array[i+1])
					swap(params, i, i+1);
		}
		else if (isDouble()){
			Double[] array = (Double[]) params;
			for (int i=0; i < params.length; i+=2)
				if (array[i] > array[i+1])
					swap(params, i, i+1);
		}
		
		say(Arrays.toString(params));
		
	}
	
	private void swap(Type[] array, int first, int second){
		Type temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	
	private boolean isByte(){
		return params instanceof Byte[];
	}
	
	private boolean isShort(){
		return params instanceof Short[];
	}
	
	private boolean isInt(){
		return params instanceof Integer[];
	}
	
	private boolean isLong(){
		return params instanceof Long[];
	}
	
	private boolean isFloat(){
		return params instanceof Float[];
	}
	
	private boolean isDouble(){
		return params instanceof Double[];
	}
	
	@SuppressWarnings("unchecked")
	private boolean isValid(Type... params){
		if (params.length %2 != 0)
			throw new RuntimeException("invalid amount of parameters");
		
		if (isByte() || isShort() || isInt() || isLong() || isFloat() || isDouble())
			return true;
		else
			throw new RuntimeException("invalid parameters. \nSupports: Byte,Short,Integer,Long,Float,Double");
	}
	
	Random rand = new Random();
	
	
	@SuppressWarnings("unchecked")
	public Type next(){

		int start = whichSet()*2;
		
		if (isInt()){
			Integer[] ints = (Integer[]) params;
			//return (Type)(Integer)(ints[start] + rand.nextInt(ints[start+1] - ints[start]));
			return (Type)(Integer)Math.round((float)(Math.random() * (ints[start+1] - ints[start])) + ints[start]);
		}
		else if (isLong()){
			Long[] longs = (Long[]) params;
			return (Type)(Long)Math.round((Math.random() * (longs[start+1] - longs[start])) + longs[start]);
		}
		else{
			return null;
		}
		
		//int r = (int) (Math.random() * (upper - lower)) + lower;
	}
	
	
	
	public int whichSet(){
		return getIntBetween(0, params.length/2);
	}
	
	
	private int getIntBetween(int start, int end){
		if (end < start){
			int temp = end;
			start = end;
			end = temp;
		}
		
		return start + rand.nextInt(end-start);
	}

	public static void main(String[] args) {
		//EasyRandom<Long> rand = new EasyRandom<Long>(5l,10l, 70l,80l, 120l,150l, -9l, -5l, 56135435151654l, 561354351516545l);
		EasyRandom<Integer> rand = new EasyRandom<Integer>(5,10, 80,70, 120,150, -5, -9, 561354351, 561354396);
		
//		for (int i=0; i<20; i++)
//			say(rand.whichSet());
		for (int i=0; i<20; i++)
			say(rand.next());
	}

	public static void say(Object s) {
		System.out.println(s);
	}

}
