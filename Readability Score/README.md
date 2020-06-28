Description
Ever wonder, how to estimate if the text is hard or easy to read? This is pretty easy for a human - you just read the text and feel if you struggling or not. But how to teach the computer to do that? In this project, you will write such a program.

Firstly, let's create a simple one. If the text contains more than 100 symbols (including spacebars and punctuation) then the text is considered hard to read. Else, the text is considered easy to read. If the text contains exactly 100 symbols then it is still easy to read.

The input contains a single line with text. Output "HARD" if the text is hard to read and "EASY" if the text is easy to read.


Work on project. Stage 2/4: Words and sentences

Description

But the real text can be pretty long and still can be easy to read isn't it? There need to be done another approach. How about calculating a number of words in each sentence? Clearly, if each sentence of the text contains a lot of words then this text is hard to read.

Let's suppose that if the text contains on average more than 10 words per sentence, then this text is hard to read. Otherwise, this text is easy to read. Don't worry, we will consider more scientific ways in the next stages.

The input contains a single line with text. Output "HARD" if the text is hard to read and "EASY" if the text is easy to read.

For example, the first example contains two sentences with 6 and 10 words (numbers also counts as words) so the average is 8 and this is less than 10. In the second example, there is also 2 sentences but with 6 and 16 words so the average is 11 and this is greater than 10. If the average is equal to 10 then the text is still considered easy to read.

Don't forget that the sentences can end with a dot as well as with an exclamation mark and a question mark. But the last sentence can be with or without a punctuation character at the end.


Work on project. Stage 3/4: Score!

Description
In this stage, you will program the Automated readability index. It was introduced in 1968 and a lot of research works rely on this.The index is calculated by the following formula:

score = 4.71 \times \dfrac{characters}{words} + 0.5 \times \dfrac{words}{sentences} - 21.43score=4.71× 
words
characters
​	
 +0.5× 
sentences
words
​	
 −21.43

You can look at different ages corresponding to the different scores by the table in this article.

Also, your program should read a file instead of typing a text manually. You should pass the filename through the command line arguments.

The program should output the score itself and an approximate age needed to comprehend the text.
Use rounding function to calculate the score as integer.

You should also print how many characters, words, and sentences the text has.

The number of characters is any visible symbol (so, in the real text it's everything except space, newline "\n" and tab "\t").

Notice, that the text can contain multiple lines, not just a single line like in the previous stages. You should analyze all the lines.

Work on project. Stage 4/4: More parameters

Description
In this stage, you should implement various other scientific approaches to calculate a readability score.

You can look at different ages corresponding to the different scores by the table in this article. This table is suitable for all the algorithms described in this stage. To calculate the age use upper bound of the range. For example, if the range is 12-13 year olds then it's upper bound is 13 year olds.

The first one is Flesch–Kincaid readability tests. To calculate this, you also need to create a method that calculates a number of syllables in a word. The formula is listed below. You can learn more here. You can use the second formula to calculate the index - it allows you to easily calculate the age of a person using the same table from the Automated Readability Index.

score = 0.39 * \dfrac{words}{sentences} + 11.8 * \dfrac{syllables}{words} - 15.59 score=0.39∗ 
sentences
words
​	
  +11.8∗  
words
syllables
​	
 −15.59 
The second one is SMOG index. It stands for Simple Measure of Gobbledygook. To calculate this, you need to count the number of polysyllables which is the number of words with more than 2 syllables. The formula is shown below. You can find out more here. The Wikipedia page says that at least 30 sentences are required for this index to work properly. Don't pay attention to this, just keep it in mind when you use this index in real life. As in the previous example, the grade level is calculated here, so to get the age of a person you need to use the table from the first link.

score = 1.043 * \sqrt{polysyllables * \dfrac{30}{sentences}} + 3.1291score=1.043∗ 
polysyllables∗ 
sentences
30
​	
 
​	
 +3.1291
The next one is Coleman–Liau index. The formula is shown below. You can find out more here. L is the average number of characters per 100 words and S is the average number of sentences per 100 words. Like all other indexes, the output is a person's grade level. Like all other indexes, the result is a minimum grade level of the person needed to understand this text.

score = 0.0588 * L - 0.296 * S - 15.8score=0.0588∗L−0.296∗S−15.8
So, in this stage, you should program all three approaches. Don't forget about the Automated readability index - it should also be here. Also, there should be an option to choose all methods at the same time.

To count the number of syllables you should use letters a, e, i, o, u, y as vowels. You can see here examples and difficulties with determining vowels in a word with 100% accuracy. So, let's use the following 4 rules:

1. Count the number of vowels in the word.
2. Do not count double-vowels (for example, "rain" has 2 vowels but is only 1 syllable)
3. If the last letter in the word is 'e' do not count it as a vowel (for example, "side" is 1 syllable) 
4. If at the end it turns out that the word contains 0 vowels, then consider this word as 1-syllable.
