



public class Iterator<T>{


private T iterator_type;
private int it;
private int size;
private int current_pos;
private T [] containerr=null;

public Iterator(){
	size=0;
	it=0;
}
public Iterator(int size,int iterate,T[] container){
	this.size=size;
	it=iterate;
	containerr=container;
}

public boolean hasNext(){
	if(it<size)
		return true;
	return false;
}

public T next(){
	return containerr[(it++)];		
}

public void remove(){
	Object[] temp1=new Object[size];

	T[] temp=(T[])temp1;

	for(int i=0;i<it;++i){
		temp[i]=(T)containerr[i];
	}
	it-=1;
	size-=1;
	containerr=temp;
	}


}





