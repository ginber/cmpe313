package systems;

public interface Subject {
	
	public void register(Observer observer);
	
	public void remove(Observer observer);
	
	public void notifyObserver();
	
	public Object getUpdate();

}
