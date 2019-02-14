

public  interface Queue<T> extends Collection<T> {


	void add(T e);
	T element();
	void offer(T e);
	T poll()throws EmptyContainer;


}