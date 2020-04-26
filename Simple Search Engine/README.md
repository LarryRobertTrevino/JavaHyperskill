Work on project. Stage 1/6: String theory

Description

Let's implement the simplest search engine possible - it should search a specific word from the line containing different words.

The first line contains several words separated by a space. The words are numbered in order, with the first word having index 1. Consider that all the words in the first line are unique, so there can be no repetitions.

Write a small program that reads a single line and then another line — the word to search for in the first line. The program must output the number of this word from the first line. If there is no such word in the first line, the program should print "Not Found". Remember, that indexes start from 1!

You should output exactly one line.

Work on project. Stage 2/6: Expand the search

Description

Write a program that reads text lines from the standard input and processes queries consisting of a single word to search for. The program must output all lines which contain the string from the query.

You may choose what the text represents in your project. For example, each line may describe:

a person, represented by a first name, last name, and an optional email;

an address of a building, represented by country, city, state, street, and zip code;

information about a book, represented by ISBN, title, author/authors, publisher, and so on.

You can take any of these ideas or use your own, but it is important to work with the same type of dataset throughout all stages of the project. As item delimiters, you can use spaces, commas (see CSV), or any other character.

Here is an example of a line. It contains three items: first name, last name and email of a person.

Elsa Sanders elsa@gmail.com
In this example, all items are separated by spaces.

The search should ignore the case of letters and all the extra spaces.

So, firstly the user should input a number N - number of lines with data he is going to enter next. Then the user enters N lines with data. After that, the user enters a number M - number of searches queries. And after each query, the program should print the information it managed to find among the data. You can see this searching process in the example below.

Work on project. Stage 3/6: User menu

Description

Modify the previous program. At this stage, you need to add a user menu.

The menu should display the following actions:

1. Search information.
2. Print all data.
0. Exit.
The user must select a menu item and then enter data if necessary. Your program must not stop until the corresponding option (the exit option) is chosen.

Decompose the program into separate methods to make it easy to understand and add to or edit later.

Work on project. Stage 4/6: X-files

Description

Modify the program. The program should read data from a text file instead of the standard input. The file structure depends on your text’s meaning (personal information, building information, book information, and so on). See an example below..

Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
Katie Jacobs
Erick Harrington harrington@gmail.com
Myrtle Medina
Erick Burgess
The program must process the command line argument --data, after which the name of the file with the data goes. For example, --data text.txt.

Note, the file should not include the total number of lines. All lines must be read only once at the start of your program.

Work on project. Stage 5/6: Inverted Index search

Description

Now your program can successfully search for all matching lines, ignoring cases and extra spaces. But there is one problem: you always need to check whether each line contains a query string or not.

To optimize your program you can use a data structure called Inverted Index. It maps each word to all positions/lines/documents in which the word occurs. As a result, when we receive a query, we can immediately find the answer without any comparisons.

At this stage, build an inverted index when the program starts, and then use the index for searching operations. You can implement it using a Map that maps an item of a line to a list (or set) of indexes of lines which contain the item.

Suppose you have the following array or list of lines:

0: Katie Jacobs
1: Erick Harrington harrington@gmail.com
2: Myrtle Medina
3: Erick Burgess
For these lines, the inverted index will look like the following:

Katie -> [0]
Jacobs -> [0]
Erick -> [1, 3]
Harrington -> [1]
harrington@gmail.com -> [1]
Myrtle -> [2]
Medina -> [2]
Burgess -> [3]
The order of pairs is not important. If you are searching for Erick, you can immediately get the target fields using this mapping.

Note that the Inverted Index is not intended to search for parts of a word, it is only used to search for full words.

Work on project. Stage 6/6: Search strategies

Description

Now,  improve your search engine to support complex queries containing a sequence of words and a strategy that determines how to match data.

There are six sample lines:

Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
Katie Jacobs
Erick Harrington harrington@gmail.com
Myrtle Medina
Erick Burgess
Let's consider the searching strategies: ALL, ANY and NONE.

If the strategy is ALL, the program should print lines containing all words from the query.
Query:

Harrington Erick
Result:

Erick Harrington harrington@gmail.com
 
 
If the strategy is ANY, the program should print lines containing at least one word from the query.
Query:

Erick Dwight webb@gmail.com
Result:

Erick Harrington harrington@gmail.com
Erick Burgess
Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
 

If the strategy is NONE, the program should print lines that do not contain words from the query at all:
Query:

djo@gmail.com ERICK
Result:

Katie Jacobs
Myrtle Medina
Rene Webb webb@gmail.com

All listed operations are implemented in the inverted index. The results should not contain duplicates.
Note, do not forget to use methods to decompose your program.
