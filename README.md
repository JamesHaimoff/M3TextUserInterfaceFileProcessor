# M3TextUserInterfaceFileProcessor

# Refactoring Plan and Class Improvements (By James Haimoff, Daniel Davis, and Christian Abrimian)

## Identify areas of your code that need improvement by breaking it into smaller, more specialized pieces (refactoring)

When I began working on milestone 3, I noticed that it was very difficult to access the specific tasks individually. Our code has 3 different selections, one for statistical analysis, sentiment analysis, and an article richness comparison. In trying to put together a menu that is when I noticed the specific issues and faults in the architecture of my code. 

To begin there was a lot of unnecessary dependency on certain classes. Furthermore it was incredibly difficult to extract specific things from a class. Each class essentially performs a specific fixed task, however it is confusing what classes you need to run before that class can work properly. 

Firstly all of the classes rely on the reading files class to clean and set the files up properly for step 2. The issue is that when using other classes there is no way of knowing that you need to run that first. 

The first thing I would implement is an automatic call of reading files in my Statistics class, so that I don't have to run that separately and then input the results of that into the class. That is also the case for my calculations class.

Furthermore I want to split up all of the tasks of classes into distinct methods that are easy to manage and modify. The reason being is that when I was trying to modify my code it was hard because I was constantly breaking things that shouldn't have stopped working. I need to ensure that each class has a clear list of methods that perform different things.

Overall I need to integrate necessary preprocessing tasks into each class that makes method calls seamless not depending on unknown dependencies. Also I really need to go into my code and split it up so that there is a single task completed in each function, not all functions being done in a single class which makes it very difficult to manage and change to be honest. 

---

## List the classes in your program that should be modified or reorganized to make the code cleaner, easier to understand, and more maintainable
- Calculations
- positiveNegative
- Statistics

---

## Explain why each class needs improvement, giving at least one specific reason for each

For example, maybe a class does too many things (violating the "Single Responsibility Principle") or is hard to understand because it has overly complex methods.

To begin in calculations this class should have multiple methods instead of one, maybe one for displaying the calculations. Furthermore it should also automatically integrate another method like cleaning the words as it's necessary for this to function properly and any other class dependency must be called within this class instead of dealing with that in other locations as it makes it very difficult to modify the class without that foundational understanding. 

Next the handler class only has one method which is a major issue. I need to separate the methods especially for display. Also I need to change this code to reflect necessary preprocessing steps that happen automatically when calling this function because it is unclear and makes this class problematic when calling. 

Furthermore with statistics class we are facing similar issues. This class has the same dependency problem, and the class is well built, the issue is just the display. It limits the display to be all or none, I should split up the statistical display into different methods while integrating the code without confusion.



Screenshots of Code Performance and Output and UML
![src](https://github.com/user-attachments/assets/ef299337-084e-433b-9ce5-83de96ea10d9)



![Screenshot 2024-11-26 131830](https://github.com/user-attachments/assets/7c01d93f-2874-4ea2-8107-7a75de3e0bb6)

![Screenshot 2024-11-26 120901](https://github.com/user-attachments/assets/fa6ebff2-a081-489c-8e91-08d98b4868e0)

![Screenshot 2024-11-26 120654](https://github.com/user-attachments/assets/74a9e7e4-1bc3-4c4c-b839-c2370335fcd3)
![Screenshot 2024-11-26 120632](https://github.com/user-attachments/assets/972fe804-e284-42b1-9ef9-e67431c63d9c)
