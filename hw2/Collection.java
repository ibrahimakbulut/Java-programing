





public  interface Collection<T>{

		class EmptyContainer extends Exception{

			EmptyContainer(){
				//do nothing
			}
			private final int error=-1;
		}

		Iterator<T> iterator();
		void add(T e);
		void addAll(Collection<T> c);
		void clear();
		boolean contains(T e);
		boolean containsAll(Collection<T> c);
		boolean isEmpty();
		void remove(T e);
		void removeAll(Collection<T> c);
		void retainAll(Collection<T> c);
		int size();

};