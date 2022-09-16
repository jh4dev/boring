package berich.model;

public class NumberSet {
	
	private Integer number;
	private Integer weight;
	
	public NumberSet(int n, int w) {
		
		this.number = n;
		this.weight = w;
	}
	
	public void subWeight(int subWeight) {
		this.weight -= subWeight;
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "NumberSet [number=" + number + ", weight=" + weight + "]";
	}
	
	
}
