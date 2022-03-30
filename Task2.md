# Task-2-Data-Structures
## Task Information and Instructions 

There are four files in this task: ArrayExample, ComicBooks, HashMapExercise, and ListExample.
It shows basic functions on how to add more values, and how to create them. 

The purpose of this task is to show how data structures are used.

Two coding tasks have been given: HashMapExercise, and ComicBook. Look at HashMapExercise first and have a go at doing the tasks provided on the comments. Comic book uses a hash map to store 'quality' with a 'price'. It also uses an enumeration which are like constants.

Remember to save your work, and push your changes. Some feedback can be given but don't be alarmed if you see a lot of red text before you have started, as it is just checking that the tasks have yet to be completed.

### Keywords
Match the keywords with the definitions: (copy and paste)
-Data Structure
-Array
-element
-Storage
-List
-Map

=A set of data values of the same type, stored in a sequence in a computer program.
= contains values on the basis of key, i.e. key and value pair. Each key and value pair is known as an entry. Contains unique keys.
=The way that data is stored in a database or program.
=An individual component of an array.
= found in the java.util package and inherits the Collection interface.
  Has the facility to maintain the ordered collection. It contains the index-based methods to insert, update, delete and search the elements.
  It can have the duplicate elements also. We can also store the null elements in the list.

### Predict the output

'''java
int[] myNum = {10, 20, 30, 40};
System.out.println(myNum[1]);
'''
- Guess what the output is from the code above:
- Actual output:  

'''java
int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} }; //2D array
int x = myNumbers[1][2];
System.out.println(x);
'''
- Guess what the output is from the code above:
- Actual output:  

'''java
        ArrayList<Integer> myNum = new ArrayList<>();
		myNum.add(20);
		myNum.add(10);
		myNum.add(40);
		myNum.add(30);
		Collections.sort(myNum);
		System.out.println(myNum.get(3));
'''
- Guess what the output is from the code above:
- Actual output:  [See answer here](https://learn.onlinegdb.com/JU4zjIoMc)<br/>





## Code to save your work
 - Remember to save your work. Copy and Paste the code below. You can see your progress on the links as well.
```shell 
mvn test && git add . && git commit -m "Saving" && git push
```
## Hash Map Task status:<br/>
[See report on Hash Map Task](HashMapReport.md)<br/>
<img src="hashMapStatus.jpg" width="50%" height="50%"><br/>



Answers are in the 'answer' branch. 



