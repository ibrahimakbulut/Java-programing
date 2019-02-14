
public class driverFile{


public static void main(String[] args){

	HashSet<Integer> inner_collect1= new HashSet<Integer>();
	HashSet<Integer> collect1= new HashSet<Integer>();	

	Iterator<Integer> it;

for(int i=0;i<20;++i){
	inner_collect1.add(i);
}

for(int i=150;i<160;++i){
	collect1.add(i*2);
}
collect1.add(5);
collect1.add(8);
collect1.add(13);
collect1.add(30);

collect1.addAll(inner_collect1);

it=collect1.iterator();
while(it.hasNext()){
	System.out.println(it.next());
}


if(collect1.contains(30))
	System.out.println("collect1 contain 30");

if(collect1.containsAll(inner_collect1))
	System.out.println("collect1 contain all of them inner_collect1");

collect1.retainAll(inner_collect1);

collect1.removeAll(inner_collect1);

collect1.add(10);
collect1.remove(10);

System.out.println(collect1.size());

collect1.addAll(inner_collect1);
collect1.clear();

System.out.println(collect1.size());

it=collect1.iterator();
while(it.hasNext()){
	System.out.println(it.next());
}

if(collect1.containsAll(inner_collect1))
	System.out.println("collect1 contain all of them inner_collect1 again");

if(!collect1.isEmpty())
	System.out.println("collect1 is not empty");
else
	System.out.println("collect1 is empty");

System.out.println("-------------------------------------------------------");

Iterator<String> it2;

HashSet<String> collect2=new HashSet<String>();

HashSet<String> inner_collect2=new HashSet<String>();

for(int i=0;i<20;++i){
	String s="number"+((Integer)i).toString();
	inner_collect2.add(s);
}

for(int i=150;i<160;++i){
	String s="number"+String.valueOf(i*2);;
	collect2.add(s);
}
String s1="number"+String.valueOf(5);;
collect2.add(s1);
s1="number"+String.valueOf(8);
collect2.add(s1);
s1="number"+String.valueOf(13);
collect2.add(s1);
s1="number"+String.valueOf(30);
collect2.add(s1);


collect2.addAll(inner_collect2);

it2=collect2.iterator();
while(it2.hasNext()){
	System.out.println(it2.next());
}


if(collect2.contains("number30"))
	System.out.println("collect2 contain number30");

if(collect2.containsAll(inner_collect2))
	System.out.println("collect2 contain all of them inner_collect2");

collect2.retainAll(inner_collect2);

collect2.removeAll(inner_collect2);

s1="number"+String.valueOf(600);
collect2.add(s1);
collect2.remove(s1);

System.out.println(collect2.size());

collect2.addAll(inner_collect2);
collect2.clear();

System.out.println(collect2.size());

it2=collect2.iterator();
while(it2.hasNext()){
	System.out.println(it2.next());
}

if(collect2.containsAll(inner_collect2))
	System.out.println("collect2 contain all of them inner_collect2 again");

if(!collect2.isEmpty())
	System.out.println("collect2 is not empty");
else
	System.out.println("collect2 is empty");


System.out.println("--------------------------------------------------------------");


	ArrayList<Integer> inner_collect3= new ArrayList<Integer>();
	ArrayList<Integer> collect3= new ArrayList<Integer>();	

	Iterator<Integer> it3;

for(int i=0;i<20;++i){
	inner_collect3.add(i);
}

for(int i=150;i<160;++i){
	collect3.add(i*2);
}
collect3.add(5);
collect3.add(8);
collect3.add(13);
collect3.add(30);

collect3.addAll(inner_collect3);

it3=collect3.iterator();
while(it3.hasNext()){
	System.out.println(it3.next());
}


if(collect3.contains(30))
	System.out.println("collect3 contain 30");

if(collect3.containsAll(inner_collect3))
	System.out.println("collect3 contain all of them inner_collect3");

collect3.retainAll(inner_collect3);

collect3.removeAll(inner_collect3);

collect3.add(10);
collect3.remove(10);

System.out.println(collect3.size());

collect3.addAll(inner_collect3);
collect3.clear();

System.out.println(collect3.size());

it3=collect3.iterator();
while(it3.hasNext()){
	System.out.println(it3.next());
}

if(collect3.containsAll(inner_collect3))
	System.out.println("collect3 contain all of them inner_collect3 again");

if(!collect3.isEmpty())
	System.out.println("collect3 is not empty");
else
	System.out.println("collect3 is empty");



System.out.println("-----------------------------------------------------------");


Iterator<String> it4;

ArrayList<String> collect4=new ArrayList<String>();

ArrayList<String> inner_collect4=new ArrayList<String>();

for(int i=0;i<20;++i){
	String s="number"+((Integer)i).toString();
	inner_collect4.add(s);
}

for(int i=150;i<160;++i){
	String s="number"+String.valueOf(i*2);;
	collect4.add(s);
}
String s2="number"+String.valueOf(5);;
collect4.add(s2);
s2="number"+String.valueOf(8);
collect4.add(s2);
s2="number"+String.valueOf(13);
collect4.add(s2);
s2="number"+String.valueOf(30);
collect4.add(s2);

collect4.addAll(inner_collect4);

it4=collect4.iterator();
while(it4.hasNext()){
	System.out.println(it4.next());
}


if(collect4.contains("number30"))
	System.out.println("collect4 contain number30");

if(collect4.containsAll(inner_collect4))
	System.out.println("collect4 contain all of them inner_collect4");

collect4.retainAll(inner_collect4);

collect4.removeAll(inner_collect4);

s2="number"+String.valueOf(600);
collect4.add(s2);
collect4.remove(s2);

System.out.println(collect4.size());

collect4.addAll(inner_collect4);
collect4.clear();

System.out.println(collect4.size());

it4=collect4.iterator();
while(it4.hasNext()){
	System.out.println(it4.next());
}

if(collect4.containsAll(inner_collect4))
	System.out.println("collect4 contain all of them inner_collect4 again");

if(!collect4.isEmpty())
	System.out.println("collect4 is not empty");
else
	System.out.println("collect4 is empty");


System.out.println("-------------------------------------------------------------");


LinkedList<Integer> inner_collect5= new LinkedList<Integer>();
LinkedList<Integer> collect5= new LinkedList<Integer>();	

Iterator<Integer> it5;

for(int i=0;i<20;++i){
	inner_collect5.add(i);
}

for(int i=150;i<160;++i){
	collect5.add(i*2);
}
collect5.offer(5);
collect5.offer(8);
collect5.add(13);
collect5.add(30);

collect5.addAll(inner_collect5);

it5=collect5.iterator();
while(it5.hasNext()){
	System.out.println(it5.next());
}


if(collect5.contains(30))
	System.out.println("collect5 contain 30");

if(collect5.containsAll(inner_collect5))
	System.out.println("collect5 contain all of them inner_collect5");

collect5.retainAll(inner_collect5);

collect5.removeAll(inner_collect5);

collect5.add(10);
collect5.remove(10);

System.out.println(collect5.size());

collect5.addAll(inner_collect5);
collect5.clear();

collect5.offer(243);
System.out.println(collect5.element());

try{
System.out.println(collect5.poll());  //this is return head of queue and remove it from array.
}

catch(LinkedList.EmptyContainer i){
	System.out.println("empty container exception catched in main");
}
System.out.println(collect5.size());


try{
System.out.println(collect5.poll());}  //this try block throw an EmptyContainer exception because collect5 is empty it can not retrieve or remove any elemts

catch(LinkedList.EmptyContainer i){
	System.out.println("empty container exception catched in main");
}




it5=collect5.iterator();
while(it5.hasNext()){
	System.out.println(it5.next());
}

if(collect5.containsAll(inner_collect5))
	System.out.println("collect5 contain all of them inner_collect5 again");

if(!collect5.isEmpty())
	System.out.println("collect5 is not empty");
else
	System.out.println("collect5 is empty");



System.out.println("-------------------------------------------------------------------------");

Iterator<String> it6;

LinkedList<String> collect6=new LinkedList<String>();

LinkedList<String> inner_collect6=new LinkedList<String>();

for(int i=0;i<20;++i){
	String s="number"+((Integer)i).toString();
	inner_collect6.add(s);
}

for(int i=150;i<160;++i){
	String s="number"+String.valueOf(i*2);;
	collect6.add(s);
}
String s3="number"+String.valueOf(5);;
collect6.offer(s3);
s3="number"+String.valueOf(8);
collect6.offer(s3);
s3="number"+String.valueOf(13);
collect6.add(s3);
s3="number"+String.valueOf(30);
collect6.add(s3);

collect6.addAll(inner_collect6);

it6=collect6.iterator();
while(it6.hasNext()){
	System.out.println(it6.next());
}


if(collect6.contains("number30"))
	System.out.println("collect6 contain number30");

if(collect6.containsAll(inner_collect6))
	System.out.println("collect6 contain all of them inner_collect6");

collect6.retainAll(inner_collect6);
collect6.removeAll(inner_collect6);

s3="number"+String.valueOf(600);
collect6.add(s3);
collect6.remove(s3);

System.out.println(collect6.size());

collect6.addAll(inner_collect6);
collect6.clear();

collect6.offer("243");
System.out.println(collect6.element());

try{
System.out.println(collect6.poll());  //this is return head of queue and remove it from array.
}

catch(LinkedList.EmptyContainer i){
	System.out.println("empty container exception catched in main");
}
System.out.println(collect6.size());


try{
System.out.println(collect6.poll());}  //this try block throw an EmptyContainer exception because collect5 is empty it can not retrieve or remove any elemts

catch(LinkedList.EmptyContainer i){
	System.out.println("empty container exception catched in main");
}



System.out.println(collect6.size());

it6=collect6.iterator();
while(it6.hasNext()){
	System.out.println(it6.next());
}

if(collect6.containsAll(inner_collect6))
	System.out.println("collect6 contain all of them inner_collect6 again");

if(!collect6.isEmpty())
	System.out.println("collect6 is not empty");
else
	System.out.println("collect6 is empty");



}
}