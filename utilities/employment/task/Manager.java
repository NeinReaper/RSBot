package employment.task;
public abstract class Manager extends Staff{
	private Staff[] container;
	public Manager(Staff[] employees){
		container = employees;
	}
	
	public void execute(){
		for(Staff employee : container) {
			if(employee != null && employee.condition()){
				employee.execute();
			}
		}
	}
	
	public abstract boolean condition();
	
}
