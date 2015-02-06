package com.grantbroadwater.animal;

public class WeightRange implements Comparable<WeightRange>{
	private double low;
	private double high;
	
	public WeightRange(){
		setLow(0.0);
		setHight(0.0);
	}
	
	public WeightRange(double low, double high){
		setLow(low);
		setHight(high);
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
	public void setHight(double high){
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
	public boolean equals(Object o){
		WeightRange weight = new WeightRange();
		if(o instanceof WeightRange)
			weight = (WeightRange)o;
		else
			return false;
		
		return (this.getHigh() == weight.getHigh() && this.getLow() == weight.getLow());
	}

}
