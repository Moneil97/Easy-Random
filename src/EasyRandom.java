/**
 * Convenience Class for getting random numbers
 * @author Cameron O'Neil
 * @param <Type> Byte,Short,Integer,Long,Float,Double only
 */


public class EasyRandom <Type>{

	private Type[] params;
	
	@SafeVarargs
	public EasyRandom(Type... params) {
		this.params = params;
		isValid(params);
		sort();
	}
	
	private void sort(){
		
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
	
	
	@SuppressWarnings("unchecked")
	public Type next(){

		int startPos = whichSet()*2;

		if (isByte()){
			Byte[] bytes = (Byte[]) params;
			return (Type) getIntBetween(bytes[startPos], bytes[startPos+1]);
		}
		else if (isShort()){
			Short[] shorts = (Short[]) params;
			return (Type) getIntBetween(shorts[startPos], shorts[startPos+1]);
		}
		else if (isInt()){
			Integer[] ints = (Integer[]) params;
			return (Type) getIntBetween(ints[startPos], ints[startPos+1]);
		}
		else if (isLong()){
			Long[] longs = (Long[]) params;
			return (Type) getLongBetween(longs[startPos], longs[startPos+1]);
		}
		else if (isFloat()){
			Float[] floats = (Float[]) params;
			return (Type) getDoubleBetween(floats[startPos], floats[startPos+1]);
		}
		else if (isDouble()){
			Double[] doubles = (Double[]) params;
			return (Type) getDoubleBetween(doubles[startPos], doubles[startPos+1]);
		}
		else{
			return null;
		}
	}
	
	
	public int whichSet(){
		return getIntBetween(0, params.length/2 -1);
	}
	
	public static Byte getByteBetween(byte lower, byte upper){
		if (upper < lower){
			byte temp = upper;
			lower = upper;
			upper = temp;
		}
		
		return (byte)Math.round((float)(Math.random() * (upper - lower)) + lower);
	}
	
	public static Short getShortBetween(short lower, short upper){
		if (upper < lower){
			short temp = upper;
			lower = upper;
			upper = temp;
		}
		
		return (short)Math.round((float)(Math.random() * (upper - lower)) + lower);
	}
	
	/**
	 * Gets a random number between bounds
	 * @param lower lower bound (Inclusive)
	 * @param upper upper bound (Inclusive)
	 * @return a random Integer
	 */
	public static Integer getIntBetween(int lower, int upper){
		if (upper < lower){
			int temp = upper;
			lower = upper;
			upper = temp;
		}
		
		return Math.round((float)(Math.random() * (upper - lower)) + lower);
	}
	
	public static Long getLongBetween(long lower, long upper){
		if (upper < lower){
			long temp = upper;
			lower = upper;
			upper = temp;
		}
		
		return Math.round((Math.random() * (upper - lower)) + lower);
	}
	
	public static Float getFloatBetween(float lower, float upper){
		if (upper < lower){
			float temp = upper;
			lower = upper;
			upper = temp;
		}
		
		return ((float)Math.random() * (upper - lower)) + lower;
	}
	
	public static Double getDoubleBetween(double lower, double upper){
		if (upper < lower){
			double temp = upper;
			lower = upper;
			upper = temp;
		}
		
		return (Math.random() * (upper - lower)) + lower;
	}

	public static void main(String[] args) {
		
		//Tests:
		
		say("      Bytes:      ");
		EasyRandom<Byte> bytes = new EasyRandom<Byte>(new Byte[]{5,10,  120,127,  -90,-128,  -20,-10});
		for (int i=0; i<10; i++)
			say(bytes.next());
		say("     Shorts:      ");
		EasyRandom<Short> shorts = new EasyRandom<Short>(new Short[]{12, 46,  89, 130});
		for (int i=0; i<10; i++)
			say(shorts.next());
		say("     Ints:      ");
		EasyRandom<Integer> ints = new EasyRandom<Integer>(5,10,  80,70,  120,150,  -5, -9,  561354351, 561354396);
		for (int i=0; i<10; i++)
			say(ints.next());
		say("     Longs:      ");
		EasyRandom<Long> longs = new EasyRandom<Long>(5l,10l, 70l,80l, 120l,150l, -9l,-5l, 56135435151654l,561354351516545l, 517413514354351l,-6l);
		for (int i=0; i<10; i++)
			say(longs.next());
		say("     Floats:      ");
		EasyRandom<Float> floats = new EasyRandom<Float>(0.0f, 8.6f,  186.3f,90.2f);
		for (int i=0; i<10; i++)
			say(floats.next());
		say("     Doubles:      ");
		EasyRandom<Double> dubs = new EasyRandom<Double>(1.2, 8.9,  110.9, 112.0,  132456.7,1234567.8);
		for (int i=0; i<10; i++)
			say(dubs.next());
	}

	public static void say(Object s) {
		System.out.println(s);
	}

}
