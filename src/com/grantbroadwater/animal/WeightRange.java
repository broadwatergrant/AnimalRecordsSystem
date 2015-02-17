package com.grantbroadwater.animal;

public class WeightRange implements Comparable<WeightRange>{
	private double low;
	private double high;
	
	public WeightRange(){
		setLow(0.0);
		setHigh(0.0);
	}
	
	public WeightRange(double low, double high){
		setLow(low);
		setHigh(high);
	}
	
	public WeightRange(String fromString){
		fromString.replaceAll("[", "").replaceAll("]", "").trim();
		setLow(Integer.parseInt(fromString.split(",")[0]));
		setHigh(Integer.parseInt(fromString.split(",")[1]));
	}
	
	public double getLow(){
		return this.low;
	}
	public void setLow(double low){
		this.low = low;
	}
	
	public double getHigh(){
		return this.high;
	}
	public void setHigh(double high){
		this.high = high;
	}
	
	public double getRange(){
		return (high-low);
	}
	
	@Override
	public String toString(){
		return "["+low+", "+high+"]";
	}
	
	@Override
	public int compareTo(WeightRange weight){
		return ((int)this.getRange()) - ((int)weight.getRange());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(high);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(low);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof WeightRange))
			return false;
		WeightRange other = (WeightRange) obj;
		if (Double.doubleToLongBits(high) != Double
				.doubleToLongBits(other.high))
			return false;
		if (Double.doubleToLongBits(low) != Double.doubleToLongBits(other.low))
			return false;
		return true;
	}
	
	

}
