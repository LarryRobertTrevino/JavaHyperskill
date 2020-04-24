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
