# Lesson 1

#### 1.1 Moving around using VIM Bindings
	  ^
	  |  K
< ----     -------> L
h          |   J
	   V

Move: 
left: 'h'
down: 'j'
up: 'k'
right: 'L'


#### 1.2 Exiting Vim
Type : to enter line mode
 :q to exit
 :q! to exit and throw away all unsaved changes 
#### 1.3 Text Editing - Deletion
Type x to delete what the cursor is hovering
#### 1.4 Text Editing - Insertion

How do you edit? So far we've only been learning how to use normal mode which is just using commands and combinations of keys to do stuff. But if we want to edit we have to enter insert mode. Because yk you can't type in normal mode, but in order to switch you type the following keys.

From normal mode type:
i - to go into insert mode

#### 1.5 Text Editing - Appending
a - insert mode but cursor is edits start after where your cursor is (one tick over right)

#### 1.6 Text Editing - Saving a File
 :wq to write changes to file and then quit
 :waq to write changes for all files and quit 

## Summary:
Move around with hjkl
Exit a file and toss away all changes :q
Deleting what cursor is hovering x
All done in normal mode (esc to always go back to normal mode)
Insertion mode i
Append mode (basically insertion mode but editing move after cursor) a
# Lesson 2

#### 2.1 Deletion Commands
Type d to start delete saying deleting words from this the cursor to...
D + Motion: motion being a phrase describing movement

##### Motions
Motions in vim are used to move the cursor around
Examples:
w: moving cursor to the start of the next work
e:  moving cursor to the end of the word
b: move cursor to the end start of the previous word
$: Move cursor to the end of the last word in the sentence
0: Move cursor to the beginning of the first word in the sentence

Question: So how does delete + motions work?
Examples: 
dw: delete all characters from cursor to next word.
de: delete all characters starting from cursor to end of word.
db: delete all characters from cursor to start of previous word.
d$: delete all chars from cursor to end of last word in the sentence.
d0: delete all chars from cursor to start of first word in the sentence.

Before answering that we define delete as an operator meaning it defines an action. In this case d is deleting all letters starting from the cursor to... and you define what is deleted using motions. Think of it as im deleting all letters starting from my cursor (d) to the beginning of the next word (w- exclusive of the first letter next word) 

Follow up you can also define the number of motions by typing a number.

d + number + motion

d2w will delete the next two words relative to the cursor.

#### 2.1 Undo and Redos
u - undo single operation
U - Undo all operations in a sentence
ctrl + r - Redo

## Summary
w: moving cursor to the start of the next work
e:  moving cursor to the end of the word
b: move cursor to the end start of the previous word
$: Move cursor to the end of the last word in the sentence
0: Move cursor to the beginning of the first word in the sentence

d - deletion operator
dd: deletes entire line

dw: delete all characters from cursor to next word.
de: delete all characters starting from cursor to end of word.
db: delete all characters from cursor to start of previous word.
d$: delete all chars from cursor to end of last word in the sentence.
d0: delete all chars from cursor to start of first word in the sentence.

Operator + # + motion, where:
	operation: is the action being done
	#: number of times to do the following motion
	motion: the action of moving/ moving cursor

u: undo last action
U: undo all action on sentence restoring it to original state when entering the line
ctrl + r: redo


# Lesson 3

#### 3.1 The put command
When you use the command dd to delete the line, vim stores the contents in the Vim register (where you copy and paste things im assumming)

p: pasting whatever is in the vim register
Examples and observations:
When you delete an entire line using dd and move your cursor to another line and paste, it pastes the line under the line ur cursor was on. This is only observed when you do dd

 d) Can you learn too?
 b) Violets are blue,
 c) Intelligence is learned,
 a) Roses are red,

When you delete a word (ex: using daw) and paste it, It pastes the word after the cursor and adds a space.

:set nu rnu


#### 3.2 Replace command
To replace a character, move the cursor to the char, type r + the letter you are replacing it with
ex: fix the word below by moving the cursor and typing the command rw

batermelon

### 3.3 Change Operator
The change operator allows you to make edits smoother

Example:
cc: deletes the entire line and puts you in edit mode
ce: deletes all the words starting from your cursor to the end of the word.

this line is gibiouerious and makes no sense, I want to look like the line below me
Notice the combination of a operator and motion again i.e cc.

Try to usingdg ce to correct this sentence.

## Summary
1. p: The put command allows you to put back whatever was just deleted. Works by pasting whatever is in the vim register (used for copying words into and later pasting). When you delete in vim it automatically puts whatever you deleted into the register.
	A unique behavior is when you use the command dd to delete an entire line. This operation deletes and also copies the entire lin into the VIM REGISTER, and when you put using (p) the line goes below where your cursor hovers.

Try:
---> d) Can you learn too?
---> b) Violets are blue,
---> c) Intelligence is learned,
---> a) Roses are red,

2. r - 'char': replaces letter you are hovering with 'char'

3. c: change operator allows you to replace all the characters from starting from your cursor to wherever your motion defines e.g w (start of next word) $ (last letter in the sentence)

format for change operator is 
c + # + motion

examples:
cc: change entire line
ce: change from cursor to end of word
c$: change from cursor to end of sentence


# Lesson 4

#### 4.1 Cursor Location and File Status

ctrl - g: To get the current file directory and line your cursor is currently on
example:
```bash
"/private/var/folders/8l/bhp2y1wd14q5xr6b7mcxkqcm0000gn/T/tutorOKK6Kp" [Modified] line 592 of 972 --60%-- col 1
```
1. file path
2. Current line
3. Total lines
4. Relative percentage
5. which column ur cursor is in

gg: To go to the top of the file
G: to goto the bottom of the file

'line number' + G: goto specified line

#### 4.2 The Search Command
##### Search Forward
To search for a word or phrase in normal mode:
type '/' followed by the word or phrase and hit enter

##### When searching checking next and prev occurrence
You can then search for the next occurrence by typing n.
To go the other way type N

To search backward same format as '/' instead using '?'

#### 4.3 Matching Parentheses Search
For the following characters '[ ]', '{ }' and '( )' you can find the corresponding pair by hovering over one of characters and using the command '%'.

---> This ( is a test line with ('s, ['s ] and {'s } in it. ))

This is an extremely helpful tool when debugging to find matching and mismatched brackets/braces/parentheses

#### 4.4 The substitute command
The substitute command format ':s/old/new + optional g'
	:s subsitute
	old- the term being subsituted
	new- the term replacing the old term
	g- a flag that specifics to change all occurrences of old to new in line.

Advaned:
:#,#s/old/new/g - substitutes all occurrence of old with new from line # to #.
:%s/old/new/g - change all occurrences in the file
:%s/old/new/gc - change all occurrences in the file asking for a prompt


## Summary
### Cursor location and file status 
1. 'ctrl + g' reveals the following information
	File directory
	Current line
	Total Line
	Relative current line over total line percentage (i.e percentage of file you're at)
	Cursor current column
2. 'gg' to go to the beginning of the file
3. '[line number]G' to goto the specified line number
4. To search backwards use '?' instead of '/'
5. To go back to where you were before you searched do 'ctrl + g'


### Finding matching brackets
Hover over a bracket and use the command '%' to find matching
### Finding all occurrences
To search for a phrase use the command '/' followed by the word or phrase. To find the next occurrence use the command 'n' and previous 'N'.
### Replacing old with new
1. ':s' is the replace command
2. The following basic format is ':s/old/new'
3. adding the g flag will replace all old occurrences with new
4. To specific lines you want to alter do ':#,#s/old/new/g'
5. To replace all occurrences in the file do ':%s/old/new/g'
6. To replace all occurrences, but each time confirming do ':%s/old/new/gcjkk'

Useful Shortcuts summary:
1. Search for occurrences
2. Replace old with new
3. Finding matching brackets
4. Information about file
5. Moving cursor to beginning, end and specific line
6. Put/paste
7. Deleting + number + motion
8. Overriding + number + motion
9. Replacing with 'r'
10. Undo Redo
11. Append and Insert Mode

# Lesson 5

Using external commands type ':!' followed by the external command

 :w FILENAME to save current file to FILENAME
	 type :!rm FILENAME to get rid of it

To save part of a file
1. highlight part in visual mode
2. Type ' : ' to initiate command line mode (should see <, >)
3. Finally use the w command ':<, >w FILENAME'

To import file content into another page:
1. Move cursor to location
2. :r FILENAME
	 Note you can also do :r !ls read/takes the terminal outputs in puts in below the cursor
:r filename - puts contents of argument below the cursor

# Lesson 6
o - creates a new line below  cur line and puts you in insert mode (opens a new line)
O - upper case o creates a new line above and puts you in insert mode
a - insert after cursor
A - insert after end of line
e - commands cursor to end of word
R - upper base r to start continuously typing to replace/override letters
y - yank which is to copy
	You can use visual mode to highlight and copy the highlighed
	Instead of highlihgting using y as an operator and motions
		y + 'motion'
		to copy into clipboard outside vim " + y
		yy to yank entire line
Using :set to configure options
	Context of searching setting the follow
		:set ic - ignore case
		:set hls (abrev for hlsearch) - highlights what you're searching for
			disable doing :nohlsearch
		set is (abrev for incsearch) - searches for partial matches for a phrase
	prepend no to set an option off
			