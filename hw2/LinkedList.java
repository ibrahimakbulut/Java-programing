

public  class LinkedList<T> implements Set<T>,Queue<T> {

/**
* <h1>LinkedList<T></h1>
* This class implements List and Queue interfaces.This is a container.
* <p>
* <b>Note:</b> In this class some dangerous techniques were used.Because of that compiler will give an warning dangerous thinks!
* there is no problem in the work of the program.
*
* @author Ibrahim Akbulut
* @version 1.0
* @since   17-01-2019
*/

	public LinkedList(){
		used=0;
		capacity=5;
		Object[] temp1=new Object[5];
		T[] temp=(T[])temp1;
		container=temp;
	}

   /**
   * This method is used to return an iterator over the collection
   * @return Iterator< T >
   */
	@Override
	public Iterator<T> iterator(){

			return new Iterator<T>(used,0,container);
		}
   /**
   * This method is used to ensure that this collection contains the specified element
   * @param  e
   */
	@Override
	public void add(T e){
			if(container==null){
					Object[] temp1=new Object[capacity];
					T[] temp=(T[])temp1;
					container=temp;				
			}
			if(used>=capacity){
				Object[] temp1=new Object[capacity+10];
				T[] temp=(T[])temp1;
				for(int i=0;i<used;++i){
					temp[i]=container[i];
				}
				temp[used]=e;
				used+=1;
				capacity+=10;
				container=temp;
			}
			else{
			container[used]=e;
			used+=1;
			}
	}
   /**
   * This method is used to add all of the elements in the specified collection to this
   * collection
   * @param  c
   */
	@Override
	public void addAll(Collection<T> c){
				if(container==null){
					Object[] temp1=new Object[capacity];
					T[] temp=(T[])temp1;
					container=temp;				
				}
				for(int i=0;i<((LinkedList<T>)c).used;++i){

					if(used>=capacity){
						Object[] temp1=new Object[capacity+10];
						T[] temp=(T[])temp1;
						for(int k=0;k<used;++k){
							temp[k]=container[k];
						}
						temp[used]=((LinkedList<T>)c).container[i];
						used+=1;
						capacity+=10;
						container=temp;
					}
					else{
					container[used]=((LinkedList<T>)c).container[i];
					used+=1;
					}
			}
		}
   /**
   * This method is used to remove all of the elements from this collection
   */
	@Override
	public	void clear(){
		container=null;
		used=0;
	}
	/**
   * This method is used to returns true if this collection contains the specified element.
   * @param  e
   * @return boolean
   */
	@Override
	public boolean contains(T e){
			for(int i=0;i<used;++i){
			if(container[i].equals(e))
				return true;
			}
			return false;			
	}
	/**
   * This method is used to return true if this collection contains all of the elements in the
   * specified collection.
   * @param  c
   * @return boolean
   */
	@Override
	public	boolean containsAll(Collection<T> c){
				for(int i=0;i<((LinkedList<T>)c).used;++i){
					int all_in=0;
					for(int j=0;j<used;++j){
						if(((LinkedList<T>)c).container[i].equals(container[j]))
							all_in=1;
					}
					if(all_in==0)
						return false;
				}
				return true;
	}
	/**
   * This method is used to Returns true if this collection contains no elements.
   * @return boolean
   */
	@Override
	public boolean isEmpty(){
			if(used==0)
				return true;
			else
				return false;
	}
	/**
   * This method is used to removes a single instance of the specified element from this collection, if it is present
   * @param  e
   */
	@Override
	public void remove(T e){
			Object[] temp1=new Object[capacity];
			T[] temp=(T[])temp1;
			for(int i=0,j=0;i<used;++i){
				if(!(container[i].equals(e))){
					temp[j]=container[i];
					++j;
				}

			}
			container=temp;
			used-=1;
	}
	/**
   * This method is used to removes all of this collection's elements that are also contained in the specified collection
   * @param  c
   */
	@Override
	public void removeAll(Collection<T> c){

				Object[] temp1=new Object[capacity];
				T[] temp=(T[])temp1;
				int temp_count=0;
				for(int i=0;i<((LinkedList<T>)c).used;++i){
					for(int j=0;j<used;++j){
						if(!(((LinkedList<T>)c).container[i].equals(container[j]))){
							temp[temp_count]=container[j];
							used-=1;
							temp_count+=1;
						}
					}
				}
				container=temp;

		}
	/**
   * This method is used to retains only the elements in this collection that are contained in the specified collection
   * @param  c
   */
	@Override
	public void retainAll(Collection<T> c){
				Object[] temp1=new Object[capacity];
				T[] temp=(T[])temp1;
				int temp_count=0;
				for(int j=0;j<used;++j){
					int find_in=0;
					for(int i=0;i<((LinkedList<T>)c).used;++i){
						if(((LinkedList<T>)c).container[i].equals(container[j]))
							find_in=1;
					}
					if(find_in==1){
						temp[temp_count]=container[j];
						used-=1;
					}
				}
				container=temp;	


		}
	/**
   * This method is used to return the number of elements in this collection.
   * @return int
   */	
	@Override
	public int size(){
			return used;
		}
	/**
   * This method is used to retrieves, but does not remove, the head of this queue.
   * @return T
   */	
	@Override        
	public	T element(){
		return container[0];
	}
	/**
   * This method is used to inserts the specified element into this queue
   * @param e
   */	
	@Override
	public	void offer(T e){
			if(container==null){
					Object[] temp1=new Object[capacity];
					T[] temp=(T[])temp1;
					container=temp;				
			}
			if(used>=capacity){
				Object[] temp1=new Object[capacity+10];
				T[] temp=(T[])temp1;
				for(int i=0;i<used;++i){
					temp[i]=container[i];
				}
				temp[used]=e;
				used+=1;
				capacity+=10;
				container=temp;
			}
			else{
			container[used]=e;
			used+=1;
			}
	}
	/**
   * This method is used to retrieves and removes the head of this queue, or throws if this queue is empty.
   * @return T
   * @exception EmptyContainer on empty container
   */	
	@Override
	public  T poll()throws EmptyContainer{

	if(used==0)
		throw new EmptyContainer();	

	Object[] temp1=new Object[capacity];
	T[] temp=(T[])temp1;

	T temp2=container[0];

	for(int i=1;i<used;++i){
		temp[i]=container[i];
	}
	container=temp;
	used-=1;
	return temp2;
	}	

	private T[] container=null;
	private int capacity;
	private	int used;

}
